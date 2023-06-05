package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.Locale
import java.util.concurrent.TimeUnit

class Question2 : AppCompatActivity() {

    private var currentpos : Int=1
    private var questionList:ArrayList<QuestionModel>?=null
    private var selectedoption : Int = 0

    private var timeselected: Int = 20
    private var timecountdown : CountDownTimer?=null
    private var timeprogress = 0
    private var pauseoffset : Long=0
    private var isstart = true

    private val questionno: TextView
        get() = findViewById(R.id.questionno)
    private val question: TextView
        get() = findViewById(R.id.question)
    private val option1: Button
        get() = findViewById(R.id.option1)
    private val option2: Button
        get() = findViewById(R.id.option2)
    private val option3: Button
        get() = findViewById(R.id.option3)
    private val option4: Button
        get() = findViewById(R.id.option4)
    private val sub: TextView
        get() = findViewById(R.id.submit)
    private val time: TextView
        get() = findViewById(R.id.textView4)
    private val prog: ProgressBar
        get() = findViewById(R.id.progressBar)


    private var Name:String?=null
    private var score: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        Name=intent.getStringExtra(SetData.name)

        questionList = SetData.getQuestion()

        SetQuestion()
        countdown()

//        starttimer(pauseoffset)

        option1.setOnClickListener()
        {
            SelectedOption(option1,1)
        }

        option2.setOnClickListener()
        {
            SelectedOption(option2,2)
        }

        option3.setOnClickListener()
        {
            SelectedOption(option3,3)
        }

        option4.setOnClickListener()
        {
            SelectedOption(option4,4)
        }

        sub.setOnClickListener()
        {
            pause()


            if(selectedoption!=0)
            {
                val q= questionList!![currentpos-1]

                if(selectedoption!=q.correctans)
                {
                    SetColour(selectedoption,R.drawable.wrongans)
                }
                else
                {
                    score++
                }
                SetColour(q.correctans,R.drawable.correctans)

                if(currentpos==questionList!!.size)
                {
                    sub.text="RESULTS"
                    sub.setOnClickListener()
                    {
                        val intent = Intent(this,Score::class.java)
                        intent.putExtra(SetData.name,Name.toString())
                        intent.putExtra(SetData.score,score.toString())
                        startActivity(intent)
                    }
                }
                else
                {
                    sub.text="NEXT"
                }

            }
            else
            {
                currentpos++
                if(currentpos<=questionList!!.size)
                {
                    countdown()
                    SetQuestion()

                }
            }
            selectedoption=0
    }
}

    fun countdown(){

        timecountdown= object :CountDownTimer (20000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {

                prog.progress=timeprogress
                var sDuration:String= String.format(
                    Locale.ENGLISH,
                    "%2d",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))
                time.text = sDuration

            }

            override fun onFinish() {
                currentpos++
                if (currentpos<questionList!!.size){
                    SetQuestion()
                    SetOptionStyle()
                    countdown()
                }
                else{
                    result()
                }
            }

        }.start()
    }


    private fun pause()
    {
        if(timecountdown!=null)
        {
            timecountdown!!.cancel()
        }
    }

    fun SetColour(opt: Int,color: Int)
    {
        when(opt)
        {
            1->{
                option1.background= ContextCompat.getDrawable(this,color)
            }
            2->{
                option2.background= ContextCompat.getDrawable(this,color)
            }
            3->{
                option3.background= ContextCompat.getDrawable(this,color)
            }
            4->{
                option4.background= ContextCompat.getDrawable(this,color)
            }

        }

    }


    fun SetQuestion()
    {
        val q = questionList!![currentpos-1]
        SetOptionStyle()

        questionno.text=q.questionno
        question.text=q.questions
        option1.text=q.option_one
        option2.text=q.option_two
        option3.text=q.option_three
        option4.text=q.option_four
        sub.text=q.submission
    }

    fun SetOptionStyle()
    {
        var optionlist: ArrayList<Button> = arrayListOf()
        optionlist.add(0,option1)
        optionlist.add(1,option2)
        optionlist.add(2,option3)
        optionlist.add(3,option4)

        for(opn in optionlist)
        {
            opn.setTextColor(Color.parseColor("#FF000000"))
            opn.background= ContextCompat.getDrawable(this,R.drawable.optionbtn)
        }
    }

    fun result()
    {
        val intent = Intent(this,Score::class.java)
        intent.putExtra(SetData.name,Name.toString())
        intent.putExtra(SetData.score,score.toString())
        startActivity(intent)
    }

    fun SelectedOption(view: Button,opt : Int)
    {
        SetOptionStyle()
        selectedoption=opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selectedoption)
        view.setTextColor(Color.parseColor("#FF000000"))
    }


}