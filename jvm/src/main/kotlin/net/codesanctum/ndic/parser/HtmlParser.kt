package net.codesanctum.ndic.parser

import net.codesanctum.ndic.vo.Word
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class HtmlParser {
    companion object {
        const val DICTIONARY_URL = "http://m.endic.naver.com/assistDic.nhn?query=%s"
    }

    fun search(query: String): List<Word> {
        val words: MutableList<Word> = arrayListOf()
        val reqUrl = String.format(DICTIONARY_URL, query)
        val document = Jsoup.connect(reqUrl).get()
        val wordsElements: MutableList<Elements> = arrayListOf()
        var wordElements: Elements? = null

        for (element in document.allElements) {
            if (element.hasClass("ly_tit")) {
                wordElements = Elements()
                wordsElements.add(wordElements)
                wordElements.add(element)
            } else if (element.hasClass("ly_p")) {
                wordElements?.add(element)
            }
        }

        for (wordsElement in wordsElements) {
            for (element in wordsElement) {
                val meaning: MutableList<String> = arrayListOf()
                val title = element.select(".target").text()
                val meaningElements = element.select(".ly_p")

                for (meaningElement in meaningElements) {

                    meaning.add(meaningElement.text())
                }

                words.add(Word(title, meaning))
            }
        }

        return words
    }
}