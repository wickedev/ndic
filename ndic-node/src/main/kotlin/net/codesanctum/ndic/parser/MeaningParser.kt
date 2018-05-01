@file:Suppress("SpellCheckingInspection")

package net.codesanctum.ndic.parser

import js.externals.cheerio.Cheerio
import js.externals.cheerio.Elements
import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.vo.Definition
import net.codesanctum.ndic.vo.Meaning
import net.codesanctum.ndic.vo.MoreDefinition
import kotlin.js.Json

class MeaningParser {
    fun parse(meaningElement: Elements): List<Meaning> {
        val datas = mutableListOf<Meaning>()
        getCurrentDataAndTryNext(datas, meaningElement)
        return datas
    }

    private fun getCurrentDataAndTryNext(datas: MutableList<Meaning>, current: Elements?) {
        if (current?.hasClass("box_a") == true ||
                current?.hasClass("box_b") == true ||
                current?.hasClass("box_c") == true) {
            datas.add(getData(current))
            getCurrentDataAndTryNext(datas, current.next())
        }
    }

    private fun getData(current: Elements): Meaning {
        val type = current.find("h4 .fnt_k28").text()
        val definitions = getDefinitions(current)
        val moreDefinition = getMoreDefinition(current)

        return Meaning(type = type.emptyToNull(),
                definitions = definitions,
                moreDefinition = moreDefinition)
    }

    private fun getMoreDefinition(current: Elements): MoreDefinition? {
        if (!current.hasClass("last")) return null

        val more = current.find("dt.last")
        val count = more.find(".fnt_k14").text()
        val url = more.find(".fnt_k14").attr("href")
        return MoreDefinition(count = count.toInt(), url = url)
    }

    private fun getDefinitions(current: Elements): List<Definition> {
        val datas = mutableListOf<Definition>()
        val defs = current.find(".list_ex1 dt") // 의미

        for (idx in 0 until defs.length) {
            val it = defs._make(defs[idx]!!)
            if (it.hasClass("last")) { // 뜻 더보기
                break
            }

            val def = it.text()
            val exEnElem = it.next()
            val exKrElem = it.next().next()

            val exEn = if (exEnElem.`is`("dd")) exEnElem.text() else null
            val exKr = if (exKrElem.`is`("dd")) exKrElem.text() else null

            datas.add(Definition(def = def,
                    exEn = exEn,
                    exKr = exKr))
        }

        return datas
    }

}
