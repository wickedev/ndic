@file:Suppress("unused")

package net.codesanctum.ndic

import org.w3c.xhr.XMLHttpRequest
import kotlin.js.Promise
import kotlin.test.Test

class ResultHtmlParserTest {

    @Test
    fun xhr(tes: Int) {
        println("\n------------------- XHR -------------------\n\n")
        Promise<String>({ resolve, reject ->
            val xhr = XMLHttpRequest()
            xhr.open("GET", "http://endic.naver.com/searchAssistDict.nhn?query=%s")
            xhr.onload = {
                if (xhr.status == 200.toShort()) {
                    resolve(xhr.responseText)
                } else {
                    reject(Error("[status: ${xhr.status}]: ${xhr.statusText}"))
                }
            }
            xhr.send()
        }).then {
            println(it)
        }.catch {
            println(it)
        }
        println("\n------------------- XHR -------------------\n\n")
    }
}