@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object globalShortcut {

    private val module: dynamic = js("require('electron').globalShortcut")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.globalShortcut.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Registers a global shortcut of accelerator. The callback is called when the
     * registered shortcut is pressed by the user.
     *
     * When the accelerator is already taken by other applications, this call will
     * silently fail. This behavior is intended by operating systems, since they
     * don't want applications to fight for global shortcuts.
     *
     * @param accelerator
     * @param callback
     */
    fun register(accelerator: String, callback: (dynamic) -> Unit): Unit =
            electron.globalShortcut.module.register(accelerator, callback)

    /**
     * When the accelerator is already taken by other applications, this call will
     * still return false. This behavior is intended by operating systems, since they
     * don't want applications to fight for global shortcuts.
     *
     * @param accelerator
     *
     * @returns Whether this application has registered accelerator.
     */
    fun isRegistered(accelerator: String): Boolean =
            electron.globalShortcut.module.isRegistered(accelerator)

    /**
     * Unregisters the global shortcut of accelerator.
     *
     * @param accelerator
     */
    fun unregister(accelerator: String): Unit =
            electron.globalShortcut.module.unregister(accelerator)

    /**
     * Unregisters all of the global shortcuts.
     */
    fun unregisterAll(): Unit =
            electron.globalShortcut.module.unregisterAll()

    // ~ Builders ------------------------------------------------------------------------------
}

