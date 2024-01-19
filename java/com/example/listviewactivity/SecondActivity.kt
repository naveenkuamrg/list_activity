package com.example.listviewactivity

import android.app.ActionBar
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.core.view.size
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = List(1000) {
            val index = it + 1 // Number the users starting from 1
            User("User $index", "Description for User $index")
        }
        val usersItemList =  List(1000) {
            UserItem(users.get(it),false)
        }

        val recyclerView = RecyclerView(this).apply {
            adapter = UserRecyclerViewAdapter(this@SecondActivity,usersItemList)
            layoutManager = LinearLayoutManager(this@SecondActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(10,20,10,20)
                }

            }
        }



        setContentView(recyclerView)

    }

}


class UserRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class UserRecyclerViewAdapter(val context: Context,var data : MutableList<UserItem>) : RecyclerView.Adapter<UserRecyclerViewViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRecyclerViewViewHolder {
       return  UserRecyclerViewViewHolder(ItemView(context))
    }

    override fun getItemCount(): Int {
        return  data.count()
    }



    override fun onBindViewHolder(holder: UserRecyclerViewViewHolder, position: Int) {
       val tView = holder.itemView as ItemView
        tView.textView.text = data[position].user.name
        tView.textView1.text = data[position].user.des
        if(data[position].isSelected){
            tView.textView1.visibility = View.VISIBLE
//            if(tView.findViewWithTag<TextView>("des") != null) {
//                tView.addView(TextView(context).apply {
//                    tag = "des"
//                    text = data[position].user.des
//                    layoutParams = LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT
//                    ).apply {
//                        setMargins(30, 10, 10, 10)
//                    }
//
//                })
//            }
            tView.setBackgroundColor(Color.parseColor("#FF9800"))
        }else{
            tView.textView1.visibility = View.INVISIBLE
            tView.setBackgroundColor(Color.TRANSPARENT)
        }
        tView.setOnClickListener {
//            tView.textView.setBackgroundColor(Color.CYAN)
//            Log.i("CLICK","PRESS ${tView.textView.text}")
            data[position].isSelected = !data[position].isSelected
            notifyDataSetChanged()


        }
    }

}


class ItemView(context : Context) : LinearLayout(context){
    val textView = TextView(context).apply {
        this@ItemView.addView(this)
        layoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            setMargins(10,10,10,10)
        }
    }
    val textView1 = TextView(context).apply {
        this@ItemView.addView(this)
        layoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            setMargins(10,10,10,10)
        }
    }
    init {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(20,10,10,10)
        }
        orientation = LinearLayout.VERTICAL
    }

}

