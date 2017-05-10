@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class Menu constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').Menu")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.Menu.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A MenuItem[] array containing the menu's items.
     *
     * Each Menu consists of multiple MenuItems and each MenuItem can have a submenu.
     */
    val items: Array<electron.MenuItem> get() = (instance.items as Array<dynamic>).map {
        electron.MenuItem(it, Unit)
    }.toTypedArray()


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Pops up this menu as a context menu in the browserWindow.
     *
     * @param browserWindow Default is BrowserWindow.getFocusedWindow().
     * @param x Default is the current mouse cursor position.
     * @param y Default is the current mouse cursor position.
     * @param positioningItem The index of the menu item to be positioned under the mouse cursor at the
     *                        specified coordinates. Default is -1.
     */
    fun popup(browserWindow: electron.BrowserWindow? = null, x: Number? = null, y: Number,
              positioningItem: Number? = null): Unit =
            instance.popup(browserWindow?.instance, x, y, positioningItem)

    /**
     * Appends the menuItem to the menu.
     *
     * @param menuItem
     */
    fun append(menuItem: electron.MenuItem): Unit =
            instance.append(menuItem.instance)

    /**
     * Inserts the menuItem to the pos position of the menu.
     *
     * @param pos
     * @param menuItem
     */
    fun insert(pos: Int, menuItem: electron.MenuItem): Unit =
            instance.insert(pos, menuItem.instance)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').Menu")

        // ~ Methods -------------------------------------------------------------------------------

        /**
         * Sets menu as the application menu on macOS. On Windows and Linux, the menu
         * will be set as each window's top menu.
         *
         * Note: This API has to be called after the ready event of app module.
         *
         * @param menu
         */
        fun setApplicationMenu(menu: electron.Menu): Unit =
                electron.Menu.Companion.module.setApplicationMenu(menu.instance)

        /**
         * @returns The application menu, if set, or null, if not set.
         */
        fun getApplicationMenu(): electron.Menu =
                electron.Menu.Companion.module.getApplicationMenu()

        /**
         * Sends the action to the first responder of application. This is used for
         * emulating default Cocoa menu behaviors, usually you would just use the role
         * property of MenuItem.
         *
         * See the macOS Cocoa Event Handling Guide for more information on macOS' native
         * actions.
         *
         * @param action
         */
        fun sendActionToFirstResponder(action: String): Unit =
                electron.Menu.Companion.module.sendActionToFirstResponder(action)

        /**
         * Generally, the template is just an array of options for constructing a
         * MenuItem. The usage can be referenced above.
         *
         * You can also attach other fields to the element of the template and they will
         * become properties of the constructed menu items.
         *
         * @param template
         *
         * @returns
         */
        fun buildFromTemplate(template: Array<electron.MenuItem.Options>): electron.Menu =
                electron.Menu.Companion.module.buildFromTemplate(template)
    }

    // ~ Builders ------------------------------------------------------------------------------
}

