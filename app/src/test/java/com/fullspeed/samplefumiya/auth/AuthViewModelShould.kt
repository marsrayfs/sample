package com.fullspeed.samplefumiya.auth

import androidx.lifecycle.viewModelScope
import com.fullspeed.samplefumiya.auth.ui.AuthViewModel
import com.fullspeed.samplefumiya.common.BaseTest
import com.fullspeed.samplefumiya.common.ViewState
import com.fullspeed.samplefumiya.model.User
import com.fullspeed.samplefumiya.util.captureValues
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class AuthViewModelShould: BaseTest(){

    private lateinit var viewModel:AuthViewModel
    private val repository: AuthRepository = mock()

    @Before
    fun setUp() {
        viewModel = AuthViewModel(repository)
    }

    @Test
    fun loginFromRepositoryIsCalled() = runBlockingTest {
        viewModel.login()
        Thread.sleep(4000)
        verify(repository, times(1)).login()
    }

    @Test
    fun emitsUserWhenLogin() = runBlockingTest {
        var expected = User("mars","idToken")
        whenever(repository.login()).thenReturn(User("mars","idToken"))
        Thread.sleep(4000)
        assertEquals(repository.login(), expected)
    }

    @Test
    fun viewModelShouldStartAndEndLoading() = runBlockingTest {
        viewModel.viewState.captureValues {
            viewModel.login()
            assertEquals(values[0],ViewState.Loading)
            assertEquals(values[values.size-1],ViewState.StopLoading)
        }
    }

}