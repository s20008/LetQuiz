package jp.ac.it_college.s20008.android.letquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import jp.ac.it_college.s20008.android.letquiz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        login_start_button.setOnClickListener {
            if (binding.loginNameInput.text.toString().isEmpty()) {
                Toast.makeText(this, "入力してください", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                val questionCount = binding.loginNameInput.text.toString()
                try {
                    questionCount.toInt()
                    intent.putExtra(Constants.QUESTION_COUNT, questionCount)
                    startActivity(intent)
                    finish()
                }catch (e:Exception) {
                    Toast.makeText(this, "整数を入力してください", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
