package com.roy93group.libresudoku.core

import androidx.annotation.Keep

@Keep
data class Note(
    val row: Int,
    val col: Int,
    val value: Int,
)
