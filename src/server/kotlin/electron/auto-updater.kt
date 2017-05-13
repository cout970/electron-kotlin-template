@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object autoUpdater {

    private val module: dynamic = js("require('electron').autoUpdater")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.autoUpdater.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Sets the url and initialize the auto updater.
     *
     * @param url
     * @param requestHeaders HTTP request headers.
     */
    fun setFeedURL(url: String,
                   requestHeaders: (electron.autoUpdater.SetFeedURLRequestHeaders.() -> Unit)? = null): Unit =
            electron.autoUpdater.module.setFeedURL(url,
                    requestHeaders?.let { electron.autoUpdater.SetFeedURLRequestHeaders().apply(it) })

    /**
     * @returns The current update feed URL.
     */
    fun getFeedURL(): String =
            electron.autoUpdater.module.getFeedURL()

    /**
     * Asks the server whether there is an update. You must call setFeedURL before
     * using this API.
     */
    fun checkForUpdates(): Unit =
            electron.autoUpdater.module.checkForUpdates()

    /**
     * Restarts the app and installs the update after it has been downloaded. It
     * should only be called after update-downloaded has been emitted.
     *
     * Note:autoUpdater.quitAndInstall() will close all application windows first and
     * only emit before-quit event on app after that. This is different from the
     * normal quit event sequence.
     */
    fun quitAndInstall(): Unit =
            electron.autoUpdater.module.quitAndInstall()

    // ~ Builders ------------------------------------------------------------------------------

    class SetFeedURLRequestHeaders
}

