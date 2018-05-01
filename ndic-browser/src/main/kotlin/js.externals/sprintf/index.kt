package js.externals.sprintf

@JsNonModule
@JsModule("sprintf-js")
private external val Sprintf: SprintfInstance = definedExternally

private external interface SprintfInstance {
    fun sprintf(format: String, vararg args: Any?): String
    fun vsprintf(format: String, args: Any?): String
}

class Spritf {
    companion object {
        fun sprintf(format: String, vararg args: Any?): String = Sprintf.sprintf(format, args)
        fun vsprintf(format: String, args: Any?): String = Sprintf.vsprintf(format, args)
    }
}