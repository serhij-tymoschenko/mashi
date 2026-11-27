package com.example.app.time

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

val DayMonthYearFormat: DateTimeFormat<LocalDate> = LocalDate.Format {
    day()
    char('.')
    monthNumber()
    char('.')
    year()
}

fun Long.toDmyTimeFormat(
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): String = Instant.fromEpochMilliseconds(this)
    .toLocalDateTime(timeZone)
    .date
    .format(DayMonthYearFormat)