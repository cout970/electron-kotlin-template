@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class ThumbarButton(
        /**
         * The icon showing in thumbnail toolbar.
         */
        var icon: electron.NativeImage,

        /**
         *
         */
        var click: (dynamic) -> Unit,

        /**
         * The text of the button's tooltip.
         */
        var tooltip: String? = null,

        /**
         * Control specific states and behaviors of the button. By default, it is
         * ['enabled'].
         */
        var flags: Array<String>? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

