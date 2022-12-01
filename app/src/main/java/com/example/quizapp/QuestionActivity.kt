package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private var name:String?=null
    private var score:Int=0

    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData> ? = null
    private var selectedOption:Int=0

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()

        setQuestion()

        binding.opt1.setOnClickListener {
            selectedOptionStyle(binding.opt1,1)
        }
        binding.opt2.setOnClickListener {
            selectedOptionStyle(binding.opt2,2)
        }
        binding.opt3.setOnClickListener {
            selectedOptionStyle(binding.opt3,3)
        }
        binding.opt4.setOnClickListener {
            selectedOptionStyle(binding.opt4,4)
        }
        binding.submit.setOnClickListener {
            if(selectedOption!=0){
                val question=questionList!![currentPosition-1]
                if(selectedOption!=question.correct_ans){
                    setColor(selectedOption,R.drawable.wrong_question_option)
                }else{
                    score++;
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if(currentPosition==questionList!!.size){
                    binding.submit.text="VER RESULTADO"
                } else{
                    binding.submit.text="SIGUIENTE"
                }
            } else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                        binding.submit.text="ENVIAR"
                    }
                    else->{
                        var intent=Intent(this,Result::class.java)
                        intent.putExtra(setData.name,name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("totalSize",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption=0
        }
    }

    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                binding.opt1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                binding.opt2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                binding.opt3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                binding.opt4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()

        binding.progressBar.progress=currentPosition
        binding.progressBar.max=questionList!!.size
        binding.progressText.text="${currentPosition}"+"/"+"${questionList!!.size}"
        binding.questionText.text=question.question
        binding.opt1.text=question.option_one
        binding.opt2.text=question.option_two
        binding.opt3.text=question.option_three
        binding.opt4.text=question.option_four
    }

    fun setOptionStyle(){

        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,binding.opt1)
        optionList.add(1,binding.opt2)
        optionList.add(2,binding.opt3)
        optionList.add(3,binding.opt4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#8C8C8C"))
            op.background=ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface=Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView, opt:Int){

        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}