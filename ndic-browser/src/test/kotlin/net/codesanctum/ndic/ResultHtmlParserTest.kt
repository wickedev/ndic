@file:Suppress("unused")

package net.codesanctum.ndic

import kotlinx.coroutines.experimental.asDeferred
import kotlinx.coroutines.experimental.promise
import net.codesanctum.ndic.NDic.Companion.search
import kotlin.test.Test

class ResultHtmlParserTest {

    @Test
    fun xhr() = promise {
        val request = search("test").asDeferred()
        val response = request.await()
        println(JSON.stringify(response, replacer, 4))
        // assertTrue(response.isNotEmpty())
    }

    private val replacer: ((key: String, value: Any?) -> Any?) = { _: String, value: Any? ->
        if (value === null) undefined
        value
    }
}

