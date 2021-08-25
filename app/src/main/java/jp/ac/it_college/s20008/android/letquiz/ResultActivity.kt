package jp.ac.it_college.s20008.android.letquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.ac.it_college.s20008.android.letquiz.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correctCount = intent.getStringExtra(Constants.CORRECT_COUNT)
        val wrongCount = intent.getStringExtra(Constants.WRONG_COUNT)
        val timer = intent.getStringExtra(Constants.TIMER_COUNT)
        val questioncount = intent.getStringExtra(Constants.QUESTION_COUNT)


        binding.resultText1.text = "クリア"
        binding.resultImage.setImageResource(R.drawable.s20008_report)
        binding.resultText2.text = "お疲れ様、あなたの成績は："
        binding.resultCount.text = "正解数${correctCount}，間違い数${wrongCount},トータル時間${timer}秒"
        if (questioncount != null) {
            if (timer != null) {
                if (timer.toLong() == questioncount.toLong() * 10){
                    binding.resultText1.text = "タイムオーバー"
                    binding.resultImage.setImageResource(R.drawable.s20008_lose)
                    binding.resultText2.text = ""
                    binding.resultCount.text = ""

                }
            }
        }

        binding.resultButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
