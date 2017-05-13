@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class Debugger constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').Debugger")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.Debugger.Companion.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Attaches the debugger to the webContents.
     *
     * @param protocolVersion Requested debugging protocol version.
     */
    fun attach(protocolVersion: String? = null): Unit =
            instance.attach(protocolVersion)

    /**
     * @returns Whether a debugger is attached to the webContents.
     */
    fun isAttached(): Boolean =
            instance.isAttached()

    /**
     * Detaches the debugger from the webContents.
     */
    fun detach(): Unit =
            instance.detach()

    /**
     * Send given command to the debugging target.
     *
     * @param method Method name, should be one of the methods defined by the remote debugging
     *               protocol.
     * @param commandParams JSON object with request parameters.
     * @param callback Response
     */
    fun sendCommand(method: String, commandParams: (electron.Debugger.SendCommandCommandParams.() -> Unit)? = null,
                    callback: ((error: electron.Debugger.SendCommandError.() -> Unit, result: Any) -> Unit)? = null): Unit =
            instance.sendCommand(method, commandParams?.let { electron.Debugger.SendCommandCommandParams().apply(it) },
                    callback)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').Debugger")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class SendCommandCommandParams

    class SendCommandError
}

