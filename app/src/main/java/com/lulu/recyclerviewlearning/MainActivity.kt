package com.lulu.recyclerviewlearning

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MyAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv1: TextView = view.findViewById(android.R.id.text1)
        fun bindView(position: Int) {
            tv1.text = "当前是第${position}个条目"
        }
    }
    class MyAdapter(private val activity: MainActivity) : RecyclerView.Adapter<MyHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
            return MyHolder(LayoutInflater.from(activity).inflate(android.R.layout.simple_list_item_1, null))
        }

        override fun getItemCount(): Int {
            return 100
        }

        override fun onBindViewHolder(holder: MyHolder, position: Int) {
            holder.bindView(position)
        }

    }

}