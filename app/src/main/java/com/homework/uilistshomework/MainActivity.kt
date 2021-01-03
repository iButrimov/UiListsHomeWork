package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val adapter1 = Adapter(this).apply {
        list = MockUtil.getFirstList(this@MainActivity, 10)
        submitList(list)
    }
    val adapter2 = Adapter(this@MainActivity).apply {
        list = MockUtil.getSecondList(this@MainActivity, 10)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter1

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == 0) {
                    binding.recyclerView.adapter = adapter1
                } else
                    if (tab?.position == 1) {
                    binding.recyclerView.adapter = adapter2
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }

    fun itemDeleteClicked(position: Int) {
        //val updatedList = adapter1.list
        //updatedList.removeAt(position)
        //adapter1.submitList(updatedList)
        adapter1.list.removeAt(position)
    }

    fun itemDeleteClicked2(position: Int) {
        adapter2.list.removeAt(position)
    }
}
