package com.mashiverse.mashit.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mashiverse.mashit.ui.theme.ContentAccentColor
import com.mashiverse.mashit.ui.theme.Padding
import com.mashiverse.mashit.ui.theme.Secondary
import com.mashiverse.mashit.ui.theme.Surface
import org.koin.compose.koinInject

@Composable
fun Profile() {
    val viewModel = koinInject<ProfileViewModel>()
    val profileUiState by remember { viewModel.profileUiState }

    Box(modifier = Modifier.fillMaxSize().padding(horizontal = Padding)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    //modifier = Modifier.size(128.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    ProfileComposite(
                        assets = profileUiState.mashupDetails.assets,
                        colors = profileUiState.mashupDetails.colors,
                        processImageIntent = { i ->
                            viewModel.processImageIntent(i)
                        },
                        holderWidth = 96.dp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text("@xc.serhii", fontSize = 20.sp, color = ContentAccentColor)

                    Text("Serhii Tymoshenko")
                }
            }

            Spacer(modifier = Modifier.height(Padding))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Secondary)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Mashup history")
            }
        }
    }
}