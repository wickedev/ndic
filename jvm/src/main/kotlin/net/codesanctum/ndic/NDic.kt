package net.codesanctum.ndic

import net.codesanctum.ndic.parser.HtmlParser
import net.codesanctum.ndic.vo.Word

class NDic {
    companion object {
        fun search(query: String): List<Word> {
            return HtmlParser().search(query)
        }
    }
}