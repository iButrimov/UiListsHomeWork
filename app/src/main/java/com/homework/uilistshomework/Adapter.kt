package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.ItemType1Binding
import com.homework.uilistshomework.databinding.ItemType2Binding
import com.homework.uilistshomework.databinding.ItemType3Binding

class Adapter: RecyclerView.Adapter<BaseViewHolder>() {

    var list: List<Item> = emptyList()

    //вызывается при создании новых Holder'ов
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            ITEM_TYPE1 -> Type1ViewHolder(parent)
            ITEM_TYPE2 -> Type2ViewHolder(parent)
            else -> Type3ViewHolder(parent)
        }
    }

    //для установки нового ViewHolder'а. Меняется представление ViewHolder'а
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when(val item = list[position]) {
            is Item.Type1 -> (holder as Type1ViewHolder).bind(item)
            is Item.Type2 -> (holder as Type2ViewHolder).bind(item)
            is Item.Type3 -> (holder as Type3ViewHolder).bind(item)
        }
    }

    //возвращает общее кол-во элементов
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is Item.Type1 -> ITEM_TYPE1
            is Item.Type2 -> ITEM_TYPE2
            is Item.Type3 -> ITEM_TYPE3
        }
    }

    companion object {
        const val ITEM_TYPE1 = 1
        const val ITEM_TYPE2 = 2
        const val ITEM_TYPE3 = 3
    }

    class Type1ViewHolder(private val binding: ItemType1Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type1) {
            binding.textViewType1.text = item.typeName
        }
    }

    class Type2ViewHolder(private val binding: ItemType2Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type2) {
            binding.textViewType2.text = item.typeName
        }
    }

    class Type3ViewHolder(private val binding: ItemType3Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type3) {
            binding.textViewType3.text = item.typeName
        }
    }
}
