package com.mashiverse.mashit.ui.screens.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mashiverse.mashit.data.models.colors.SelectedColors
import com.mashiverse.mashit.data.models.traits.TraitDetails
import com.mashiverse.mashit.data.models.traits.TraitType
import com.mashiverse.mashit.data.states.image.ImageIntent
import com.mashiverse.mashit.ui.images.DefaultImage
import com.mashiverse.mashit.ui.theme.Primary
import com.mashiverse.mashit.ui.theme.TraitShape

@Composable
fun ProfileComposite(
    modifier: Modifier = Modifier,
    assets: List<TraitDetails>,
    colors: SelectedColors? = null,
    processImageIntent: (ImageIntent) -> Unit,
    holderWidth: Dp
) {
    Box(
        modifier = modifier
            .width(holderWidth)
            .clip(TraitShape),
        contentAlignment = Alignment.Center
    ) {
        if (assets.none { it.url != null } || assets.isEmpty()) {
            LoadingIndicator(color = Primary)
        } else {
            assets.sortedBy { it.type }.forEach { trait ->
                val traitType = trait.type
                if (traitType != TraitType.BACKGROUND) {
                    DefaultImage(
                        modifier = Modifier.aspectRatio(380/600F),
                        selectedColors = colors,
                        data = trait.url ?: "",
                        contentScale = ContentScale.Fit,
                        processImageIntent = processImageIntent
                    )
                }
            }
        }
    }
}