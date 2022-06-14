package com.ahmet.gramerapp.service

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ModelApiService {

    private val BASE_URL="http://www.adddisyon.online/"

    //  http://www.adddisyon.online/get_questionsfiil1.php


    private val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ModelAPI::class.java)

    fun getAPI1():Single<KategoriModel> {
        return retrofit.gethomeAPI()
    }
}
class TestAPIService {

    private val Base_URL="http://www.adddisyon.online/"

    private val retrofit2=Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ModelAPI::class.java)

    fun getAPITest(kategoriId : Int):Single<TestModel> {
        return retrofit2.getTestAPI(kategoriId)
    }
}