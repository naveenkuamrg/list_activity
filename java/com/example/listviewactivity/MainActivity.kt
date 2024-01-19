//package com.example.listviewactivity
//
//import android.content.Context
//import android.content.Intent
//import android.content.pm.ApplicationInfo
//import android.content.pm.PackageInfo
//import android.graphics.Color
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.BaseAdapter
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.ListView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat.startActivity
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val numbers = mutableListOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
//        for(i in 10..1000){
//            numbers.add(i.toString())
//        }
//
//
//
//        val listView = ListView(this)
//        val layout = LinearLayout(this).apply {
//            addView(Button(this@MainActivity).apply {
//                text = "new Activity"
//                setOnClickListener {
//                    val intent = Intent(this@MainActivity,SecondActivity :: class.java)
//                    startActivity(intent)
//                }
//            })
//            orientation = LinearLayout.VERTICAL
//            addView(listView)
//            addView(TextView(this@MainActivity))
//
//        }
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//
//            Log.i("ItemOnClickListener","String $position")
//            val intent = Intent(this@MainActivity,SecondActivity :: class.java)
//            intent.putExtra("itemNumber",numbers[position])
//            startActivity(intent)
//            val cView = view as TextView
//            cView.setTextColor(Color.RED)
//            cView.setBackgroundColor(Color.CYAN)
//        }
//
////        val adapter = CustomNumberAdapter(this, numbers)
//        val adapter = ArrayAdapter<String>(this,R.layout.iteam,R.id.updateView,numbers)
//        val cAdapter = CustomArrayAdapter(numbers)
//        listView.adapter = cAdapter
//
//        setContentView(layout)
//
//
////        setContentView(R.layout.activity_main)
//        var view = findViewById<TextView>(R.id.test)
//        view.setBackgroundColor(Color.CYAN)
//    }
//
//
//
//}
//
//class CustomTextView(context : Context) : androidx.appcompat.widget.AppCompatTextView(context) {
//    companion object{
//        var count =  0
//    }
//    init {
//        Log.i("Sout",CustomTextView.count.toString())
//        CustomTextView.count += 1
//    }
//
//
//}
//
//class CustomArrayAdapter(val numbers : List<String>) : BaseAdapter() {
//    override fun getCount(): Int {
//       return  numbers.count()
//    }
//
//    override fun getItem(position: Int): String {
//       return  numbers[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//
//        return  position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        Log.i("SoutId",getItemId(position).toString())
//        return CustomTextView(parent.context).apply {
//            text = getItem(position)
//
//
//        }
//    }
//
//
//
//
//
//}
//
//
//
