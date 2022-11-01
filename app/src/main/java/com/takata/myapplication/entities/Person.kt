package com.takata.myapplication.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (

    var name:String = "",
    var email:String = "",
    var birthDate:String = "",
    var address:String = ""

) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}