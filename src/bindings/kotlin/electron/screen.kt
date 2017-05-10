@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object screen {

    private val module: dynamic = js("require('electron').screen")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.screen.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     *  . x Integer
     *  . y Integer
     *
     * The current absolute position of the mouse pointer.
     *
     * @param x
     * @param y
     *
     * @returns
     */
    fun getCursorScreenPoint(x: Int, y: Int): dynamic =
            electron.screen.module.getCursorScreenPoint(x, y)

    /**
     * @returns The primary display.
     */
    fun getPrimaryDisplay(): electron.Display =
            electron.screen.module.getPrimaryDisplay()

    /**
     * @returns An array of displays that are currently available.
     */
    fun getAllDisplays(): Array<electron.Display> =
            electron.screen.module.getAllDisplays()

    /**
     * @param point
     *
     * @returns The display nearest the specified point.
     */
    fun getDisplayNearestPoint(point: electron.screen.GetDisplayNearestPointPoint): electron.Display =
            electron.screen.module.getDisplayNearestPoint(point)

    /**
     * @param rect
     *
     * @returns The display that most closely intersects the provided bounds.
     */
    fun getDisplayMatching(rect: Rectangle): electron.Display =
            electron.screen.module.getDisplayMatching(rect.instance)

    // ~ Builders ------------------------------------------------------------------------------

    class GetDisplayNearestPointPoint(
            /**
             *
             */
            var x: Int,

            /**
             *
             */
            var y: Int

    )
}

