package com.fullspeed.samplefumiya.auth

import com.fullspeed.samplefumiya.common.BaseTest
import com.fullspeed.samplefumiya.model.User
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class AuthServiceShould:BaseTest(){

    private lateinit var service:AuthService
    private val api: AuthApi = mock()

    @Before
    fun setUp() {
        service = AuthService(api)
    }

    @Test
    fun loginFromApiIsCalled() = runBlockingTest {
        service.login()
        Thread.sleep(4000)
        verify(api, times(1)).login()
    }

    @Test
    fun emitsUserWhenLogin() = runBlockingTest {
        var expected = User("mars","idToken")
        whenever(api.login()).thenReturn(User("mars","idToken"))
        Thread.sleep(4000)
        assertEquals(service.login(),expected)
    }

}