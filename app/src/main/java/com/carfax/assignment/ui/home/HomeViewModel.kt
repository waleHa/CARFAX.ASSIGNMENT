package com.carfax.assignment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carfax.assignment.data.model.CarRemoteModel
import com.carfax.assignment.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _carListingsSuccess = MutableLiveData<List<CarRemoteModel>>()
    val successCarListings: LiveData<List<CarRemoteModel>> = _carListingsSuccess

    private val _carListingsError = MutableLiveData<Exception>()
    val errorCarListings: LiveData<Exception> = _carListingsError

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    init {
        getCarListings()
    }

    private fun getCarListings() = viewModelScope.launch {
        _loadingLiveData.postValue(true)
        try {
            _carListingsSuccess.postValue(repository.getCarsList())
        } catch (e: Exception) {
            _carListingsError.postValue(e)
        }
        _loadingLiveData.postValue(false)
    }
}
