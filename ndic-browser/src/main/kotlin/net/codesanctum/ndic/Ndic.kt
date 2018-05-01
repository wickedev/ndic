package net.codesanctum.ndic


import js.externals.axios.Axios
import js.externals.sprintf.Spritf
import net.codesanctum.ndic.parser.ResultHtmlParser
import net.codesanctum.ndic.vo.Word
import kotlin.js.Promise

class NDic {
    companion object {
        private const val DICTIONARY_URL = "http://endic.naver.com/searchAssistDict.nhn?query=%s"
        private val resultHtmlParser: ResultHtmlParser = ResultHtmlParser.create()

        fun search(query: String): Promise<List<Word>> {
            val reqUrl = String.format(DICTIONARY_URL, query)
            val request = Axios.get<String>(reqUrl)
            return Promise.resolve(request)
                    .then { resultHtmlParser.parseHtmlToData(it.data) }
        }
    }
}

private fun String.Companion.format(format: String, vararg args: Any?): String {
    return Spritf.sprintf(format, args)
}

