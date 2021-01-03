package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.homework.uilistshomework.databinding.ItemType1Binding
import com.homework.uilistshomework.databinding.ItemType2Binding
import com.homework.uilistshomework.databinding.ItemType3Binding

class Adapter(activity: MainActivity): ListAdapter<Item, BaseViewHolder>(ItemDiffCallBack()) {

    var list = mutableListOf<Item>()

    val mainActivity : MainActivity = activity

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

    inner class Type1ViewHolder(private val binding: ItemType1Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type1) {
            binding.textViewType1.text = item.typeName

            binding.closeImageType1.setOnClickListener {
                val position: Int = adapterPosition
                mainActivity.itemDeleteClicked(position)
                notifyItemRemoved(position)
            }
        }
    }

    inner class Type2ViewHolder(private val binding: ItemType2Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type2) {
            binding.textViewType2.text = item.typeName

            binding.closeImageType2.setOnClickListener {
                val position: Int = this.adapterPosition
                mainActivity.itemDeleteClicked2(position)
                notifyItemRemoved(position)
            }
        }
    }

    inner class Type3ViewHolder(private val binding: ItemType3Binding): BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup): this (
            ItemType3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Type3) {
            binding.textViewType3.text = item.typeName

            binding.closeImageType3.setOnClickListener {
                val position: Int = this.adapterPosition
                mainActivity.itemDeleteClicked2(position)
                notifyItemRemoved(position)
            }
        }
    }
}

class ItemDiffCallBack : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.javaClass == newItem.javaClass
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}