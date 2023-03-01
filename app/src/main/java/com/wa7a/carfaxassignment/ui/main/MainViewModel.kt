package com.wa7a.carfaxassignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.carfaxassignment.data.model.WrappedListingsRemoteModel
import com.wa7a.carfaxassignment.data.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private val _carListingsSuccess = MutableLiveData<Response<WrappedListingsRemoteModel>>()
    val carListingsSuccess: LiveData<Response<WrappedListingsRemoteModel>> = _carListingsSuccess

    private val _carListingsError = MutableLiveData<Exception>()
    val carListingsError: LiveData<Exception> = _carListingsError

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