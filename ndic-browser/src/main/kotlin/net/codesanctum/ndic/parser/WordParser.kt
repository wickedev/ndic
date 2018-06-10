package net.codesanctum.ndic.parser

import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.util.toNullOrInt
import net.codesanctum.ndic.vo.Word
import org.w3c.dom.HTMLElement


class WordParser(private val meaningParser: MeaningParser) {

    fun parse(wordElement: HTMLElement?, meaningElement: HTMLElement?): Word {

        val wrapper = wrapper(wordElement)

        val title = wrapper.find(".t1 strong")
                .text().let {
                    if (it.isEmpty()) {
                        wrapper.find(".t1 a").text()
                    } else {
                        it
                    }
                }
        val number = wrapper.find(".t1 sup").text()
        val url = wrapper.find(".t1 a").attr("href")!!
        val phoneticSymbol = wrapper.find(".t2").text()
        val pronunciation = wrapper.find("#pron_en").attr("playlist")
        val meaning = meaningParser.parse(meaningElement)

        return Word(title = title,
                number = number.toNullOrInt(),
                url = url,
                phoneticSymbol = phoneticSymbol.emptyToNull(),
                pronunciation = pronunciation?.emptyToNull(),
                meanings = meaning)
    }
}
