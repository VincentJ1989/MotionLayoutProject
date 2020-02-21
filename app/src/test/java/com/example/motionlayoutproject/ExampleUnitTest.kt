package com.example.motionlayoutproject

import com.example.motionlayoutproject.other.CatId
import com.example.motionlayoutproject.other.DogId
import com.example.motionlayoutproject.other.dog
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        dog(DogId(2))
        assertEquals(true,DogId(1).equals(DogId(1)))
        assertEquals(true,DogId(1)==(DogId(1)))
        assertEquals(true, CatId(1) .equals(DogId(1)))
    }
}