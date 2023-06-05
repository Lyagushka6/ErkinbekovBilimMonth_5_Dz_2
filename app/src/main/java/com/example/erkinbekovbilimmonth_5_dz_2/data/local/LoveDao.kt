package com.example.erkinbekovbilimmonth_5_dz_2.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY firstName ASC, secondName ASC")
    fun getAll(): List<LoveModel>
}