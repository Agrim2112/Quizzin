package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.name)
        val submit = findViewById<Button>(R.id.startquiz)

        submit.setOnClickListener()
        {
            val storedname = input.text.toString()
            if (storedname == "") {
                Toast.makeText(
                    this@MainActivity,
                    "Please, enter your name",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else
            {
                val intent = Intent(this,Mode::class.java)
                intent.putExtra("${SetData.name}",input.text.toString())
            startActivity(intent)
            }
        }
    }
}