package com.example.erkinbekovbilimmonth_5_dz_2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}