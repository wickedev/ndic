package net.codesanctum.ndic.util

import org.jsoup.nodes.Element

fun Element.next():Element? = nextElementSibling()

fun Element.`is`(tagName: String): Boolean = tagName() == tagName