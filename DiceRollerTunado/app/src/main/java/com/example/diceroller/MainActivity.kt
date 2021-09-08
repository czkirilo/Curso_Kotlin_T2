package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.diceroller.databinding.ActivityMainBinding
import android.os.Handler;


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        RoolDiceAnimated()
        binding.button.setOnClickListener { RandomDice() }
    }

    fun RandomDice() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            RoolDiceAnimated()
            val toast = Toast.makeText(this, "Dados Rolando!", Toast.LENGTH_SHORT)
            toast.show()
        }, 2000)

        // var txtView =  binding.textView

        var diceReturn = Dice(6).roll()

        var diceImage = binding.imageView

        when (diceReturn) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        // txtView.setText("$diceReturn")

    }

    fun RoolDiceAnimated() {
        var diceImage = binding.imageView
        Glide.with(this).load(R.drawable.dice).into(diceImage)
    }

    class Dice(var numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}