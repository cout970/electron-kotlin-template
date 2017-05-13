@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class MenuItem constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor(options: electron.MenuItem.Options.() -> Unit) : this(Unit.let {
        val _constructor = js("require('electron').MenuItem")
        val _options = options.let { electron.MenuItem.Options().apply(it) }
        js("new _constructor(_options)")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.MenuItem.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Boolean indicating whether the item is enabled, this property can be
     * dynamically changed.
     */
    val enabled: Boolean get() = instance.enabled

    /**
     * A Boolean indicating whether the item is visible, this property can be
     * dynamically changed.
     */
    val visible: Boolean get() = instance.visible

    /**
     * A Boolean indicating whether the item is checked, this property can be
     * dynamically changed.
     *
     * A checkbox menu item will toggle the checked property on and off when selected.
     *
     * A radio menu item will turn on its checked property when clicked, and will
     * turn off that property for all adjacent items in the same menu.
     *
     * You can add a click function for additional behavior.
     */
    val checked: Boolean get() = instance.checked

    /**
     * A String representing the menu items visible label
     */
    val label: String get() = instance.label

    /**
     * A Function that is fired when the MenuItem recieves a click event
     */
    val click: (dynamic) -> Unit get() = instance.click


    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').MenuItem")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class Options(
            /**
             * Will be called with click(menuItem, browserWindow, event) when the menu item
             * is clicked.
             */
            var click: ((menuItem: electron.MenuItem, browserWindow: electron.BrowserWindow, event: dynamic) -> Unit)? = null,

            /**
             * Define the action of the menu item, when specified the click property will be
             * ignored.
             */
            var role: String? = null,

            /**
             * Can be normal, separator, submenu, checkbox or radio.
             */
            var type: String? = null,

            /**
             * (optional)
             */
            var label: String? = null,

            /**
             * (optional)
             */
            var sublabel: String? = null,

            /**
             *
             */
            var accelerator: String? = null,

            /**
             *
             */
            var icon: dynamic? = null,

            /**
             * If false, the menu item will be greyed out and unclickable.
             */
            var enabled: Boolean? = null,

            /**
             * If false, the menu item will be entirely hidden.
             */
            var visible: Boolean? = null,

            /**
             * Should only be specified for checkbox or radio type menu items.
             */
            var checked: Boolean? = null,

            /**
             * Should be specified for submenu type menu items. If submenu is specified, the
             * type: 'submenu' can be omitted. If the value is not a Menu then it will be
             * automatically converted to one using Menu.buildFromTemplate.
             */
            var submenu: dynamic? = null,

            /**
             * Unique within a single menu. If defined then it can be used as a reference to
             * this item by the position attribute.
             */
            var id: String? = null,

            /**
             * This field allows fine-grained definition of the specific location within a
             * given menu.
             */
            var position: String? = null

    )
}

