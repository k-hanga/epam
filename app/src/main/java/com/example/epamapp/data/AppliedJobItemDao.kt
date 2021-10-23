package com.example.epamapp.data

import androidx.room.*

@Dao
interface AppliedJobItemDao {
    @Query("SELECT * FROM appliedjobitem")
    fun getAll(): List<AppliedJobItem>

    @Insert
    fun insert(jobItem: AppliedJobItem): Long

    @Update
    fun update(jobItem: AppliedJobItem)

    @Delete
    fun delete(jobItem: AppliedJobItem)
}