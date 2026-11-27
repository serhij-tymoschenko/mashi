package com.mashiverse.mashit.ui.screens.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mashiverse.mashit.ui.theme.Background
import com.mashiverse.mashit.ui.theme.ContentAccentColor
import com.mashiverse.mashit.ui.theme.Padding
import com.mashiverse.mashit.ui.theme.Surface

@Composable
fun Journal() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Background)
            .padding(horizontal = Padding),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                Text("@xc.serhii", fontSize = 24.sp, color = ContentAccentColor)
                Text("'s journey!", fontSize = 24.sp, color = ContentAccentColor)
            }

            LevelProgress(
                modifier = Modifier.fillMaxWidth(),
                username = "@xc.serhii",
                level = 40,
                ts = 1795759184499
            )
        }
    }
}

@Preview
@Composable
fun JournalPreview() {
    Journal()
}