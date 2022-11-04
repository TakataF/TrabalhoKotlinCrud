package com.takata.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.takata.myapplication.R
import com.takata.myapplication.entities.Person

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private var list = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_person_view_holder, parent, false)

        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = list[position]

        holder.vName.text = person.name
        holder.vEmail.text = person.email
        holder.vPhone.text = person.phone
        holder.vbirthDate.text = person.birthDate
        holder.vAddress.text = person.address

    }

    override fun getItemCount() = list.size

    fun setData(data: List<Person>){
        list.apply {
            clear()
            addAll(data)
        }
    }


    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vName : TextView = itemView.findViewById(R.id.v_nome)
        val vEmail : TextView = itemView.findViewById(R.id.v_email)
        val vPhone : TextView = itemView.findViewById(R.id.v_telefone)
        val vbirthDate : TextView = itemView.findViewById(R.id.v_data_nascimento)
        val vAddress : TextView = itemView.findViewById(R.id.v_endereco)
    }
}