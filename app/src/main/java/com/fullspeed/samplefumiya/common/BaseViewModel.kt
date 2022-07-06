package com.fullspeed.samplefumiya.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel :ViewModel(){

    private val _viewState = MutableLiveData<ViewState>()
    val viewState : LiveData<ViewState>
        get() = _viewState

    fun startLoading() = _viewState.postValue(ViewState.Loading)
    fun stopLoading() = _viewState.postValue(ViewState.StopLoading)
    fun displayNoNetwork() = _viewState.postValue(ViewState.NoNetworkError)
    fun displaySomethingWentWrong() = _viewState.postValue(ViewState.SomethingWentWrong)
    fun receiveErrorResponse(errorResponse:Any) = _viewState.postValue(ViewState.ErrorResponse(errorResponse))
    fun receiveResult(result:Any) = _viewState.postValue(ViewState.Content(result))

}