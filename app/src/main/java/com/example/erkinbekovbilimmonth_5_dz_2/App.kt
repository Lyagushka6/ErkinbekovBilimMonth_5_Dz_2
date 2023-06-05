package com.example.erkinbekovbilimmonth_5_dz_2

import android.app.Application
import androidx.room.Room
import com.example.erkinbekovbilimmonth_5_dz_2.data.local.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "love_file"
            ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var appDatabase: AppDatabase
    }
}