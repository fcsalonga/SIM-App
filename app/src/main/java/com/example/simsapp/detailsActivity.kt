package com.example.simsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class detailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        val ID = intent.getStringExtra("ID")
        val textView: TextView = findViewById<TextView>(R.id.name)

        textView.text = ID

    }
}
