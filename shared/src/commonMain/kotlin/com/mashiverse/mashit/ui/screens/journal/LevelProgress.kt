package com.mashiverse.mashit.ui.screens.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.time.toDmyTimeFormat
import com.mashiverse.mashit.ui.theme.ContentAccentColor
import com.mashiverse.mashit.ui.theme.ContentColor
import com.mashiverse.mashit.ui.theme.Surface
import org.koin.core.logger.Level

@Composable
fun LevelProgress(
    modifier: Modifier = Modifier,
    username: String,
    level: Int,
    ts: Long
) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(24.dp))
            .background(Surface)
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("User obtained Level $level!", color = ContentAccentColor, fontSize = 16.sp)
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(ts.toDmyTimeFormat(), color = ContentColor, fontSize = 14.sp)
        }
    }
}

