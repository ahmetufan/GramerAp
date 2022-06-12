package com.ahmet.gramerapp.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ModelAPI {

    //  http://www.adddisyon.online/get_questionsfiil1.php

    @GET("eng_kategori.php")
    fun gethomeAPI(): Single<KategoriModel>

    //  http://www.adddisyon.online/  eng_test.php

    @GET("eng_test.php")
    fun getTestAPI() : Single<TestModel>

}