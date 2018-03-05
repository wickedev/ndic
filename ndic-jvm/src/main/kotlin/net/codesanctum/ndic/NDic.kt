package net.codesanctum.ndic

import net.codesanctum.ndic.parser.ResultHtmlParser
import net.codesanctum.ndic.vo.Word
import org.jsoup.Jsoup

class NDic {
    companion object {
        private const val DICTIONARY_URL = "http://endic.naver.com/searchAssistDict.nhn?query=%s"
        private val resultHtmlParser: ResultHtmlParser = ResultHtmlParser.create()

        fun search(query: String): List<Word> {
            val reqUrl = String.format(DICTIONARY_URL, query)
            val document = Jsoup.connect(reqUrl).get()
            return resultHtmlParser.parseHtmlToData(document)
        }
    }
}