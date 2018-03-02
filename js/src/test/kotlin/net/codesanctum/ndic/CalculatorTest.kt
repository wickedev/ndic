package net.codesanctum.ndic

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun add() {
        val result = Calculator.add(1, 1)
        assertEquals(result, 2)
    }
}