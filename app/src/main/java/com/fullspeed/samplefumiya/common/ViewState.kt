package com.fullspeed.samplefumiya.common

sealed class ViewState(){

    object Loading:ViewState()
    object StopLoading:ViewState()
    object NoNetworkError:ViewState()
    object SomethingWentWrong:ViewState()
    data class ErrorResponse(val content: Any):ViewState()
    data class Content(val content:Any):ViewState()

}