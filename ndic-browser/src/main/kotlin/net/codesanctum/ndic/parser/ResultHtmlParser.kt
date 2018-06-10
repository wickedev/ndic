package net.codesanctum.ndic.parser


import net.codesanctum.ndic.vo.Word

class ResultHtmlParser(private val wordParser: WordParser) {

    companion object {
        fun create(): ResultHtmlParser = ResultHtmlParser(WordParser(MeaningParser()))
    }

    fun parseHtmlToData(html: String): List<Word> {
        val words = mutableListOf<Word>()

        val doc = wrapper(html)
        val wordElems = doc.find("h3")
        val meaningElems = doc.find(".box_a")

        for (idx in 0 until wordElems.length.toInt()) {
            val wordElem = wordElems[idx]
            val meaningElem = meaningElems[idx]
            val word = wordParser.parse(wordElem, meaningElem)
            words.add(word)
        }

        return words
    }
}
