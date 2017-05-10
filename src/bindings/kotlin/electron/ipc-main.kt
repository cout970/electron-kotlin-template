@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object ipcMain {

    private val module: dynamic = js("require('electron').ipcMain")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.ipcMain.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Listens to channel, when a new message arrives listener would be called with
     * listener(event, args...).
     *
     * @param channel
     * @param listener
     */
    fun on(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcMain.module.on(channel, listener)

    /**
     * Adds a one time listener function for the event. This listener is invoked only
     * the next time a message is sent to channel, after which it is removed.
     *
     * @param channel
     * @param listener
     */
    fun once(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcMain.module.once(channel, listener)

    /**
     * Removes the specified listener from the listener array for the specified
     * channel.
     *
     * @param channel
     * @param listener
     */
    fun removeListener(channel: String, listener: (dynamic) -> Unit): Unit =
            electron.ipcMain.module.removeListener(channel, listener)

    /**
     * Removes all listeners, or those of the specified channel.
     *
     * @param channel
     */
    fun removeAllListeners(channel: String? = null): Unit =
            electron.ipcMain.module.removeAllListeners(channel)

    // ~ Builders ------------------------------------------------------------------------------
}

