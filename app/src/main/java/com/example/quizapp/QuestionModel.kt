package com.example.quizapp

data class QuestionModel (
    var questionno:String,
    var questions : String,
    var option_one:String,
    var option_two:String,
    var option_three:String,
    var option_four:String,
    var correctans: Int,
    var id : Int,
    var submission : String
        )
