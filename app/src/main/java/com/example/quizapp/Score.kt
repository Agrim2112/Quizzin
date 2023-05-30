package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val input = intent.getStringExtra(SetData.name)
        val score = intent.getStringExtra(SetData.score)
        val textview8=findViewById<TextView>(R.id.textView8)
        val textview11=findViewById<TextView>(R.id.textView11)

        textview8.text="Congratulations, $input!"
        textview11.text="$score"
    }
}