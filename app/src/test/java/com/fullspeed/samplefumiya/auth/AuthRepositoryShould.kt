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

class AuthRepositoryShould:BaseTest() {

    private lateinit var repository:AuthRepository
    private val service: AuthService = mock()

    @Before
    fun setUp() {
        repository = AuthRepository(service)
    }

    @Test
    fun loginFromServiceIsCalled() = runBlockingTest {
        repository.login()
        Thread.sleep(4000)
        verify(service, times(1)).login()
    }

    @Test
    fun emitsUserWhenLogin() = runBlockingTest {
        var expected = User("mars","idToken")
        whenever(service.login()).thenReturn(User("mars","idToken"))
        Thread.sleep(4000)
        assertEquals(repository.login(), expected)
    }


}