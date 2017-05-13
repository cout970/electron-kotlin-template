@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object ipcRenderer {

    private val module: dynamic = js("require('electron').ipcRenderer")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.ipcRenderer.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Listens to channel, when a new message arrives listener would be called with
     * listener(event, args...).
     *
     * @param channel
     * @param listener
     */
    fun on(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcRenderer.module.on(channel, listener)

    /**
     * Adds a one time listener function for the event. This listener is invoked only
     * the next time a message is sent to channel, after which it is removed.
     *
     * @param channel
     * @param listener
     */
    fun once(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcRenderer.module.once(channel, listener)

    /**
     * Removes the specified listener from the listener array for the specified
     * channel.
     *
     * @param channel
     * @param listener
     */
    fun removeListener(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcRenderer.module.removeListener(channel, listener)

    /**
     * Removes all listeners, or those of the specified channel.
     *
     * @param channel
     */
    fun removeAllListeners(channel: String? = null): Unit =
            electron.ipcRenderer.module.removeAllListeners(channel)

    /**
     * Send a message to the main process asynchronously via channel, you can also
     * send arbitrary arguments. Arguments will be serialized in JSON internally and
     * hence no functions or prototype chain will be included.
     *
     * The main process handles it by listening for channel with ipcMain module.
     *
     * @param channel
     * @param args
     */
    fun send(channel: String, vararg args: dynamic): Unit =
            electron.ipcRenderer.module.send(channel, args)

    /**
     * Send a message to the main process synchronously via channel, you can also
     * send arbitrary arguments. Arguments will be serialized in JSON internally and
     * hence no functions or prototype chain will be included.
     *
     * The main process handles it by listening for channel with ipcMain module, and
     * replies by setting event.returnValue.
     *
     * Note: Sending a synchronous message will block the whole renderer process,
     * unless you know what you are doing you should never use it.
     *
     * @param channel
     * @param args
     */
    fun sendSync(channel: String, vararg args: dynamic): Unit =
            electron.ipcRenderer.module.sendSync(channel, args)

    /**
     * Like ipcRenderer.send but the event will be sent to the <webview> element in
     * the host page instead of the main process.
     *
     * @param channel
     * @param args
     */
    fun sendToHost(channel: String, vararg args: dynamic): Unit =
            electron.ipcRenderer.module.sendToHost(channel, args)

    // ~ Builders ------------------------------------------------------------------------------
}

