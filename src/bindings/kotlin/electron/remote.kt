@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object remote {

    private val module: dynamic = js("require('electron').remote")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.remote.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * @returns The window to which this web page belongs.
     */
    fun getCurrentWindow(): electron.BrowserWindow =
            electron.remote.module.getCurrentWindow()

    /**
     * @returns The web contents of this web page.
     */
    fun getCurrentWebContents(): WebContents =
            electron.remote.module.getCurrentWebContents()

    /**
     * @param name
     *
     * @returns The global variable of name (e.g. global[name]) in the main process.
     */
    fun getGlobal(name: String): dynamic =
            electron.remote.module.getGlobal(name)

    // ~ Builders ------------------------------------------------------------------------------
}

