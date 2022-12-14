package com.takata.myapplication.dao

import androidx.room.*
import com.takata.myapplication.entities.Person

@Dao
interface PersonDao {

    @Insert
    suspend fun addPerson(person: Person)

    @Query("SELECT * FROM person ORDER BY id DESC")
    suspend fun getAllPerson(): List<Person>

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)
}