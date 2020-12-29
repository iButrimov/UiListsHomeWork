package com.homework.uilistshomework

import android.content.Context

object MockUtil {

    fun getFirstList(context: Context, size: Int): MutableList<Item> {
        val sampleList: MutableList<Item> = mutableListOf()

        for(n in 1..size) {
            sampleList.add(Item.Type1(n, "Element $n of type 1"))
        }

        return sampleList
    }

    fun getSecondList(context: Context, size: Int): MutableList<Item> {
        val sampleList: MutableList<Item> = mutableListOf()

        for(n in 1..size) {
            sampleList.add(Item.Type2(n, "Element $n of type 2"))
            sampleList.add(Item.Type3(n, "Element $n of type 3"))
        }

        return sampleList
    }
}