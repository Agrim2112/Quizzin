package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quizapp.R.id.normalmode as normalmode

class Mode : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var Name:String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)

        Name=intent.getStringExtra(SetData.name)
        val normal = findViewById<TextView>(R.id.normalmode)
        val timed = findViewById<TextView>(R.id.timed)

        normal.setOnClickListener()
        {
            val intent = Intent(this,Question1::class.java)
            intent.putExtra(SetData.name,Name.toString())
            startActivity(intent)
        }

        timed.setOnClickListener()
        {
            val intent = Intent(this,Question2::class.java)
            intent.putExtra(SetData.name,Name.toString())
            startActivity(intent)
        }

    }
}