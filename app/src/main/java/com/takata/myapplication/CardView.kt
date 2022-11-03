package com.takata.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.takata.myapplication.databinding.ActivityCardViewBinding
import com.takata.myapplication.databinding.ActivityMainBinding


class CardView : AppCompatActivity() {

    private lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adicionar.setOnClickListener(){
            val intent = Intent(this, Cadastro :: class.java)
            startActivity(intent)
        }

    }

}