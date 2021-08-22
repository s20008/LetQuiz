package jp.ac.it_college.s20008.android.letquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val correctCount = intent.getStringExtra(Constants.CORRECT_COUNT)
        val wrongCount = intent.getStringExtra(Constants.WRONG_COUNT)

        result_text2.text = "おめでとう、あなたの成績は："
        result_count.text = "正解数${correctCount}，間違い数${wrongCount}"

        result_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
