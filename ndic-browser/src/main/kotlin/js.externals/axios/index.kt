@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused")

package js.externals.axios

import kotlin.js.*

external interface AxiosTransformer {
    operator fun invoke(data: Any, headers: Any? = definedExternally /* null */): Any
}

external interface AxiosAdapter {
    operator fun invoke(config: RequestConfig): ResponsePromise<Any>
}

external interface AxiosBasicCredentials {
    var username: String
    var password: String
}

external interface Auth {
    var username: String
    var password: String
}

external interface AxiosProxyConfig {
    var host: String
    var port: Number
    var auth: Auth? get() = definedExternally; set(value) = definedExternally
}

external interface RequestConfig {
    var url: String? get() = definedExternally; set(value) = definedExternally
    var method: String? get() = definedExternally; set(value) = definedExternally
    var baseURL: String? get() = definedExternally; set(value) = definedExternally
    var transformRequest: dynamic /* AxiosTransformer | Array<AxiosTransformer> */ get() = definedExternally; set(value) = definedExternally
    var transformResponse: dynamic /* AxiosTransformer | Array<AxiosTransformer> */ get() = definedExternally; set(value) = definedExternally
    var headers: Any? get() = definedExternally; set(value) = definedExternally
    var params: Any? get() = definedExternally; set(value) = definedExternally
    var paramsSerializer: ((params: Any) -> String)? get() = definedExternally; set(value) = definedExternally
    var data: Any? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
    var withCredentials: Boolean? get() = definedExternally; set(value) = definedExternally
    var adapter: AxiosAdapter? get() = definedExternally; set(value) = definedExternally
    var auth: AxiosBasicCredentials? get() = definedExternally; set(value) = definedExternally
    var responseType: String? get() = definedExternally; set(value) = definedExternally
    var xsrfCookieName: String? get() = definedExternally; set(value) = definedExternally
    var xsrfHeaderName: String? get() = definedExternally; set(value) = definedExternally
    var onUploadProgress: ((progressEvent: Any) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var onDownloadProgress: ((progressEvent: Any) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var maxContentLength: Number? get() = definedExternally; set(value) = definedExternally
    var validateStatus: ((status: Number) -> Boolean)? get() = definedExternally; set(value) = definedExternally
    var maxRedirects: Number? get() = definedExternally; set(value) = definedExternally
    var httpAgent: Any? get() = definedExternally; set(value) = definedExternally
    var httpsAgent: Any? get() = definedExternally; set(value) = definedExternally
    var proxy: dynamic /* Boolean | AxiosProxyConfig */ get() = definedExternally; set(value) = definedExternally
    var cancelToken: CancelToken? get() = definedExternally; set(value) = definedExternally
}

external interface Response<T> {
    var data: T
    var status: Number
    var statusText: String
    var headers: Any
    var config: RequestConfig
    var request: Any? get() = definedExternally; set(value) = definedExternally
}

external interface Error {
    var config: RequestConfig
    var code: String? get() = definedExternally; set(value) = definedExternally
    var request: Any? get() = definedExternally; set(value) = definedExternally
    var response: Response<Any>? get() = definedExternally; set(value) = definedExternally
}

external interface ResponsePromise<T> : Promise<Response<T>>
external interface CancelStatic
external interface Cancel {
    var message: String
}

external interface Canceler {

    operator fun invoke(message: String? = definedExternally /* null */)
}

external interface CancelTokenStatic {
    fun source(): CancelTokenSource
}

external interface CancelToken {
    var promise: Promise<Cancel>
    var reason: Cancel? get() = definedExternally; set(value) = definedExternally
    fun throwIfRequested()
}

external interface CancelTokenSource {
    var token: CancelToken
    var cancel: Canceler
}

external interface InterceptorManager<V> {
    fun use(onFulfilled: ((value: V) -> V)? = definedExternally /* null */, onRejected: ((error: Any) -> Any)? = definedExternally /* null */): Number
    fun use(onFulfilled: ((value: V) -> Promise<V>)? = definedExternally /* null */, onRejected: ((error: Any) -> Any)? = definedExternally /* null */): Number
    fun eject(id: Number)
}

external interface Interceptors {
    var request: InterceptorManager<RequestConfig>
    var response: InterceptorManager<Response<Any>>
}

external interface AxiosInstance {
    operator fun invoke(config: RequestConfig): ResponsePromise<Any>

    operator fun invoke(url: String, config: RequestConfig? = definedExternally /* null */): ResponsePromise<Any>

    var defaults: RequestConfig
    var interceptors: Interceptors
    fun <T> request(config: RequestConfig): ResponsePromise<T>
    fun <T> get(url: String, config: RequestConfig? = definedExternally /* null */): ResponsePromise<T>
    fun delete(url: String, config: RequestConfig? = definedExternally /* null */): ResponsePromise<Any>
    fun head(url: String, config: RequestConfig? = definedExternally /* null */): ResponsePromise<Any>
    fun <T> post(url: String, data: Any? = definedExternally /* null */, config: RequestConfig? = definedExternally /* null */): ResponsePromise<T>
    fun <T> put(url: String, data: Any? = definedExternally /* null */, config: RequestConfig? = definedExternally /* null */): ResponsePromise<T>
    fun <T> patch(url: String, data: Any? = definedExternally /* null */, config: RequestConfig? = definedExternally /* null */): ResponsePromise<T>
}

external interface AxiosStatic : AxiosInstance {
    fun create(config: RequestConfig? = definedExternally /* null */): AxiosInstance
    var cancel: CancelStatic
    var cancelToken: CancelTokenStatic
    fun isCancel(value: Any): Boolean
    fun <T> all(values: Array<T>): Promise<Array<T>>
    fun <T> all(values: Array<Promise<T>>): Promise<Array<T>>
    fun <T, R> spread(callback: (args: T) -> R): (array: Array<T>) -> R
}

@JsNonModule
@JsModule("axios")
@JsName("axios")
external val Axios: AxiosStatic = definedExternally
