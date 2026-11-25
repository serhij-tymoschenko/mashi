package com.mashiverse.mashit.ui.indicators


import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.mashiverse.mashit.ui.theme.Primary
import mashi.shared.generated.resources.Res
import mashi.shared.generated.resources.sync
import org.jetbrains.compose.resources.painterResource

@Composable
fun SyncIndicator(modifier: Modifier = Modifier) {
    val visibilityProgress = rememberInfiniteTransition().animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                666
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Icon(
        modifier = modifier.alpha(visibilityProgress.value),
        painter = painterResource(Res.drawable.sync),
        contentDescription = null,
        tint = Primary
    )
}