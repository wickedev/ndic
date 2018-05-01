package net.codesanctum.ndic.parser

import js.externals.cheerio.Elements
import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.util.toNullOrInt
import net.codesanctum.ndic.vo.Word


class WordParser(private val meaningParser: MeaningParser) {

    fun parse(wordElement: Elements, meaningElement: Elements): Word {

        val title = wordElement.find(".t1 strong").text()
        val number = wordElement.find(".t1 sup").text()
        val url = wordElement.find(".t1 a").attr("href")
        val phoneticSymbol = wordElement.find(".t2").text()
        val pronunciation = wordElement.find("#pron_en").attr("playlist")
        val meaning = meaningParser.parse(meaningElement)

        return Word(title = title,
                number = number.toNullOrInt(),
                url = url,
                phoneticSymbol = phoneticSymbol.emptyToNull(),
                pronunciation = pronunciation.emptyToNull(),
                meanings = meaning)
    }
}
