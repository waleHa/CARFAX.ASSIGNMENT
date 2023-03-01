package com.carfax.assignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carfax.assignment.data.model.ListingsRemoteModel
import com.carfax.assignment.data.model.WrappedListingsRemoteModel
import com.carfax.assignment.data.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel(){
    private val repository = MainRepository()

    private val _carListingsSuccess = MutableLiveData<Response<WrappedListingsRemoteModel>>()
    val carListingsSuccess: LiveData<Response<WrappedListingsRemoteModel>> = _carListingsSuccess

    private val _carListingsError = MutableLiveData<Exception>()
    val carListingsError: LiveData<Exception> = _carListingsError

    private val _currentListingsRemoteModel = MutableLiveData<ListingsRemoteModel>()
    val currentListingsRemoteModel: LiveData<ListingsRemoteModel> = _currentListingsRemoteModel


    private fun getCarListings() = viewModelScope.launch {
        try {
            _carListingsSuccess.postValue(repository.getList())
        }catch (e:Exception){
            _carListingsError.postValue(e)
        }
    }

    init {
        getCarListings()
    }




}