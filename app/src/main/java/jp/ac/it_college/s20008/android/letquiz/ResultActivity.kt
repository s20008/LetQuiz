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
        val timer = intent.getStringExtra(Constants.TIMER_COUNT)

        result_text2.text = "お疲れ様、あなたの成績は："
        if(timer == "タイムオーバーです"){
            result_count.text = "タイムオーバーです"
        }else{
            result_count.text = "正解数${correctCount}，間違い数${wrongCount},トータル時間${timer}秒"
        }

        result_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
