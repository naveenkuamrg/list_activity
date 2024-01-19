//package com.example.listviewactivity
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.widget.FrameLayout
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import android.view.ViewGroup as ViewGroup1
//
//class RecycleViewModel2 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.test)
//////
////        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
////        recyclerView.layoutManager = LinearLayoutManager(this)
//////
////        val dataList = (0 until 60000).map { "TextView $it" }
////        val adapter = MyAdapter(dataList)
//////
////        recyclerView.adapter = adapter
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.framelayout)
////
//        val frameLayout = findViewById<FrameLayout>(R.id.newLayoutFRaa)
//
//        val dataList = (0 until 1).map { "TextView $it" }
//
//        for (i in dataList.indices) {
//            val la =findViewById<TextView>(R.id.textView)
//            print(la)
//            // Set layout parameters if needed
//            frameLayout.addView(la)
//        }
//
////        val frameLayout = FrameLayout(this)
////
////        for (i in 0 until 60000) {
////            val textView = TextView(this)
////            textView.text = "TextView $i"
////
////            frameLayout.addView(textView)
////        }
////        setContentView(frameLayout)
//    }
//    }
//    class MyAdapter(private val data: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
//
//        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val textView: TextView = itemView.findViewById(R.id.textView)
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup1, viewType: Int): ViewHolder {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_textview, parent, false)
////            val view = TextView(parent.context)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.textView.text = data[position]
//        }
//
//        override fun getItemCount(): Int {
//            return 1000
//        }
//    }