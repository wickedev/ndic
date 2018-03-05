@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused")

package js.externals.cheerio

import org.w3c.dom.Document

external interface Attribute {
    operator fun get(attr: String): String?

    operator fun set(attr: String, value: String)
}

external interface Serialize {
    var name: String
    var value: String
}

external interface Elements {
    operator fun get(index: Number): Element?

    operator fun set(index: Number, value: Element)

    var length: Int
    fun attr(): Attribute
    fun attr(name: String): String
    fun attr(name: String, value: Any): Elements
    fun data(): Any
    fun data(name: String): Any
    fun data(name: String, value: Any): Any
    fun `val`(): String
    fun `val`(value: String): Elements
    fun removeAttr(name: String): Elements
    fun has(selector: String): Elements
    fun has(element: Element): Elements
    fun hasClass(className: String): Boolean
    fun addClass(classNames: String): Elements
    fun removeClass(): Elements
    fun removeClass(className: String): Elements
    fun removeClass(func: (index: Number, className: String) -> String): Elements
    fun toggleClass(className: String): Elements
    fun toggleClass(className: String, toggleSwitch: Boolean): Elements
    fun toggleClass(toggleSwitch: Boolean? = definedExternally /* null */): Elements
    fun toggleClass(func: (index: Number, className: String, toggleSwitch: Boolean) -> String, toggleSwitch: Boolean? = definedExternally /* null */): Elements
    fun `is`(selector: String): Boolean
    fun `is`(element: Element): Boolean
    fun `is`(element: Array<Element>): Boolean
    fun `is`(selection: Elements): Boolean
    fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    fun serialize(): String
    fun serializeArray(): Array<Serialize>
    fun find(selector: String): Elements
    fun find(element: Elements): Elements
    fun parent(selector: String? = definedExternally /* null */): Elements
    fun parents(selector: String? = definedExternally /* null */): Elements
    fun parentsUntil(selector: String? = definedExternally /* null */, filter: String? = definedExternally /* null */): Elements
    fun parentsUntil(element: Element, filter: String? = definedExternally /* null */): Elements
    fun parentsUntil(element: Elements, filter: String? = definedExternally /* null */): Elements
    fun prop(name: String): Any
    fun prop(name: String, value: Any): Elements
    fun closest(): Elements
    fun closest(selector: String): Elements
    fun next(selector: String? = definedExternally /* null */): Elements
    fun nextAll(): Elements
    fun nextAll(selector: String): Elements
    fun nextUntil(selector: String? = definedExternally /* null */, filter: String? = definedExternally /* null */): Elements
    fun nextUntil(element: Element, filter: String? = definedExternally /* null */): Elements
    fun nextUntil(element: Elements, filter: String? = definedExternally /* null */): Elements
    fun prev(selector: String? = definedExternally /* null */): Elements
    fun prevAll(): Elements
    fun prevAll(selector: String): Elements
    fun prevUntil(selector: String? = definedExternally /* null */, filter: String? = definedExternally /* null */): Elements
    fun prevUntil(element: Element, filter: String? = definedExternally /* null */): Elements
    fun prevUntil(element: Elements, filter: String? = definedExternally /* null */): Elements
    fun slice(start: Number, end: Number? = definedExternally /* null */): Elements
    fun siblings(selector: String? = definedExternally /* null */): Elements
    fun children(selector: String? = definedExternally /* null */): Elements
    fun contents(): Elements
    fun each(func: (index: Number, element: Element) -> Any): Elements
    fun map(func: (index: Number, element: Element) -> Any): Elements
    fun filter(selector: String): Elements
    fun filter(selection: Elements): Elements
    fun filter(element: Element): Elements
    fun filter(elements: Array<Element>): Elements
    fun filter(func: (index: Number, element: Element) -> Boolean): Elements
    fun not(selector: String): Elements
    fun not(selection: Elements): Elements
    fun not(element: Element): Elements
    fun not(func: (index: Number, element: Element) -> Boolean): Elements
    fun first(): Elements
    fun last(): Elements
    fun eq(index: Number): Elements
    fun get(): Array<String>
    fun get(): Array<Element>
    fun get(index: Number): Element
    fun index(): Number
    fun index(selector: String): Number
    fun index(selection: Elements): Number
    fun end(): Elements
    fun add(selectorOrHtml: String): Elements
    fun add(selector: String, context: Document): Elements
    fun add(element: Element): Elements
    fun add(elements: Array<Element>): Elements
    fun add(selection: Elements): Elements
    fun addBack(): Elements
    fun addBack(filter: String): Elements
    fun appendTo(target: Elements): Elements
    fun prependTo(target: Elements): Elements
    fun append(content: String, vararg contents: Any): Elements
    fun append(content: Document, vararg contents: Any): Elements
    fun append(content: Array<Document>, vararg contents: Any): Elements
    fun append(content: Elements, vararg contents: Any): Elements
    fun prepend(content: String, vararg contents: Any): Elements
    fun prepend(content: Document, vararg contents: Any): Elements
    fun prepend(content: Array<Document>, vararg contents: Any): Elements
    fun prepend(content: Elements, vararg contents: Any): Elements
    fun after(content: String, vararg contents: Any): Elements
    fun after(content: Document, vararg contents: Any): Elements
    fun after(content: Array<Document>, vararg contents: Any): Elements
    fun after(content: Elements, vararg contents: Any): Elements
    fun insertAfter(content: String): Elements
    fun insertAfter(content: Document): Elements
    fun insertAfter(content: Elements): Elements
    fun before(content: String, vararg contents: Any): Elements
    fun before(content: Document, vararg contents: Any): Elements
    fun before(content: Array<Document>, vararg contents: Any): Elements
    fun before(content: Elements, vararg contents: Any): Elements
    fun insertBefore(content: String): Elements
    fun insertBefore(content: Document): Elements
    fun insertBefore(content: Elements): Elements
    fun remove(selector: String? = definedExternally /* null */): Elements
    fun replaceWith(content: String): Elements
    fun replaceWith(content: Element): Elements
    fun replaceWith(content: Array<Element>): Elements
    fun replaceWith(content: Elements): Elements
    fun replaceWith(content: () -> Elements): Elements
    fun empty(): Elements
    fun html(): String?
    fun html(html: String): Elements
    fun text(): String
    fun text(text: String): Elements
    fun css(propertyName: String): String
    fun css(propertyNames: Array<String>): Array<String>
    fun css(propertyName: String, value: String): Elements
    fun css(propertyName: String, value: Number): Elements
    fun css(propertyName: String, func: (index: Number, value: String) -> String): Elements
    fun css(propertyName: String, func: (index: Number, value: String) -> Number): Elements
    fun css(properties: Any): Elements
    fun clone(): Elements
    fun toArray(): Array<Element>

    fun _make(element: Element?): Elements
}

external interface OptionsInterface {
    var xmlMode: Boolean? get() = definedExternally; set(value) = definedExternally
    var decodeEntities: Boolean? get() = definedExternally; set(value) = definedExternally
    var lowerCaseTags: Boolean? get() = definedExternally; set(value) = definedExternally
    var lowerCaseAttributeNames: Boolean? get() = definedExternally; set(value) = definedExternally
    var recognizeCDATA: Boolean? get() = definedExternally; set(value) = definedExternally
    var recognizeSelfClosing: Boolean? get() = definedExternally; set(value) = definedExternally
    var normalizeWhitespace: Boolean? get() = definedExternally; set(value) = definedExternally
}

@JsName("CheerioSelector")
external interface Selector {
    @nativeInvoke
    operator fun invoke(selector: String): Elements

    operator fun invoke(selector: String, context: String): Elements

    operator fun invoke(selector: String, context: Element): Elements

    operator fun invoke(selector: String, context: Array<Element>): Elements

    operator fun invoke(selector: String, context: Elements): Elements

    operator fun invoke(selector: String, context: String, root: String): Elements

    operator fun invoke(selector: String, context: Element, root: String): Elements

    operator fun invoke(selector: String, context: Array<Element>, root: String): Elements

    operator fun invoke(selector: String, context: Elements, root: String): Elements

    operator fun invoke(selector: Any): Elements


}

fun Selector.select(selector: String): Elements = invoke(selector)

fun Selector.select(selector: String, context: String): Elements = invoke(selector, context)

fun Selector.select(selector: String, context: Element): Elements = invoke(selector, context)

fun Selector.select(selector: String, context: Array<Element>): Elements = invoke(selector, context)

fun Selector.select(selector: String, context: Elements): Elements = invoke(selector, context)

fun Selector.select(selector: String, context: String, root: String): Elements = invoke(selector, context, root)

fun Selector.select(selector: String, context: Element, root: String): Elements = invoke(selector, context, root)

fun Selector.select(selector: String, context: Array<Element>, root: String): Elements = invoke(selector, context, root)

fun Selector.select(selector: String, context: Elements, root: String): Elements = invoke(selector, context, root)

fun Selector.select(selector: Any): Elements = invoke(selector)

external interface StaticSelector : Selector {
    fun xml(): String
    fun root(): Elements
    fun contains(container: Element, contained: Element): Boolean
    fun parseHTML(data: String, context: Document? = definedExternally /* null */, keepScripts: Boolean? = definedExternally /* null */): Array<Document>
    fun html(options: OptionsInterface? = definedExternally /* null */): String
    fun html(selector: String, options: OptionsInterface? = definedExternally /* null */): String
    fun html(element: Elements, options: OptionsInterface? = definedExternally /* null */): String
    fun html(element: Element, options: OptionsInterface? = definedExternally /* null */): String
}

external interface Element {
    var tagName: String
    var type: String
    var name: String
    var attribs: Attribute
    var children: Array<Element>
    var childNodes: Array<Element>
    var lastChild: Element
    var firstChild: Element
    var next: Element
    var nextSibling: Element
    var prev: Element
    var previousSibling: Element
    var parent: Element
    var parentNode: Element
    var nodeValue: String
    var data: String? get() = definedExternally; set(value) = definedExternally
}

external interface CheerioAPI : Selector, StaticSelector {
    fun load(html: String, options: OptionsInterface? = definedExternally /* null */): StaticSelector
    fun load(element: Element, options: OptionsInterface? = definedExternally /* null */): StaticSelector
}

@JsNonModule
@JsModule("Cheerio")
external val Cheerio: CheerioAPI = definedExternally
