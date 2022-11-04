package com.takata.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.takata.myapplication.databases.AppDatabase
import com.takata.myapplication.databinding.ActivityCardViewBinding
import com.takata.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.io.FileInputStream


class CardView : AppCompatActivity() {

    private lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.adicionar.setOnClickListener(){
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val personList = AppDatabase(this@CardView).getPersonDao().getAllPerson()
            Log.e("onResume", "onResume: ${personList.size}")
        }
    }


}