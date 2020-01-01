package com.example.plusminuscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declare module-level variable
    private lateinit var countViewModel: CountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize the viewModel


        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.count.observe(this, Observer { if(it.equals(4))goodluck() })
        button.setOnClickListener{
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value.toString()

        }

        button2.setOnClickListener{
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value.toString()
        }
    }

    private fun goodluck() {
        Toast.makeText(applicationContext,"What a lucky day!",Toast.LENGTH_SHORT).show()

    }
}
