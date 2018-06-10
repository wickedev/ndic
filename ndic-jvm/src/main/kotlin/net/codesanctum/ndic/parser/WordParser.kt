package net.codesanctum.ndic.parser

import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.util.toNullOrInt
import net.codesanctum.ndic.vo.Word
import org.jsoup.nodes.Element

class WordParser(private val meaningParser: MeaningParser) {

    fun parse(wordElement: Element, meaningElement: Element): Word {

        val title = wordElement.select(".t1 strong").text().let {
            if (it.isEmpty()) {
                wordElement.select(".t1 a").text()
            } else {
                it
            }
        }


        val number = wordElement.select(".t1 sup").text()
        val url = wordElement.select(".t1 a").attr("href")
        val phoneticSymbol = wordElement.select(".t2").text()
        val pronunciation = wordElement.select("#pron_en").attr("playlist")
        val meaning = meaningParser.parse(meaningElement)

        return Word(title = title,
                number = number.toNullOrInt(),
                url = url,
                phoneticSymbol = phoneticSymbol.emptyToNull(),
                pronunciation = pronunciation.emptyToNull(),
                meanings = meaning)
    }
}
