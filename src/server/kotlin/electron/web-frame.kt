@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object webFrame {

    private val module: dynamic = js("require('electron').webFrame")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.webFrame.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Changes the zoom factor to the specified factor. Zoom factor is zoom percent
     * divided by 100, so 300% = 3.0.
     *
     * @param factor Zoom factor.
     */
    fun setZoomFactor(factor: Number): Unit =
            electron.webFrame.module.setZoomFactor(factor)

    /**
     * @returns The current zoom factor.
     */
    fun getZoomFactor(): Number =
            electron.webFrame.module.getZoomFactor()

    /**
     * Changes the zoom level to the specified level. The original size is 0 and each
     * increment above or below represents zooming 20% larger or smaller to default
     * limits of 300% and 50% of original size, respectively.
     *
     * @param level Zoom level
     */
    fun setZoomLevel(level: Number): Unit =
            electron.webFrame.module.setZoomLevel(level)

    /**
     * @returns The current zoom level.
     */
    fun getZoomLevel(): Number =
            electron.webFrame.module.getZoomLevel()

    /**
     * Deprecated: Call setVisualZoomLevelLimits instead to set the visual zoom level
     * limits. This method will be removed in Electron 2.0.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            electron.webFrame.module.setZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Sets the maximum and minimum pinch-to-zoom level.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setVisualZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            electron.webFrame.module.setVisualZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Sets the maximum and minimum layout-based (i.e. non-visual) zoom level.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setLayoutZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            electron.webFrame.module.setLayoutZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Sets a provider for spell checking in input fields and text areas.
     *
     * The provider must be an object that has a spellCheck method that returns
     * whether the word passed is correctly spelled.
     *
     * An example of using node-spellchecker as provider:
     *
     *  |
     *  | const {webFrame} = require('electron')
     *  | webFrame.setSpellCheckProvider('en-US', true, {
     *  |   spellCheck (text) {
     *  |     return !(require('spellchecker').isMisspelled(text))
     *  |   }
     *  | })
     *  |
     *
     * @param language
     * @param autoCorrectWord
     * @param provider
     */
    fun setSpellCheckProvider(language: String, autoCorrectWord: Boolean,
                              provider: electron.webFrame.SetSpellCheckProviderProvider): Unit =
            electron.webFrame.module.setSpellCheckProvider(language, autoCorrectWord, provider)

    /**
     * Registers the scheme as secure scheme.
     *
     * Secure schemes do not trigger mixed content warnings. For example, https and
     * data are secure schemes because they cannot be corrupted by active network
     * attackers.
     *
     * @param scheme
     */
    fun registerURLSchemeAsSecure(scheme: String): Unit =
            electron.webFrame.module.registerURLSchemeAsSecure(scheme)

    /**
     * Resources will be loaded from this scheme regardless of the current page's
     * Content Security Policy.
     *
     * @param scheme
     */
    fun registerURLSchemeAsBypassingCSP(scheme: String): Unit =
            electron.webFrame.module.registerURLSchemeAsBypassingCSP(scheme)

    /**
     * Registers the scheme as secure, bypasses content security policy for
     * resources, allows registering ServiceWorker and supports fetch API.
     *
     * Specify an option with the value of false to omit it from the registration. An
     * example of registering a privileged scheme, without bypassing Content Security
     * Policy:
     *
     *  |
     *  | const {webFrame} = require('electron')
     *  | webFrame.registerURLSchemeAsPrivileged('foo', { bypassCSP: false })
     *  |
     *
     * @param scheme
     * @param options
     */
    fun registerURLSchemeAsPrivileged(scheme: String,
                                      options: (electron.webFrame.RegisterURLSchemeAsPrivilegedOptions.() -> Unit)? = null): Unit =
            electron.webFrame.module.registerURLSchemeAsPrivileged(scheme,
                    options?.let { electron.webFrame.RegisterURLSchemeAsPrivilegedOptions().apply(it) })

    /**
     * Inserts text to the focused element.
     *
     * @param text
     */
    fun insertText(text: String): Unit =
            electron.webFrame.module.insertText(text)

    /**
     * Evaluates code in page.
     *
     * In the browser window some HTML APIs like requestFullScreen can only be
     * invoked by a gesture from the user. Setting userGesture to true will remove
     * this limitation.
     *
     * @param code
     * @param userGesture Default is false.
     * @param callback Called after script has been executed.
     */
    fun executeJavaScript(code: String, userGesture: Boolean? = null, callback: ((result: Any) -> Unit)? = null): Unit =
            electron.webFrame.module.executeJavaScript(code, userGesture, callback)

    /**
     *  . imagesMemoryUsageDetails
     *  . cssStyleSheetsMemoryUsageDetails
     *  . xslStyleSheetsMemoryUsageDetails
     *  . fontsMemoryUsageDetails
     *  . otherMemoryUsageDetails
     *
     *  |
     *  | const {webFrame} = require('electron')
     *  | console.log(webFrame.getResourceUsage())
     *  |
     *
     * This will generate:
     *
     *  |
     *  | {
     *  |   images: {
     *  |     count: 22,
     *  |     size: 2549,
     *  |     liveSize: 2542
     *  |   },
     *  |   cssStyleSheets: { /* same with "images" */ },
     *  |   xslStyleSheets: { /* same with "images" */ },
     *  |   fonts: { /* same with "images" */ },
     *  |   other: { /* same with "images" */ }
     *  | }
     *  |
     *
     * @param images
     * @param cssStyleSheets
     * @param xslStyleSheets
     * @param fonts
     * @param other
     *
     * @returns
     */
    fun getResourceUsage(images: MemoryUsageDetails, cssStyleSheets: MemoryUsageDetails,
                         xslStyleSheets: MemoryUsageDetails, fonts: MemoryUsageDetails,
                         other: MemoryUsageDetails): dynamic =
            electron.webFrame.module.getResourceUsage(images.instance, cssStyleSheets.instance, xslStyleSheets.instance,
                    fonts.instance, other.instance)

    /**
     * Attempts to free memory that is no longer being used (like images from a
     * previous navigation).
     *
     * Note that blindly calling this method probably makes Electron slower since it
     * will have to refill these emptied caches, you should only call it if an event
     * in your app has occurred that makes you think your page is actually using less
     * memory (i.e. you have navigated from a super heavy page to a mostly empty one,
     * and intend to stay there).
     */
    fun clearCache(): Unit =
            electron.webFrame.module.clearCache()

    // ~ Builders ------------------------------------------------------------------------------

    class SetSpellCheckProviderProvider(
            /**
             * Returns Boolean
             */
            var spellCheck: (text: String) -> Unit

    )

    class RegisterURLSchemeAsPrivilegedOptions(
            /**
             * (optional) Default true.
             */
            var secure: Boolean? = null,

            /**
             * (optional) Default true.
             */
            var bypassCSP: Boolean? = null,

            /**
             * (optional) Default true.
             */
            var allowServiceWorkers: Boolean? = null,

            /**
             * (optional) Default true.
             */
            var supportFetchAPI: Boolean? = null,

            /**
             * (optional) Default true.
             */
            var corsEnabled: Boolean? = null

    )
}

