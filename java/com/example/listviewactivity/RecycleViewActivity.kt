package com.example.listviewactivity

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.ArrayList

class RecycleViewActivity: ComponentActivity() {

    data class ListNumber(val number: Int, var isSelected: Boolean)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val numberList = mutableListOf<ListNumber>()

        for(i in 0..1000){
            numberList.add(ListNumber(i, false))
        }

        val adapter = CustomAdapter(numberList,this)
        val recycleView = RecyclerView(this).apply {
            setAdapter(adapter)
            layoutManager = GridLayoutManager(this@RecycleViewActivity,3).apply {
                orientation = RecyclerView.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }


        }
        val layout = LinearLayout(this).apply {
            addView(Button(this@RecycleViewActivity))
            addView(recycleView)
            orientation = LinearLayout.VERTICAL
        }

        setContentView(layout)
    }

}

class TextViewHolder(val itemViews : LabelLayout ) : RecyclerView.ViewHolder(itemViews)
class CustomAdapter<T>(val items : List<T>,val context : Context) : RecyclerView.Adapter<TextViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        Log.i("NEWTAG","CREATE")
      return TextViewHolder(LabelLayout(context))
    }

    override fun getItemCount(): Int {
       return  items.count()
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
//        holder.itemViews.textView.setBackgroundColor(Color.WHITE)
        holder.itemViews.textView.text = (items[position] as RecycleViewActivity.ListNumber).number.toString()
        holder.itemViews.textView.setOnClickListener {
            (items[position] as RecycleViewActivity.ListNumber).isSelected = true
            notifyDataSetChanged()
        }

        if((items[position] as RecycleViewActivity.ListNumber).isSelected) {
            holder.itemViews.textView.setBackgroundColor(Color.CYAN)
            holder.itemViews.textView.text = "click"
        } else {
            holder.itemViews.textView.setBackgroundColor(Color.WHITE)
        }


    }



}

class LabelLayout(context : Context) : LinearLayout(context){
    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }
    val textView = TextView(context).apply {

        setOnClickListener {
            setBackgroundColor(Color.CYAN)
        }
        this@LabelLayout.addView(this)
    }
}
