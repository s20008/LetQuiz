package jp.ac.it_college.s20008.android.letquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface.DEFAULT
import android.graphics.Typeface.DEFAULT_BOLD
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import jp.ac.it_college.s20008.android.letquiz.databinding.ActivityQuestionBinding
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var binding: ActivityQuestionBinding
    private var mCurrentPosition = 0
    private var submitTimes = 0
    private var correctCount = 0
    private var correctId:Int? = null
    private var mSelectedOption:TextView? = null
    private var mQuestionList:MutableList<Question>? = null //選択した問題集
    private var options:List<TextView> = ArrayList()
    private var questionCount = 0
    private var timerCount:String? = null

    inner class MyCountDownTimer(millisInFuture:Long, countDownInteral:Long)
        : CountDownTimer(millisInFuture, countDownInteral){


        override fun onTick(millisUntilFinished: Long) {
            val minute = millisUntilFinished / 1000L / 60L
            val second = millisUntilFinished / 1000L % 60L
            binding.timerText.text = "%1d:%2$02d".format(minute,second)
        }

        override fun onFinish() {
            binding.timerText.text = "0:00"

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionCount = intent.getStringExtra(Constants.QUESTION_COUNT).toString().toInt()
        mQuestionList = Constants.getQuestions(questionCount)
        options = listOf<TextView>(app_option1, app_option2, app_option3, app_option4)
        options.forEach{
            it.setOnClickListener(this)
        }
        binding.appSubmit.setOnClickListener(this)
        setQuestion()

        binding.timerText.text = "{mQuestionList!!.size}:{0}"
        var timer = MyCountDownTimer((mQuestionList!!.size * 10 * 1000).toLong(),100)
        timer.start()

    }


    @SuppressLint("SetTextI18n")
    private fun setQuestion () {
        mCurrentPosition += 1
        if (mCurrentPosition > mQuestionList!!.size) {
            val times = timerText.text.toString().split(":")
            val min = times[0].toLong()
            val sec = times[1].toLong()
            val total = (mQuestionList!!.size * 10) - (min * 60 + sec)
            timerCount = total.toString()

            val intent = Intent(this@QuestionActivity, ResultActivity::class.java)
            intent.putExtra(Constants.CORRECT_COUNT, correctCount.toString())
            intent.putExtra(Constants.WRONG_COUNT, (mQuestionList!!.size-correctCount).toString())
            intent.putExtra(Constants.QUESTION_COUNT, mQuestionList!!.size.toString())
            intent.putExtra(Constants.TIMER_COUNT,timerCount)
            startActivity(intent)
            finish()
            return
        }


        options.forEach { setDefaultOption(it) }
        val question = mQuestionList!![mCurrentPosition-1]
        correctId = question.correctAnswer

        binding.appProgressBar.progress = mCurrentPosition
        binding.appProgressBar.max = mQuestionList!!.size
        binding.appProgress.text = "$mCurrentPosition/${mQuestionList!!.size}"

        //设置问题
        binding.appImage.setImageResource(question.image)
        binding.appQuestion.text = question.question
        listOf(question.option1, question.option2, question.option3, question.option4)
            .forEachIndexed { i, value -> options[i].text = value }

    }



    private fun setDefaultOption (view: TextView) {
        view.setTextColor(ContextCompat.getColor(this, R.color.app_text_gray))
        view.typeface = DEFAULT
        view.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == app_submit.id && mSelectedOption != null) {
            p0 as Button
            when(submitTimes) {
                0 -> {
                    answer()
                    submitTimes = 1
                    if (mCurrentPosition == mQuestionList!!.size) {
                        p0.text = "終わり"
                    }else{
                        p0.text = "次へ"
                    }
                }
                1 -> {
                    setQuestion()
                    submitTimes = 0
                    mSelectedOption = null
                    p0.text = "OK"
                }
            }
            submitTimes
        }
        else {
            mSelectedOption?.let { setDefaultOption(it) }
            mSelectedOption = p0 as TextView
            mSelectedOption?.let { setSelectedOption(it) }
        }
    }

    private fun setSelectedOption (view: TextView) {
        view.setTextColor(ContextCompat.getColor(this, R.color.app_text_dark))
        view.typeface = DEFAULT_BOLD
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answer () {
        val selectedId = options.indexOf(mSelectedOption) + 1
        if (selectedId == correctId) {
            mSelectedOption?.background = ContextCompat.getDrawable(this, R.drawable.corrent_option_border_bg)
            correctCount++
        }
        else{
            mSelectedOption?.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            options[correctId!!-1].background = ContextCompat.getDrawable(this, R.drawable.corrent_option_border_bg)
        }
    }
}
