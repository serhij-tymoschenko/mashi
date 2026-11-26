package com.mashiverse.mashit.ui.screens.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mashiverse.mashit.data.local.db.entities.ImageTypeEntity
import com.mashiverse.mashit.data.models.image.ImageType
import com.mashiverse.mashit.data.models.mashup.MashupDetails
import com.mashiverse.mashit.data.remote.MashiApi
import com.mashiverse.mashit.data.repos.CollectionRepo
import com.mashiverse.mashit.data.repos.DatastoreRepo
import com.mashiverse.mashit.data.repos.HistoryRepo
import com.mashiverse.mashit.data.repos.ImageTypeRepo
import com.mashiverse.mashit.data.states.image.ImageIntent
import com.mashiverse.mashit.data.states.profile.ProfileUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(
    datastoreRepo: DatastoreRepo,
    private val collectionRepo: CollectionRepo,
    private val historyRepo: HistoryRepo,
    private val mashiApi: MashiApi,
    private val imageTypeRepo: ImageTypeRepo
) : ViewModel() {
    val profileUiState = mutableStateOf(ProfileUiState())

    private val walletFlow = datastoreRepo.walletFlow

    init {
        observeWallet()
    }

    private fun observeWallet() {
        viewModelScope.launch(Dispatchers.IO) {
            walletFlow.distinctUntilChanged().collect { wallet ->
                if (wallet.isNotEmpty()) {
                    val initialMashup = collectionRepo.getCachedMashup(wallet) ?: MashupDetails()
                    profileUiState.value = profileUiState.value.copy(mashupDetails = initialMashup)
                }
            }
        }
    }

    // Images
    fun getImageType(url: String, onResult: (ImageType?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var result = imageTypeRepo.getImageType(url)?.type
                if (result == null) {
                    val type = mashiApi.getImageType(url.split("/").last())
                    imageTypeRepo.insertImageType(imageTypeEntity = ImageTypeEntity(url, type))
                    result = type
                }
                withContext(Dispatchers.Main) {
                    onResult(result)
                }
            } catch (e: Exception) {
                println("⚠ Failed to fetch image type for $url: ${e.message}")
                withContext(Dispatchers.Main) {
                    onResult(null) // Prevent crash and notify caller of failure
                }
            }
        }
    }

    fun processImageIntent(intent: ImageIntent) {
        when (intent) {
            is ImageIntent.OnTypeGet -> getImageType(intent.url, intent.onResult)
        }
    }
}