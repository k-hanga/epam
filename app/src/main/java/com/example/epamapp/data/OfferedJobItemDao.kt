package com.example.epamapp.data

import androidx.room.*

@Dao
interface OfferedJobItemDao {
    @Query("SELECT * FROM offeredjobitem")
    fun getAll(): List<AppliedJobItem>

    @Insert
    fun insert(jobItem: AppliedJobItem): Long

    @Update
    fun update(jobItem: AppliedJobItem)

    @Delete
    fun delete(jobItem: AppliedJobItem)
}