package net.codesanctum.ndic

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class NDicTest : Spek({
    it("should be success") {
        val result = NDic.search("meanings")
        println(result)
    }
})
