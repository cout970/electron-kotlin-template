@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class BrowserWindowProxy constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').BrowserWindowProxy")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.BrowserWindowProxy.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Boolean that is set to true after the child window gets closed.
     */
    val closed: Boolean get() = instance.closed


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Removes focus from the child window.
     */
    fun blur(): Unit =
            instance.blur()

    /**
     * Forcefully closes the child window without calling its unload event.
     */
    fun close(): Unit =
            instance.close()

    /**
     * Evaluates the code in the child window.
     *
     * @param code
     */
    fun eval(code: String): Unit =
            instance.eval(code)

    /**
     * Focuses the child window (brings the window to front).
     */
    fun focus(): Unit =
            instance.focus()

    /**
     * Invokes the print dialog on the child window.
     */
    fun print(): Unit =
            instance.print()

    /**
     * Sends a message to the child window with the specified origin or * for no
     * origin preference.
     *
     * In addition to these methods, the child window implements window.opener object
     * with no properties and a single method.
     *
     * @param message
     * @param targetOrigin
     */
    fun postMessage(message: String, targetOrigin: String): Unit =
            instance.postMessage(message, targetOrigin)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').BrowserWindowProxy")

    }

    // ~ Builders ------------------------------------------------------------------------------
}

