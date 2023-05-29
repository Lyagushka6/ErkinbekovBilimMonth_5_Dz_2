package com.example.erkinbekovbilimmonth_5_dz_2.api

import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(@Query("fname")firstName: String,
                      @Query("sname")secondName: String,
                      @Header("X-RapidAPI-Key")key : String = "a33844d0f2mshaa3b4f07cf3b6e8p14eb20jsn9d79a590db1a",
                      @Header("X-RapidAPI-Host")host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}