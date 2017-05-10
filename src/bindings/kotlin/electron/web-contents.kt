@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object webContents {

    private val module: dynamic = js("require('electron').webContents")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.webContents.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * @returns An array of all WebContents instances. This will contain web contents for all
     *          windows, webviews, opened devtools, and devtools extension background pages.
     */
    fun getAllWebContents(): Array<electron.WebContents> =
            electron.webContents.module.getAllWebContents()

    /**
     * @returns The web contents that is focused in this application, otherwise returns null.
     */
    fun getFocusedWebContents(): electron.WebContents =
            electron.webContents.module.getFocusedWebContents()

    /**
     * @param id
     *
     * @returns A WebContents instance with the given ID.
     */
    fun fromId(id: Int): electron.WebContents =
            electron.webContents.module.fromId(id)

    // ~ Builders ------------------------------------------------------------------------------
}

@Suppress("REDUNDANT_NULLABLE")
class WebContents constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').WebContents")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.WebContents.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Integer representing the unique ID of this WebContents.
     */
    val id: Int get() = instance.id

    /**
     * A Session object (session) used by this webContents.
     */
    val session: electron.Session get() = electron.Session(instance.session, Unit)

    /**
     * A WebContents instance that might own this WebContents.
     */
    val hostWebContents: electron.WebContents get() = electron.WebContents(instance.hostWebContents, Unit)

    /**
     * A WebContents of DevTools for this WebContents.
     *
     * Note: Users should never store this object because it may become null when the
     * DevTools has been closed.
     */
    val devToolsWebContents: electron.WebContents get() = electron.WebContents(instance.devToolsWebContents, Unit)

    /**
     * A Debugger instance for this webContents.
     */
    val debugger: electron.Debugger get() = electron.Debugger(instance.debugger, Unit)


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Loads the url in the window. The url must contain the protocol prefix, e.g.
     * the http:// or file://. If the load should bypass http cache then use the
     * pragma header to achieve it.
     *
     *  |
     *  | const {webContents} = require('electron')
     *  | const options = {extraHeaders: 'pragma: no-cache\n'}
     *  | webContents.loadURL('https://github.com', options)
     *  |
     *
     * @param url
     * @param options
     */
    fun loadURL(url: String, options: (electron.WebContents.LoadURLOptions.() -> Unit)? = null): Unit =
            instance.loadURL(url, options?.let { electron.WebContents.LoadURLOptions().apply(it) })

    /**
     * Initiates a download of the resource at url without navigating. The
     * will-download event of session will be triggered.
     *
     * @param url
     */
    fun downloadURL(url: String): Unit =
            instance.downloadURL(url)

    /**
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | let win = new BrowserWindow({width: 800, height: 600})
     *  | win.loadURL('http://github.com')
     *  |
     *  | let currentURL = win.webContents.getURL()
     *  | console.log(currentURL)
     *  |
     *
     * @returns The URL of the current web page.
     */
    fun getURL(): String =
            instance.getURL()

    /**
     * @returns The title of the current web page.
     */
    fun getTitle(): String =
            instance.getTitle()

    /**
     * @returns Whether the web page is destroyed.
     */
    fun isDestroyed(): Boolean =
            instance.isDestroyed()

    /**
     * @returns Whether the web page is focused.
     */
    fun isFocused(): Boolean =
            instance.isFocused()

    /**
     * @returns Whether web page is still loading resources.
     */
    fun isLoading(): Boolean =
            instance.isLoading()

    /**
     * @returns Whether the main frame (and not just iframes or frames within it) is still
     *          loading.
     */
    fun isLoadingMainFrame(): Boolean =
            instance.isLoadingMainFrame()

    /**
     * @returns Whether the web page is waiting for a first-response from the main resource of
     *          the page.
     */
    fun isWaitingForResponse(): Boolean =
            instance.isWaitingForResponse()

    /**
     * Stops any pending navigation.
     */
    fun stop(): Unit =
            instance.stop()

    /**
     * Reloads the current web page.
     */
    fun reload(): Unit =
            instance.reload()

    /**
     * Reloads current page and ignores cache.
     */
    fun reloadIgnoringCache(): Unit =
            instance.reloadIgnoringCache()

    /**
     * @returns Whether the browser can go back to previous web page.
     */
    fun canGoBack(): Boolean =
            instance.canGoBack()

    /**
     * @returns Whether the browser can go forward to next web page.
     */
    fun canGoForward(): Boolean =
            instance.canGoForward()

    /**
     * @param offset
     *
     * @returns Whether the web page can go to offset.
     */
    fun canGoToOffset(offset: Int): Boolean =
            instance.canGoToOffset(offset)

    /**
     * Clears the navigation history.
     */
    fun clearHistory(): Unit =
            instance.clearHistory()

    /**
     * Makes the browser go back a web page.
     */
    fun goBack(): Unit =
            instance.goBack()

    /**
     * Makes the browser go forward a web page.
     */
    fun goForward(): Unit =
            instance.goForward()

    /**
     * Navigates browser to the specified absolute web page index.
     *
     * @param index
     */
    fun goToIndex(index: Int): Unit =
            instance.goToIndex(index)

    /**
     * Navigates to the specified offset from the "current entry".
     *
     * @param offset
     */
    fun goToOffset(offset: Int): Unit =
            instance.goToOffset(offset)

    /**
     * @returns Whether the renderer process has crashed.
     */
    fun isCrashed(): Boolean =
            instance.isCrashed()

    /**
     * Overrides the user agent for this web page.
     *
     * @param userAgent
     */
    fun setUserAgent(userAgent: String): Unit =
            instance.setUserAgent(userAgent)

    /**
     * @returns The user agent for this web page.
     */
    fun getUserAgent(): String =
            instance.getUserAgent()

    /**
     * Injects CSS into the current web page.
     *
     * @param css
     */
    fun insertCSS(css: String): Unit =
            instance.insertCSS(css)

    /**
     * Evaluates code in page.
     *
     * In the browser window some HTML APIs like requestFullScreen can only be
     * invoked by a gesture from the user. Setting userGesture to true will remove
     * this limitation.
     *
     * If the result of the executed code is a promise the callback result will be
     * the resolved value of the promise. We recommend that you use the returned
     * Promise to handle code that results in a Promise.
     *
     *  |
     *  | contents.executeJavaScript('fetch("https://jsonplaceholder.typicode.com/users/1").then(resp => resp.json())', true)
     *  |   .then((result) => {
     *  |     console.log(result) // Will be the JSON object from the fetch call
     *  |   })
     *  |
     *
     * @param code
     * @param userGesture
     * @param callback Called after script has been executed.
     *
     * @returns A promise that resolves with the result of the executed code or is rejected if
     *          the result of the code is a rejected promise.
     */
    fun executeJavaScript(code: String, userGesture: Boolean? = null,
                          callback: ((result: Any) -> Unit)? = null): kotlin.js.Promise<dynamic> =
            instance.executeJavaScript(code, userGesture, callback)

    /**
     * Mute the audio on the current web page.
     *
     * @param muted
     */
    fun setAudioMuted(muted: Boolean): Unit =
            instance.setAudioMuted(muted)

    /**
     * @returns Whether this page has been muted.
     */
    fun isAudioMuted(): Boolean =
            instance.isAudioMuted()

    /**
     * Changes the zoom factor to the specified factor. Zoom factor is zoom percent
     * divided by 100, so 300% = 3.0.
     *
     * @param factor Zoom factor.
     */
    fun setZoomFactor(factor: Number): Unit =
            instance.setZoomFactor(factor)

    /**
     * Sends a request to get current zoom factor, the callback will be called with
     * callback(zoomFactor).
     *
     * @param callback
     */
    fun getZoomFactor(callback: (zoomFactor: Number) -> Unit): Unit =
            instance.getZoomFactor(callback)

    /**
     * Changes the zoom level to the specified level. The original size is 0 and each
     * increment above or below represents zooming 20% larger or smaller to default
     * limits of 300% and 50% of original size, respectively.
     *
     * @param level Zoom level
     */
    fun setZoomLevel(level: Number): Unit =
            instance.setZoomLevel(level)

    /**
     * Sends a request to get current zoom level, the callback will be called with
     * callback(zoomLevel).
     *
     * @param callback
     */
    fun getZoomLevel(callback: (zoomLevel: Number) -> Unit): Unit =
            instance.getZoomLevel(callback)

    /**
     * Deprecated: Call setVisualZoomLevelLimits instead to set the visual zoom level
     * limits. This method will be removed in Electron 2.0.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            instance.setZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Sets the maximum and minimum pinch-to-zoom level.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setVisualZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            instance.setVisualZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Sets the maximum and minimum layout-based (i.e. non-visual) zoom level.
     *
     * @param minimumLevel
     * @param maximumLevel
     */
    fun setLayoutZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit =
            instance.setLayoutZoomLevelLimits(minimumLevel, maximumLevel)

    /**
     * Executes the editing command undo in web page.
     */
    fun undo(): Unit =
            instance.undo()

    /**
     * Executes the editing command redo in web page.
     */
    fun redo(): Unit =
            instance.redo()

    /**
     * Executes the editing command cut in web page.
     */
    fun cut(): Unit =
            instance.cut()

    /**
     * Executes the editing command copy in web page.
     */
    fun copy(): Unit =
            instance.copy()

    /**
     * Copy the image at the given position to the clipboard.
     *
     * @param x
     * @param y
     */
    fun copyImageAt(x: Int, y: Int): Unit =
            instance.copyImageAt(x, y)

    /**
     * Executes the editing command paste in web page.
     */
    fun paste(): Unit =
            instance.paste()

    /**
     * Executes the editing command pasteAndMatchStyle in web page.
     */
    fun pasteAndMatchStyle(): Unit =
            instance.pasteAndMatchStyle()

    /**
     * Executes the editing command delete in web page.
     */
    fun delete(): Unit =
            instance.delete()

    /**
     * Executes the editing command selectAll in web page.
     */
    fun selectAll(): Unit =
            instance.selectAll()

    /**
     * Executes the editing command unselect in web page.
     */
    fun unselect(): Unit =
            instance.unselect()

    /**
     * Executes the editing command replace in web page.
     *
     * @param text
     */
    fun replace(text: String): Unit =
            instance.replace(text)

    /**
     * Executes the editing command replaceMisspelling in web page.
     *
     * @param text
     */
    fun replaceMisspelling(text: String): Unit =
            instance.replaceMisspelling(text)

    /**
     * Inserts text to the focused element.
     *
     * @param text
     */
    fun insertText(text: String): Unit =
            instance.insertText(text)

    /**
     * Starts a request to find all matches for the text in the web page and returns
     * an Integer representing the request id used for the request. The result of the
     * request can be obtained by subscribing to found-in-page event.
     *
     * @param text Content to be searched, must not be empty.
     * @param options
     */
    fun findInPage(text: String, options: (electron.WebContents.FindInPageOptions.() -> Unit)? = null): Unit =
            instance.findInPage(text, options?.let { electron.WebContents.FindInPageOptions().apply(it) })

    /**
     * Stops any findInPage request for the webContents with the provided action.
     *
     *  |
     *  | const {webContents} = require('electron')
     *  | webContents.on('found-in-page', (event, result) => {
     *  |   if (result.finalUpdate) webContents.stopFindInPage('clearSelection')
     *  | })
     *  |
     *  | const requestId = webContents.findInPage('api')
     *  | console.log(requestId)
     *  |
     *
     * @param action Specifies the action to take place when ending [webContents.findInPage]
     *               request.
     */
    fun stopFindInPage(action: String): Unit =
            instance.stopFindInPage(action)

    /**
     * Captures a snapshot of the page within rect. Upon completion callback will be
     * called with callback(image). The image is an instance of NativeImage that
     * stores data of the snapshot. Omitting rect will capture the whole visible page.
     *
     * @param rect The area of the page to be captured
     * @param callback
     */
    fun capturePage(rect: Rectangle? = null, callback: (image: electron.NativeImage) -> Unit): Unit =
            instance.capturePage(rect?.instance, callback)

    /**
     * Checks if any ServiceWorker is registered and returns a boolean as response to
     * callback.
     *
     * @param callback
     */
    fun hasServiceWorker(callback: (hasWorker: Boolean) -> Unit): Unit =
            instance.hasServiceWorker(callback)

    /**
     * Unregisters any ServiceWorker if present and returns a boolean as response to
     * callback when the JS promise is fulfilled or false when the JS promise is
     * rejected.
     *
     * @param callback
     */
    fun unregisterServiceWorker(callback: (success: Boolean) -> Unit): Unit =
            instance.unregisterServiceWorker(callback)

    /**
     * Prints window's web page. When silent is set to true, Electron will pick up
     * system's default printer and default settings for printing.
     *
     * Calling window.print() in web page is equivalent to calling
     * webContents.print({silent: false, printBackground: false}).
     *
     * Use page-break-before: always; CSS style to force to print to a new page.
     *
     * @param options
     */
    fun print(options: electron.WebContents.PrintOptions? = null): Unit =
            instance.print(options)

    /**
     * Prints window's web page as PDF with Chromium's preview printing custom
     * settings.
     *
     * The callback will be called with callback(error, data) on completion. The data
     * is a Buffer that contains the generated PDF data.
     *
     * The landscape will be ignored if @page CSS at-rule is used in the web page.
     *
     * By default, an empty options will be regarded as:
     *
     *  |
     *  | {
     *  |   marginsType: 0,
     *  |   printBackground: false,
     *  |   printSelectionOnly: false,
     *  |   landscape: false
     *  | }
     *  |
     *
     * Use page-break-before: always; CSS style to force to print to a new page.
     *
     * An example of webContents.printToPDF:
     *
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | const fs = require('fs')
     *  |
     *  | let win = new BrowserWindow({width: 800, height: 600})
     *  | win.loadURL('http://github.com')
     *  |
     *  | win.webContents.on('did-finish-load', () => {
     *  |   // Use default printing options
     *  |   win.webContents.printToPDF({}, (error, data) => {
     *  |     if (error) throw error
     *  |     fs.writeFile('/tmp/print.pdf', data, (error) => {
     *  |       if (error) throw error
     *  |       console.log('Write PDF successfully.')
     *  |     })
     *  |   })
     *  | })
     *  |
     *
     * @param options
     * @param callback
     */
    fun printToPDF(options: electron.WebContents.PrintToPDFOptions.() -> Unit,
                   callback: (error: Error, data: dynamic) -> Unit): Unit =
            instance.printToPDF(options.let { electron.WebContents.PrintToPDFOptions().apply(it) }, callback)

    /**
     * Adds the specified path to DevTools workspace. Must be used after DevTools
     * creation:
     *
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | let win = new BrowserWindow()
     *  | win.webContents.on('devtools-opened', () => {
     *  |   win.webContents.addWorkSpace(__dirname)
     *  | })
     *  |
     *
     * @param path
     */
    fun addWorkSpace(path: String): Unit =
            instance.addWorkSpace(path)

    /**
     * Removes the specified path from DevTools workspace.
     *
     * @param path
     */
    fun removeWorkSpace(path: String): Unit =
            instance.removeWorkSpace(path)

    /**
     * Opens the devtools.
     *
     * @param options
     */
    fun openDevTools(options: electron.WebContents.OpenDevToolsOptions? = null): Unit =
            instance.openDevTools(options)

    /**
     * Closes the devtools.
     */
    fun closeDevTools(): Unit =
            instance.closeDevTools()

    /**
     * @returns Whether the devtools is opened.
     */
    fun isDevToolsOpened(): Boolean =
            instance.isDevToolsOpened()

    /**
     * @returns Whether the devtools view is focused .
     */
    fun isDevToolsFocused(): Boolean =
            instance.isDevToolsFocused()

    /**
     * Toggles the developer tools.
     */
    fun toggleDevTools(): Unit =
            instance.toggleDevTools()

    /**
     * Starts inspecting element at position (x, y).
     *
     * @param x
     * @param y
     */
    fun inspectElement(x: Int, y: Int): Unit =
            instance.inspectElement(x, y)

    /**
     * Opens the developer tools for the service worker context.
     */
    fun inspectServiceWorker(): Unit =
            instance.inspectServiceWorker()

    /**
     * Send an asynchronous message to renderer process via channel, you can also
     * send arbitrary arguments. Arguments will be serialized in JSON internally and
     * hence no functions or prototype chain will be included.
     *
     * The renderer process can handle the message by listening to channel with the
     * ipcRenderer module.
     *
     * An example of sending messages from the main process to the renderer process:
     *
     *  |
     *  | // In the main process.
     *  | const {app, BrowserWindow} = require('electron')
     *  | let win = null
     *  |
     *  | app.on('ready', () => {
     *  |   win = new BrowserWindow({width: 800, height: 600})
     *  |   win.loadURL(`file://${__dirname}/index.html`)
     *  |   win.webContents.on('did-finish-load', () => {
     *  |     win.webContents.send('ping', 'whoooooooh!')
     *  |   })
     *  | })
     *  |
     *
     *  |
     *  | <!-- index.html -->
     *  | <html>
     *  | <body>
     *  |   <script>
     *  |     require('electron').ipcRenderer.on('ping', (event, message) => {
     *  |       console.log(message)  // Prints 'whoooooooh!'
     *  |     })
     *  |   </script>
     *  | </body>
     *  | </html>
     *  |
     *
     * @param channel
     * @param args
     */
    fun send(channel: String, vararg args: dynamic): Unit =
            instance.send(channel, args)

    /**
     * Enable device emulation with the given parameters.
     *
     * @param parameters
     */
    fun enableDeviceEmulation(parameters: electron.WebContents.EnableDeviceEmulationParameters): Unit =
            instance.enableDeviceEmulation(parameters)

    /**
     * Disable device emulation enabled by webContents.enableDeviceEmulation.
     */
    fun disableDeviceEmulation(): Unit =
            instance.disableDeviceEmulation()

    /**
     * Sends an input event to the page.
     *
     * For keyboard events, the event object also have following properties:
     *
     *  . keyCode String (required) - The character that will be sent as the keyboard
     *    event. Should only use the valid key codes in Accelerator.
     *
     * For mouse events, the event object also have following properties:
     *
     *  . x Integer (required)
     *  . y Integer (required)
     *  . button String - The button pressed, can be left, middle, right
     *  . globalX Integer
     *  . globalY Integer
     *  . movementX Integer
     *  . movementY Integer
     *  . clickCount Integer
     *
     * For the mouseWheel event, the event object also have following properties:
     *
     *  . deltaX Integer
     *  . deltaY Integer
     *  . wheelTicksX Integer
     *  . wheelTicksY Integer
     *  . accelerationRatioX Integer
     *  . accelerationRatioY Integer
     *  . hasPreciseScrollingDeltas Boolean
     *  . canScroll Boolean
     *
     *
     * @param event
     */
    fun sendInputEvent(event: electron.WebContents.SendInputEventEvent): Unit =
            instance.sendInputEvent(event)

    /**
     * Begin subscribing for presentation events and captured frames, the callback
     * will be called with callback(frameBuffer, dirtyRect) when there is a
     * presentation event.
     *
     * The frameBuffer is a Buffer that contains raw pixel data. On most machines,
     * the pixel data is effectively stored in 32bit BGRA format, but the actual
     * representation depends on the endianness of the processor (most modern
     * processors are little-endian, on machines with big-endian processors the data
     * is in 32bit ARGB format).
     *
     * The dirtyRect is an object with x, y, width, height properties that describes
     * which part of the page was repainted. If onlyDirty is set to true, frameBuffer
     * will only contain the repainted area. onlyDirty defaults to false.
     *
     * @param onlyDirty Defaults to false
     * @param callback
     */
    fun beginFrameSubscription(onlyDirty: Boolean? = null,
                               callback: (frameBuffer: dynamic, dirtyRect: Rectangle) -> Unit): Unit =
            instance.beginFrameSubscription(onlyDirty, callback)

    /**
     * End subscribing for frame presentation events.
     */
    fun endFrameSubscription(): Unit =
            instance.endFrameSubscription()

    /**
     * Sets the item as dragging item for current drag-drop operation, file is the
     * absolute path of the file to be dragged, and icon is the image showing under
     * the cursor when dragging.
     *
     * @param item
     */
    fun startDrag(item: electron.WebContents.StartDragItem): Unit =
            instance.startDrag(item)

    /**
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | let win = new BrowserWindow()
     *  |
     *  | win.loadURL('https://github.com')
     *  |
     *  | win.webContents.on('did-finish-load', () => {
     *  |   win.webContents.savePage('/tmp/test.html', 'HTMLComplete', (error) => {
     *  |     if (!error) console.log('Save page successfully')
     *  |   })
     *  | })
     *  |
     *
     * @param fullPath The full file path.
     * @param saveType Specify the save type.
     * @param callback (error) => {}.
     *
     * @returns true if the process of saving page has been initiated successfully.
     */
    fun savePage(fullPath: String, saveType: String, callback: (error: Error) -> Unit): Boolean =
            instance.savePage(fullPath, saveType, callback)

    /**
     * Shows pop-up dictionary that searches the selected word on the page.
     */
    fun showDefinitionForSelection(): Unit =
            instance.showDefinitionForSelection()

    /**
     * Set the size of the page. This is only supported for <webview> guest contents.
     *
     *  . options Object
     *
     *     . normal Object (optional) - Normal size of the page. This can be used in
     *       combination with the disableguestresize attribute to manually resize the
     *       webview guest contents.
     *
     *        . width Integer
     *        . height Integer
     *
     *
     * @param options
     */
    fun setSize(options: electron.WebContents.SetSizeOptions.() -> Unit): Unit =
            instance.setSize(options.let { electron.WebContents.SetSizeOptions().apply(it) })

    /**
     * @returns Indicates whether offscreen rendering is enabled.
     */
    fun isOffscreen(): Boolean =
            instance.isOffscreen()

    /**
     * If offscreen rendering is enabled and not painting, start painting.
     */
    fun startPainting(): Unit =
            instance.startPainting()

    /**
     * If offscreen rendering is enabled and painting, stop painting.
     */
    fun stopPainting(): Unit =
            instance.stopPainting()

    /**
     * @returns If offscreen rendering is enabled returns whether it is currently painting.
     */
    fun isPainting(): Boolean =
            instance.isPainting()

    /**
     * If offscreen rendering is enabled sets the frame rate to the specified number.
     * Only values between 1 and 60 are accepted.
     *
     * @param fps
     */
    fun setFrameRate(fps: Int): Unit =
            instance.setFrameRate(fps)

    /**
     * @returns If offscreen rendering is enabled returns the current frame rate.
     */
    fun getFrameRate(): Int =
            instance.getFrameRate()

    /**
     * If offscreen rendering is enabled invalidates the frame and generates a new
     * one through the 'paint' event.
     */
    fun invalidate(): Unit =
            instance.invalidate()

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').WebContents")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class LoadURLOptions(
            /**
             * A HTTP Referrer url.
             */
            var httpReferrer: String? = null,

            /**
             * A user agent originating the request.
             */
            var userAgent: String? = null,

            /**
             * Extra headers separated by ""
             */
            var extraHeaders: String? = null,

            /**
             * (optional)
             */
            var postData: Array<dynamic>? = null

    )

    class FindInPageOptions(
            /**
             * (optional) Whether to search forward or backward, defaults to true.
             */
            var forward: Boolean? = null,

            /**
             * (optional) Whether the operation is first request or a follow up, defaults to
             * false.
             */
            var findNext: Boolean? = null,

            /**
             * (optional) Whether search should be case-sensitive, defaults to false.
             */
            var matchCase: Boolean? = null,

            /**
             * (optional) Whether to look only at the start of words. defaults to false.
             */
            var wordStart: Boolean? = null,

            /**
             * (optional) When combined with wordStart, accepts a match in the middle of a
             * word if the match begins with an uppercase letter followed by a lowercase or
             * non-letter. Accepts several other intra-word matches, defaults to false.
             */
            var medialCapitalAsWordStart: Boolean? = null

    )

    class PrintOptions(
            /**
             * Don't ask user for print settings. Default is false.
             */
            var silent: Boolean,

            /**
             * Also prints the background color and image of the web page. Default is false.
             */
            var printBackground: Boolean

    )

    class PrintToPDFOptions(
            /**
             * (optional) Specifies the type of margins to use. Uses 0 for default margin, 1
             * for no margin, and 2 for minimum margin.
             */
            var marginsType: Int? = null,

            /**
             * (optional) Specify page size of the generated PDF. Can be A3, A4, A5, Legal,
             * Letter, Tabloid or an Object containing height and width in microns.
             */
            var pageSize: String? = null,

            /**
             * (optional) Whether to print CSS backgrounds.
             */
            var printBackground: Boolean? = null,

            /**
             * (optional) Whether to print selection only.
             */
            var printSelectionOnly: Boolean? = null,

            /**
             * (optional) true for landscape, false for portrait.
             */
            var landscape: Boolean? = null

    )

    class OpenDevToolsOptions(
            /**
             * Opens the devtools with specified dock state, can be right, bottom, undocked,
             * detach. Defaults to last used dock state. In undocked mode it's possible to
             * dock back. In detach mode it's not.
             */
            var mode: String

    )

    class EnableDeviceEmulationParameters(
            /**
             * Specify the screen type to emulate (default: desktop)
             */
            var screenPosition: String,

            /**
             * Set the emulated screen size (screenPosition == mobile)
             */
            var screenSize: electron.WebContents.EnableDeviceEmulationScreenSize,

            /**
             * Position the view on the screen (screenPosition == mobile) (default: {x: 0, y:
             * 0})
             */
            var viewPosition: electron.WebContents.EnableDeviceEmulationViewPosition,

            /**
             * Set the device scale factor (if zero defaults to original device scale factor)
             * (default: 0)
             */
            var deviceScaleFactor: Int,

            /**
             * Set the emulated view size (empty means no override)
             */
            var viewSize: electron.WebContents.EnableDeviceEmulationViewSize,

            /**
             * Whether emulated view should be scaled down if necessary to fit into available
             * space (default: false)
             */
            var fitToView: Boolean,

            /**
             * Offset of the emulated view inside available space (not in fit to view mode)
             * (default: {x: 0, y: 0})
             */
            var offset: electron.WebContents.EnableDeviceEmulationOffset,

            /**
             * Scale of emulated view inside available space (not in fit to view mode)
             * (default: 1)
             */
            var scale: Float

    )

    class EnableDeviceEmulationScreenSize(
            /**
             * Set the emulated screen width
             */
            var width: Int,

            /**
             * Set the emulated screen height
             */
            var height: Int

    )

    class EnableDeviceEmulationViewPosition(
            /**
             * Set the x axis offset from top left corner
             */
            var x: Int,

            /**
             * Set the y axis offset from top left corner
             */
            var y: Int

    )

    class EnableDeviceEmulationViewSize(
            /**
             * Set the emulated view width
             */
            var width: Int,

            /**
             * Set the emulated view height
             */
            var height: Int

    )

    class EnableDeviceEmulationOffset(
            /**
             * Set the x axis offset from top left corner
             */
            var x: Float,

            /**
             * Set the y axis offset from top left corner
             */
            var y: Float

    )


    class SendInputEventEvent(
            /**
             * The type of the event, can be mouseDown, mouseUp, mouseEnter, mouseLeave,
             * contextMenu, mouseWheel, mouseMove, keyDown, keyUp, char.
             */
            var type: String,

            /**
             * An array of modifiers of the event, can include shift, control, alt, meta,
             * isKeypad, isAutoRepeat, leftButtonDown, middleButtonDown, rightButtonDown,
             * capsLock, numLock, left, right.
             */
            var modifiers: Array<String>

    )

    class StartDragItem(
            /**
             * The path to the file being dragged.
             */
            var file: String,

            /**
             * The image must be non-empty on macOS.
             */
            var icon: electron.NativeImage

    )

    class SetSizeOptions(
            /**
             * Normal size of the page. This can be used in combination with the
             * disableguestresize attribute to manually resize the webview guest contents.
             */
            var normal: electron.WebContents.SetSizeNormal? = null

    )

    class SetSizeNormal(
            /**
             *
             */
            var width: Int,

            /**
             *
             */
            var height: Int

    )

}

