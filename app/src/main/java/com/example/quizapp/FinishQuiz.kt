package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityFinishQuizBinding

class FinishQuiz : AppCompatActivity() {
    private lateinit var binding : ActivityFinishQuizBinding
    private lateinit var score : TextView
    private  lateinit var quitButton: Button
    private lateinit var startquizButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quizQuestions = intent.getParcelableArrayListExtra<QuizQuestion>("quizQuestions")
        println(quizQuestions)



//        [QuizQuestion(question=What is the capital of France?, options=[A. Berlin, B. Madrid, C. Paris, D. Rome], correctAnswer=C. Paris, marks=5, selected=A. Berlin), QuizQuestion(question=Which planet is known as the Red Planet?, options=[A. Venus, B. Mars, C. Jupiter, D. Saturn], correctAnswer=B. Mars, marks=3, selected=C. Jupiter)]

    startquizButton = binding.startquizButton
    quitButton = binding.quitButton
    score = binding.score




    binding.startquizButton.setOnClickListener{
        startActivity(
            Intent(this, QuizActivity::class.java)
        )
        Toast.makeText(this, "The Quiz has been started", Toast.LENGTH_SHORT).show()
        finish()
    }

    binding.quitButton.setOnClickListener{
        startActivity(
            Intent(this, MainActivity::class.java)
        )
        Toast.makeText(this, "The Quiz has been ended", Toast.LENGTH_SHORT).show()
        finish()

    }
        val totalQuestions = quizQuestions?.size ?: 0
        val correctAnswers = quizQuestions?.count { it.selected == it.correctAnswer } ?: 0
        score.text = "$correctAnswers/$totalQuestions"

}
}
