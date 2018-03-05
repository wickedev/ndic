package net.codesanctum.ndic.parser

import com.google.gson.GsonBuilder
import com.winterbe.expekt.should
import net.codesanctum.ndic.NDic
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class ResultHtmlParserTest : Spek({
    it("should parse correct") {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val result = NDic.search("test")
        val json = gson.toJson(result)
        println(json)

        result.should.not.`null`
    }
})