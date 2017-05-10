@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object powerSaveBlocker {

    private val module: dynamic = js("require('electron').powerSaveBlocker")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.powerSaveBlocker.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Starts preventing the system from entering lower-power mode. Returns an
     * integer identifying the power save blocker.
     *
     * Note:prevent-display-sleep has higher precedence over prevent-app-suspension.
     * Only the highest precedence type takes effect. In other words,
     * prevent-display-sleep always takes precedence over prevent-app-suspension.
     *
     * For example, an API calling A requests for prevent-app-suspension, and another
     * calling B requests for prevent-display-sleep. prevent-display-sleep will be
     * used until B stops its request. After that, prevent-app-suspension is used.
     *
     * @param type Power save blocker type.
     *
     * @returns The blocker ID that is assigned to this power blocker
     */
    fun start(type: String): Int =
            electron.powerSaveBlocker.module.start(type)

    /**
     * Stops the specified power save blocker.
     *
     * @param id The power save blocker id returned by powerSaveBlocker.start.
     */
    fun stop(id: Int): Unit =
            electron.powerSaveBlocker.module.stop(id)

    /**
     * @param id The power save blocker id returned by powerSaveBlocker.start.
     *
     * @returns Whether the corresponding powerSaveBlocker has started.
     */
    fun isStarted(id: Int): Boolean =
            electron.powerSaveBlocker.module.isStarted(id)

    // ~ Builders ------------------------------------------------------------------------------
}

