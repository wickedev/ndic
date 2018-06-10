package net.codesanctum.ndic


import js.externals.jquery.jQuery
import net.codesanctum.ndic.parser.ResultHtmlParser
import net.codesanctum.ndic.vo.Word
import kotlin.js.Promise

class NDic {
    companion object {
        private val resultHtmlParser: ResultHtmlParser = ResultHtmlParser.create()

        fun search(keyword: String): Promise<List<Word>> {
            return jQuery.get("http://endic.naver.com/searchAssistDict.nhn?query=$keyword")
                    .then {
                        val result = it as String
                        return@then resultHtmlParser.parseHtmlToData(result)
                    }
        }
    }
}
