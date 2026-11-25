package com.mashiverse.mashit.ui.theme

object ColorsProvider {
    private var isLight = false

    val Primary = if (isLight) LightPrimary else DarkPrimary
    val Background = if (isLight) LightBackground else DarkBackground
    val Surface = if (isLight) LightSurface else DarkSurface
    val Secondary = if (isLight) LightSecondary else DarkSecondary
    val ButtonBackground = if (isLight) LightButtonBackground else DarkButtonBackground
    val ActiveButtonBackground = if (isLight) LightActiveButtonBackground else DarkActiveButtonBackground
    val ContentColor = if (isLight) LightContentColor else DarkContentColor
    val ContentAccentColor = if (isLight) LightContentAccentColor else DarkContentAccentColor

    fun setTheme(isLight: Boolean) {
        ColorsProvider.isLight = isLight
    }
}