@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class IncomingMessage constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').IncomingMessage")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.IncomingMessage.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * An Integer indicating the HTTP response status code.
     */
    val statusCode: Int get() = instance.statusCode

    /**
     * A String representing the HTTP status message.
     */
    val statusMessage: String get() = instance.statusMessage

    /**
     * An Object representing the response HTTP headers. The headers object is
     * formatted as follows:
     *
     *  . All header names are lowercased.
     *  . Each header name produces an array-valued property on the headers object.
     *  . Each header value is pushed into the array associated with its header name.
     *
     */
    val headers: dynamic get() = instance.headers

    /**
     * A String indicating the HTTP protocol version number. Typical values are '1.0'
     * or '1.1'. Additionally httpVersionMajor and httpVersionMinor are two
     * Integer-valued readable properties that return respectively the HTTP major and
     * minor version numbers.
     */
    val httpVersion: String get() = instance.httpVersion

    /**
     * An Integer indicating the HTTP protocol major version number.
     */
    val httpVersionMajor: Int get() = instance.httpVersionMajor

    /**
     * An Integer indicating the HTTP protocol minor version number.
     */
    val httpVersionMinor: Int get() = instance.httpVersionMinor


    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').IncomingMessage")

    }

    // ~ Builders ------------------------------------------------------------------------------
}

