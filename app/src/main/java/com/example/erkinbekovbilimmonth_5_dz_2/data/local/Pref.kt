package com.example.erkinbekovbilimmonth_5_dz_2.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {

    private var pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean{
        return pref!!.getBoolean(ONBOARD_KEY, false)
    }

    fun saveSeen(){
        pref.edit().putBoolean(ONBOARD_KEY, true).apply()
    }


    companion object{
        const val PREF_NAME = "name"
        const val ONBOARD_KEY = "onBoard"
    }
}