package com.example.epamapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [AppliedJobItem::class], version = 1)
@TypeConverters(value = [AppliedJobItem.Category::class])
abstract class OfferedJobListDatabase : RoomDatabase() {
    abstract fun offeredJobItemDao(): OfferedJobItemDao
}