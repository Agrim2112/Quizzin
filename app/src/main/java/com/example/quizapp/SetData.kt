package com.example.quizapp

object SetData {

    const val name: String="name"
    const val score : String= "score"
    fun getQuestion():ArrayList<QuestionModel>{
        var que : ArrayList<QuestionModel> = arrayListOf()

        var q1 = QuestionModel(
            "Question 1 out of 5",
            "What parameter specifies the Android API level that Gradle should use to compile your app?",
            "minSdkVersion",
            "compileSdkVersion",
            "targetSdkVersion",
            "testSdkVersion",
            2,
            1,
            "SUBMIT"
        )

        var q2 = QuestionModel(
            "Question 2 out of 5",
            "What phrase means that the compiler validates types while compiling?",
            "Type safety",
            "Data binding",
            "Type validation",
            "Wrong text",
            1,
            2,
            "SUBMIT"
        )

        var q3 = QuestionModel(
            "Question 3 out of 5",
            "Which is a way to restrict direct access to some of an object’s fields?",
            "Inheritence",
            "Polymorphism",
            "Encapsulation",
            "LiveData",
            3,
            3,
            "SUBMIT"
        )

        var q4 = QuestionModel(
            "Question 4 out of 5",
            "Which layout arranges its children in a single column or a single row?",
            "Relative Layout",
            "Absolute Layout",
            "Linear Layout",
            "Grid Layout",
            1,
            4,
            "SUBMIT"
        )

        var q5 = QuestionModel(
            "Question 5 out of 5",
            "Which lifecycle method is called to give an activity focus?",
            "onResume()",
            "onVisible()",
            "onStart()",
            "onFocus()",
            1,
            5,
            "SUBMIT"
        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}