@file:Suppress("unused")

package net.codesanctum.ndic

import kotlin.js.Promise
import kotlin.test.Test

class ResultHtmlParserTest {
    @Test
    fun resultHtmlParserTest() {
        NDic.search("test").then{
            console.log(JSON.stringify(it, replacer, 4))
        }
    }

    private fun <T> getDataFrom(promise: Promise<T>): T {
        var model: T? = null
        promise.then { model = it

        }
        return model!!
    }

    private val replacer: ((key: String, value: Any?) -> Any?) = { _: String, value: Any? ->
        if (value === null) undefined
        value
    }
}