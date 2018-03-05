@file:Suppress("SpellCheckingInspection")

package net.codesanctum.ndic.parser

import net.codesanctum.ndic.util.`is`
import net.codesanctum.ndic.util.emptyToNull
import net.codesanctum.ndic.util.next
import net.codesanctum.ndic.vo.Definition
import net.codesanctum.ndic.vo.Meaning
import net.codesanctum.ndic.vo.MoreDefinition
import org.jsoup.nodes.Element

class MeaningParser {
    fun parse(meaningElement: Element): List<Meaning> {
        val datas = mutableListOf<Meaning>()
        getCurrentDataAndTryNext(datas, meaningElement)
        return datas
    }

    private fun getCurrentDataAndTryNext(datas: MutableList<Meaning>, current: Element?) {
        if (current?.hasClass("box_a") == true ||
                current?.hasClass("box_b") == true ||
                current?.hasClass("box_c") == true) {
            datas.add(getData(current))
            getCurrentDataAndTryNext(datas, current.next())
        }
    }

    private fun getData(current: Element): Meaning {
        val type = current.select("h4 .fnt_k28").text()
        val definitions = getDefinitions(current)
        val moreDefinition = getMoreDefinition(current)

        return Meaning(type = type.emptyToNull(),
                definitions = definitions,
                moreDefinition = moreDefinition)
    }

    private fun getMoreDefinition(current: Element): MoreDefinition? {
        if (!current.hasClass("last")) return null

        val more = current.select("dt.last")
        val count = more.select(".fnt_k14").text()
        val url = more.select(".fnt_k14").attr("href")
        return MoreDefinition(count = count.toInt(), url = url)
    }

    private fun getDefinitions(current: Element): List<Definition> {
        val datas = mutableListOf<Definition>()
        val defs = current.select(".list_ex1 dt") // 의미

        defs.forEach {
            if (it.hasClass("last")) { // 뜻 더보기
                return@forEach
            }


            val def = it.text()
            val exEnElem = it.next()
            val exKrElem = it.next()?.next()

            val exEn = if (exEnElem?.`is`("dd") == true) exEnElem.text() else null
            val exKr = if (exKrElem?.`is`("dd") == true) exKrElem.text() else null

            datas.add(Definition(def = def,
                    exEn = exEn,
                    exKr = exKr))
        }

        return datas
    }

}
