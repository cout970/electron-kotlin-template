@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object systemPreferences {

    private val module: dynamic = js("require('electron').systemPreferences")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.systemPreferences.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * @returns Whether the system is in Dark Mode.
     */
    fun isDarkMode(): Boolean =
            electron.systemPreferences.module.isDarkMode()

    /**
     * @returns Whether the Swipe between pages setting is on.
     */
    fun isSwipeTrackingFromScrollEventsEnabled(): Boolean =
            electron.systemPreferences.module.isSwipeTrackingFromScrollEventsEnabled()

    /**
     * Posts event as native notifications of macOS. The userInfo is an Object that
     * contains the user information dictionary sent along with the notification.
     *
     * @param event
     * @param userInfo
     */
    fun postNotification(event: String,
                         userInfo: electron.systemPreferences.PostNotificationUserInfo.() -> Unit): Unit =
            electron.systemPreferences.module.postNotification(event,
                    userInfo.let { electron.systemPreferences.PostNotificationUserInfo().apply(it) })

    /**
     * Posts event as native notifications of macOS. The userInfo is an Object that
     * contains the user information dictionary sent along with the notification.
     *
     * @param event
     * @param userInfo
     */
    fun postLocalNotification(event: String,
                              userInfo: electron.systemPreferences.PostLocalNotificationUserInfo.() -> Unit): Unit =
            electron.systemPreferences.module.postLocalNotification(event,
                    userInfo.let { electron.systemPreferences.PostLocalNotificationUserInfo().apply(it) })

    /**
     * Subscribes to native notifications of macOS, callback will be called with
     * callback(event, userInfo) when the corresponding event happens. The userInfo
     * is an Object that contains the user information dictionary sent along with the
     * notification.
     *
     * The id of the subscriber is returned, which can be used to unsubscribe the
     * event.
     *
     * Under the hood this API subscribes to NSDistributedNotificationCenter, example
     * values of event are:
     *
     *  . AppleInterfaceThemeChangedNotification
     *  . AppleAquaColorVariantChanged
     *  . AppleColorPreferencesChangedNotification
     *  . AppleShowScrollBarsSettingChanged
     *
     *
     * @param event
     * @param callback
     */
    fun subscribeNotification(event: String,
                              callback: (event: String, userInfo: electron.systemPreferences.SubscribeNotificationUserInfo.() -> Unit) -> Unit): Unit =
            electron.systemPreferences.module.subscribeNotification(event, callback)

    /**
     * Removes the subscriber with id.
     *
     * @param id
     */
    fun unsubscribeNotification(id: Int): Unit =
            electron.systemPreferences.module.unsubscribeNotification(id)

    /**
     * Same as subscribeNotification, but uses NSNotificationCenter for local
     * defaults. This is necessary for events such as
     * NSUserDefaultsDidChangeNotification
     *
     * @param event
     * @param callback
     */
    fun subscribeLocalNotification(event: String,
                                   callback: (event: String, userInfo: electron.systemPreferences.SubscribeLocalNotificationUserInfo.() -> Unit) -> Unit): Unit =
            electron.systemPreferences.module.subscribeLocalNotification(event, callback)

    /**
     * Same as unsubscribeNotification, but removes the subscriber from
     * NSNotificationCenter.
     *
     * @param id
     */
    fun unsubscribeLocalNotification(id: Int): Unit =
            electron.systemPreferences.module.unsubscribeLocalNotification(id)

    /**
     * Get the value of key in system preferences.
     *
     * This API uses NSUserDefaults on macOS. Some popular key and types are:
     *
     *  . AppleInterfaceStyle: string
     *  . AppleAquaColorVariant: integer
     *  . AppleHighlightColor: string
     *  . AppleShowScrollBars: string
     *  . NSNavRecentPlaces: array
     *  . NSPreferredWebServices: dictionary
     *  . NSUserDictionaryReplacementItems: array
     *
     *
     * @param key
     * @param type Can be string, boolean, integer, float, double, url, array, dictionary
     */
    fun getUserDefault(key: String, type: String): Unit =
            electron.systemPreferences.module.getUserDefault(key, type)

    /**
     * Set the value of key in system preferences.
     *
     * Note that type should match actual type of value. An exception is thrown if
     * they don't.
     *
     * This API uses NSUserDefaults on macOS. Some popular key and types are:
     *
     *  . ApplePressAndHoldEnabled: boolean
     *
     *
     * @param key
     * @param type See [getUserDefault][#systempreferencesgetuserdefaultkey-type-macos]
     * @param value
     */
    fun setUserDefault(key: String, type: String, value: String): Unit =
            electron.systemPreferences.module.setUserDefault(key, type, value)

    /**
     * This method returns true if DWM composition (Aero Glass) is enabled, and false
     * otherwise.
     *
     * An example of using it to determine if you should create a transparent window
     * or not (transparent windows won't work correctly when DWM composition is
     * disabled):
     *
     *  |
     *  | const {BrowserWindow, systemPreferences} = require('electron')
     *  | let browserOptions = {width: 1000, height: 800}
     *  |
     *  | // Make the window transparent only if the platform supports it.
     *  | if (process.platform !== 'win32' || systemPreferences.isAeroGlassEnabled()) {
     *  |   browserOptions.transparent = true
     *  |   browserOptions.frame = false
     *  | }
     *  |
     *  | // Create the window.
     *  | let win = new BrowserWindow(browserOptions)
     *  |
     *  | // Navigate.
     *  | if (browserOptions.transparent) {
     *  |   win.loadURL(`file://${__dirname}/index.html`)
     *  | } else {
     *  |   // No transparency, so we load a fallback that uses basic styles.
     *  |   win.loadURL(`file://${__dirname}/fallback.html`)
     *  | }
     *  |
     */
    fun isAeroGlassEnabled(): Unit =
            electron.systemPreferences.module.isAeroGlassEnabled()

    /**
     *  |
     *  | const color = systemPreferences.getAccentColor() // `"aabbccdd"`
     *  | const red = color.substr(0, 2) // "aa"
     *  | const green = color.substr(2, 2) // "bb"
     *  | const blue = color.substr(4, 2) // "cc"
     *  | const alpha = color.substr(6, 2) // "dd"
     *  |
     *
     * @returns The users current system wide accent color preference in RGBA hexadecimal form.
     */
    fun getAccentColor(): String =
            electron.systemPreferences.module.getAccentColor()

    /**
     * @param color One of the following values:
     *
     * @returns The system color setting in RGB hexadecimal form (#ABCDEF). See the Windows
     *          docs for more details.
     */
    fun getColor(color: String): String =
            electron.systemPreferences.module.getColor(color)

    /**
     * @returns true if an inverted color scheme, such as a high contrast theme, is active,
     *          false otherwise.
     */
    fun isInvertedColorScheme(): Boolean =
            electron.systemPreferences.module.isInvertedColorScheme()

    // ~ Builders ------------------------------------------------------------------------------

    class PostNotificationUserInfo

    class PostLocalNotificationUserInfo

    class SubscribeNotificationUserInfo

    class SubscribeLocalNotificationUserInfo
}

