package net.codesanctum.ndic.parser

import js.externals.jquery.JQuery
import js.externals.jquery.`$`
import org.w3c.dom.HTMLElement


fun wrapper(html: HTMLElement?): JQuery<HTMLElement> {
    return `$`(html)
}

fun wrapper(html: String): JQuery<HTMLElement> {
    return `$`("<div>$html</div>")
}