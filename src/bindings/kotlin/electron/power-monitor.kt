@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object powerMonitor {

    private val module: dynamic = js("require('electron').powerMonitor")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.powerMonitor.module.on(event, callback)


    // ~ Builders ------------------------------------------------------------------------------
}

