package com.ahmet.gramerapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmet.gramerapp.service.TestAPIService
import com.ahmet.gramerapp.service.TestModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ObjectViewModel:ViewModel() {

    private val testAPIService=TestAPIService()
    private val compositeDisposable=CompositeDisposable()

    val test=MutableLiveData<TestModel>()

    fun resreshTest(){
        getDataFromTest()
    }
    private fun getDataFromTest() {

        compositeDisposable.add(testAPIService.getAPITest()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<TestModel>(){
                override fun onSuccess(t: TestModel) {
                    test.value=t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            }))
    }
    fun getIdFrom(id:String){

    }
}