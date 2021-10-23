package com.example.epamapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "offeredjobitem")
data class OfferedJobItem(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: Category,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "level") val level: String
) {
    enum class Category {
        PHYSICAL, NONPHYSICAL;
        companion object {
            @JvmStatic
            @TypeConverter
            fun getByOrdinal(ordinal: Int): Category? {
                return values().find{it.ordinal == ordinal}
            }

            @JvmStatic
            @TypeConverter
            fun toInt(category: Category): Int {
                return category.ordinal
            }
        }
    }
}