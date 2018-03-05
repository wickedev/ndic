package net.codesanctum.ndic.parser

import net.codesanctum.ndic.vo.Word
import org.jsoup.nodes.Document

class ResultHtmlParser(private val wordParser: WordParser) {

    companion object {
        fun create(): ResultHtmlParser = ResultHtmlParser(WordParser(MeaningParser()))
    }

   fun parseHtmlToData(document: Document): List<Word> {
        val words = mutableListOf<Word>()

        val wordElem = document.select("h3")
        val meaningElem = document.select(".box_a")

        for (idx in 0 until wordElem.size) {
            val word = wordParser.parse(wordElem[idx], meaningElem[idx])
            words.add(word)
        }

        return words
    }
}