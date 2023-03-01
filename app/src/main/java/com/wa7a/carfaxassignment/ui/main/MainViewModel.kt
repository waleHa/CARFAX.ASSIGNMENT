package com.wa7a.carfaxassignment.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wa7a.carfaxassignment.data.model.ListingsRemoteModel
import com.wa7a.carfaxassignment.data.model.WrappedListingsRemoteModel
import com.wa7a.carfaxassignment.data.repository.MainRepository
import com.wa7a.carfaxassignment.ui.listing.adapters.InteractionListener
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