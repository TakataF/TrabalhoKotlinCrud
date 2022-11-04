package com.takata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.takata.myapplication.databases.AppDatabase
import com.takata.myapplication.databinding.ActivityCadastroBinding
import com.takata.myapplication.databinding.ActivityMainBinding
import com.takata.myapplication.entities.Person
import kotlinx.coroutines.launch

class Cadastro : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastro.setOnClickListener{ addPerson() }

    }

    private fun addPerson() {
        val name = binding.nome.text.toString()
        val email = binding.email.text.toString()
        val phone = binding.telefone.text.toString()
        val address = binding.endereco.text.toString()
        val birthDate = binding.nascimento.text.toString()

        lifecycleScope.launch {
            val person = Person(
                name = name,
                email = email,
                birthDate = birthDate,
                phone = phone,
                address = address
            )
            AppDatabase(this@Cadastro).getPersonDao().addPerson(person)
            finish()
        }
    }
}