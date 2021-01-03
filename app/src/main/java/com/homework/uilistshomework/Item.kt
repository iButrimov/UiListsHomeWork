package com.homework.uilistshomework

import androidx.recyclerview.widget.DiffUtil

sealed class Item {
    data class Type1(val type: Int, val typeName: String) : Item()
    data class Type2(val type: Int, val typeName: String) : Item()
    data class Type3(val type: Int, val typeName: String) : Item()
}
