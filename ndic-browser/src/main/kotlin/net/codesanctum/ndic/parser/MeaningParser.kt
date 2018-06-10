@file:Suppress("SpellCheckingInspection")

package net.codesanctum.ndic.parser

import js.externals.jquery.JQuery
import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.vo.Definition
import net.codesanctum.ndic.vo.Meaning
import net.codesanctum.ndic.vo.MoreDefinition
import org.w3c.dom.HTMLElement

class MeaningParser {
    fun parse(meaningElement: HTMLElement?): List<Meaning> {
        val datas = mutableListOf<Meaning>()
        getCurrentDataAndTryNext(datas, wrapper(meaningElement))
        return datas
    }

    private fun getCurrentDataAndTryNext(datas: MutableList<Meaning>, current: JQuery<HTMLElement>) {

        if (current.hasClass("box_a")
                || current.hasClass("box_b")
                || current.hasClass("box_c")) {
            datas.add(getData(current))
            getCurrentDataAndTryNext(datas, current.next())
        }
    }

    private fun getData(current: JQuery<HTMLElement>): Meaning {
        val type = current.find("h4 .fnt_k28").text()
        val definitions = getDefinitions(current)
        val moreDefinition = getMoreDefinition(current)

        return Meaning(type = type.emptyToNull(),
                definitions = definitions,
                moreDefinition = moreDefinition)
    }

    private fun getMoreDefinition(current: JQuery<HTMLElement>): MoreDefinition? {
        if (!current.hasClass("last")) return null

        val more = current.find("dt.last")
        val count = more.find(".fnt_k14").text()
        val url = more.find(".fnt_k14").attr("href")!!
        return MoreDefinition(count = count.toInt(), url = url)
    }

    private fun getDefinitions(current: JQuery<HTMLElement>): List<Definition> {
        val datas = mutableListOf<Definition>()
        val defs = current.find(".list_ex1 dt") // 의미

        for (idx in 0 until defs.length.toInt()) {
            val it = wrapper(defs[idx])
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
