package com.fullspeed.samplefumiya.common

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fullspeed.samplefumiya.util.MainCoroutineScopeRule
import org.junit.Rule

abstract class BaseTest {
    @get:Rule
    var coroutineRule = MainCoroutineScopeRule()
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
}