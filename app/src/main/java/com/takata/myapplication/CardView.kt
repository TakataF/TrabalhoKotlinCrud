package com.takata.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.takata.myapplication.adapters.PersonAdapter
import com.takata.myapplication.databases.AppDatabase
import com.takata.myapplication.databinding.ActivityCardViewBinding
import com.takata.myapplication.databinding.ActivityMainBinding
import com.takata.myapplication.entities.Person
import kotlinx.coroutines.launch
import java.io.FileInputStream


class CardView : AppCompatActivity() {

    private lateinit var binding: ActivityCardViewBinding
    private var mAdapter: PersonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.adicionar.setOnClickListener(){
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

    }

    private fun setAdapter(list: List<Person>){
        mAdapter?.setData(list)
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val personList = AppDatabase(this@CardView).getPersonDao().getAllPerson()

            mAdapter = PersonAdapter()
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(this@CardView)
                adapter = mAdapter
                setAdapter(personList)

                mAdapter?.setOnActionEditListener {
                    val intent = Intent(this@CardView, Cadastro::class.java)
                    intent.putExtra("Data", it)
                    startActivity(intent)
                }

                mAdapter?.setOnActionDeleteListener {
                    val builder = AlertDialog.Builder(this@CardView)
                    builder.setMessage("Tem certeza que quer excluir?")
                    builder.setPositiveButton("Sim") { p0, p1 ->
                        lifecycleScope.launch {
                            AppDatabase(this@CardView).getPersonDao().deletePerson(it)
                            val pList = AppDatabase(this@CardView).getPersonDao().getAllPerson()
                            setAdapter(pList)
                        }
                        p0.dismiss()
                    }

                    builder.setNegativeButton("Não") { p0, p1 ->
                        p0.dismiss()
                    }

                    val dialog = builder.create()
                    dialog.show()
                }
            }
        }
    }


}