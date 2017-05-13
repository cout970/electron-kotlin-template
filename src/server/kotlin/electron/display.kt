@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class Display(
        /**
         * Unique identifier associated with the display.
         */
        var id: Number,

        /**
         * Can be 0, 90, 180, 270, represents screen rotation in clock-wise degrees.
         */
        var rotation: Number,

        /**
         * Output device's pixel scale factor.
         */
        var scaleFactor: Number,

        /**
         * Can be available, unavailable, unknown.
         */
        var touchSupport: String,

        /**
         *
         */
        var bounds: Rectangle,

        /**
         *
         */
        var size: electron.Display.Size,

        /**
         *
         */
        var workArea: Rectangle,

        /**
         *
         */
        var workAreaSize: electron.Display.WorkAreaSize

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------

    class Size(
            /**
             *
             */
            var height: Number,

            /**
             *
             */
            var width: Number

    )

    class WorkAreaSize(
            /**
             *
             */
            var height: Number,

            /**
             *
             */
            var width: Number

    )
}

