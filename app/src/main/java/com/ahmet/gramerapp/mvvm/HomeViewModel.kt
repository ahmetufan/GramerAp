package com.ahmet.gramerapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmet.gramerapp.service.KategoriModel
import com.ahmet.gramerapp.service.ModelApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class HomeViewModel : ViewModel() {

    private val modelApiService = ModelApiService()
    private val compositeDisposable = CompositeDisposable()

    val home = MutableLiveData<KategoriModel>()


    fun refeshData() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {

        compositeDisposable.add(modelApiService.getAPI1()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<KategoriModel>(){
                override fun onSuccess(t: KategoriModel) {
                    home.value=t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            }))

    }


}


