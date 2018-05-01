package net.codesanctum.ndic.parser


import js.externals.cheerio.Cheerio
import js.externals.cheerio.select
import net.codesanctum.ndic.vo.Word


class ResultHtmlParser(private val wordParser: WordParser) {

    companion object {
        fun create(): ResultHtmlParser = ResultHtmlParser(WordParser(MeaningParser()))
    }

    fun parseHtmlToData(html: String): List<Word> {
        val words = mutableListOf<Word>()

        val document = Cheerio.load(html)

        val wordElems = document.select("h3")
        val meaningElems = document.select(".box_a")

        for (idx in 0 until wordElems.length) {
            val wordElem = wordElems._make(wordElems[idx])
            val meaningElem = meaningElems._make(meaningElems[idx])
            val word = wordParser.parse(wordElem, meaningElem)
            words.add(word)
        }

        return words
    }
}