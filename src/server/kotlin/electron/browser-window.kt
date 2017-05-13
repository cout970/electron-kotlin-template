@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class BrowserWindow constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor(options: (electron.BrowserWindow.Options.() -> Unit)? = null) : this(Unit.let {
        val _constructor = js("require('electron').BrowserWindow")
        val _options = options?.let { electron.BrowserWindow.Options().apply(it) }
        js("new _constructor(_options)")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            instance.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A WebContents object this window owns. All web page related events and
     * operations will be done via it.
     *
     * See the webContents documentation for its methods and events.
     */
    val webContents: WebContents get() = WebContents(instance.webContents, Unit)

    /**
     * A Integer representing the unique ID of the window.
     */
    val id: Int get() = instance.id


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Force closing the window, the unload and beforeunload event won't be emitted
     * for the web page, and close event will also not be emitted for this window,
     * but it guarantees the closed event will be emitted.
     */
    fun destroy(): Unit =
            instance.destroy()

    /**
     * Try to close the window. This has the same effect as a user manually clicking
     * the close button of the window. The web page may cancel the close though. See
     * the close event.
     */
    fun close(): Unit =
            instance.close()

    /**
     * Focuses on the window.
     */
    fun focus(): Unit =
            instance.focus()

    /**
     * Removes focus from the window.
     */
    fun blur(): Unit =
            instance.blur()

    /**
     * @returns Whether the window is focused.
     */
    fun isFocused(): Boolean =
            instance.isFocused()

    /**
     * @returns Whether the window is destroyed.
     */
    fun isDestroyed(): Boolean =
            instance.isDestroyed()

    /**
     * Shows and gives focus to the window.
     */
    fun show(): Unit =
            instance.show()

    /**
     * Shows the window but doesn't focus on it.
     */
    fun showInactive(): Unit =
            instance.showInactive()

    /**
     * Hides the window.
     */
    fun hide(): Unit =
            instance.hide()

    /**
     * @returns Whether the window is visible to the user.
     */
    fun isVisible(): Boolean =
            instance.isVisible()

    /**
     * @returns Whether current window is a modal window.
     */
    fun isModal(): Boolean =
            instance.isModal()

    /**
     * Maximizes the window.
     */
    fun maximize(): Unit =
            instance.maximize()

    /**
     * Unmaximizes the window.
     */
    fun unmaximize(): Unit =
            instance.unmaximize()

    /**
     * @returns Whether the window is maximized.
     */
    fun isMaximized(): Boolean =
            instance.isMaximized()

    /**
     * Minimizes the window. On some platforms the minimized window will be shown in
     * the Dock.
     */
    fun minimize(): Unit =
            instance.minimize()

    /**
     * Restores the window from minimized state to its previous state.
     */
    fun restore(): Unit =
            instance.restore()

    /**
     * @returns Whether the window is minimized.
     */
    fun isMinimized(): Boolean =
            instance.isMinimized()

    /**
     * Sets whether the window should be in fullscreen mode.
     *
     * @param flag
     */
    fun setFullScreen(flag: Boolean): Unit =
            instance.setFullScreen(flag)

    /**
     * @returns Whether the window is in fullscreen mode.
     */
    fun isFullScreen(): Boolean =
            instance.isFullScreen()

    /**
     * This will make a window maintain an aspect ratio. The extra size allows a
     * developer to have space, specified in pixels, not included within the aspect
     * ratio calculations. This API already takes into account the difference between
     * a window's size and its content size.
     *
     * Consider a normal window with an HD video player and associated controls.
     * Perhaps there are 15 pixels of controls on the left edge, 25 pixels of
     * controls on the right edge and 50 pixels of controls below the player. In
     * order to maintain a 16:9 aspect ratio (standard aspect ratio for HD
     * @1920x1080) within the player itself we would call this function with
     * arguments of 16/9 and [ 40, 50 ]. The second argument doesn't care where the
     * extra width and height are within the content view--only that they exist. Just
     * sum any extra width and height areas you have within the overall content view.
     *
     * @param aspectRatio The aspect ratio to maintain for some portion of the content view.
     * @param extraSize The extra size not to be included while maintaining the aspect ratio.
     */
    fun setAspectRatio(aspectRatio: Float, extraSize: electron.BrowserWindow.SetAspectRatioExtraSize? = null): Unit =
            instance.setAspectRatio(aspectRatio, extraSize)

    /**
     * Uses Quick Look to preview a file at a given path.
     *
     * @param path The absolute path to the file to preview with QuickLook. This is important as
     *             Quick Look uses the file name and file extension on the path to determine the
     *             content type of the file to open.
     * @param displayName The name of the file to display on the Quick Look modal view. This is purely
     *                    visual and does not affect the content type of the file. Defaults to path.
     */
    fun previewFile(path: String, displayName: String? = null): Unit =
            instance.previewFile(path, displayName)

    /**
     * Closes the currently open Quick Look panel.
     */
    fun closeFilePreview(): Unit =
            instance.closeFilePreview()

    /**
     * Resizes and moves the window to the supplied bounds
     *
     * @param bounds
     * @param animate
     */
    fun setBounds(bounds: Rectangle, animate: Boolean? = null): Unit =
            instance.setBounds(bounds.instance, animate)

    /**
     * @returns
     */
    fun getBounds(): Rectangle =
            instance.getBounds()

    /**
     * Resizes and moves the window's client area (e.g. the web page) to the supplied
     * bounds.
     *
     * @param bounds
     * @param animate
     */
    fun setContentBounds(bounds: Rectangle, animate: Boolean? = null): Unit =
            instance.setContentBounds(bounds.instance, animate)

    /**
     * @returns
     */
    fun getContentBounds(): Rectangle =
            instance.getContentBounds()

    /**
     * Resizes the window to width and height.
     *
     * @param width
     * @param height
     * @param animate
     */
    fun setSize(width: Int, height: Int, animate: Boolean? = null): Unit =
            instance.setSize(width, height, animate)

    /**
     * @returns Contains the window's width and height.
     */
    fun getSize(): Array<Int> =
            instance.getSize()

    /**
     * Resizes the window's client area (e.g. the web page) to width and height.
     *
     * @param width
     * @param height
     * @param animate
     */
    fun setContentSize(width: Int, height: Int, animate: Boolean? = null): Unit =
            instance.setContentSize(width, height, animate)

    /**
     * @returns Contains the window's client area's width and height.
     */
    fun getContentSize(): Array<Int> =
            instance.getContentSize()

    /**
     * Sets the minimum size of window to width and height.
     *
     * @param width
     * @param height
     */
    fun setMinimumSize(width: Int, height: Int): Unit =
            instance.setMinimumSize(width, height)

    /**
     * @returns Contains the window's minimum width and height.
     */
    fun getMinimumSize(): Array<Int> =
            instance.getMinimumSize()

    /**
     * Sets the maximum size of window to width and height.
     *
     * @param width
     * @param height
     */
    fun setMaximumSize(width: Int, height: Int): Unit =
            instance.setMaximumSize(width, height)

    /**
     * @returns Contains the window's maximum width and height.
     */
    fun getMaximumSize(): Array<Int> =
            instance.getMaximumSize()

    /**
     * Sets whether the window can be manually resized by user.
     *
     * @param resizable
     */
    fun setResizable(resizable: Boolean): Unit =
            instance.setResizable(resizable)

    /**
     * @returns Whether the window can be manually resized by user.
     */
    fun isResizable(): Boolean =
            instance.isResizable()

    /**
     * Sets whether the window can be moved by user. On Linux does nothing.
     *
     * @param movable
     */
    fun setMovable(movable: Boolean): Unit =
            instance.setMovable(movable)

    /**
     * On Linux always returns true.
     *
     * @returns Whether the window can be moved by user.
     */
    fun isMovable(): Boolean =
            instance.isMovable()

    /**
     * Sets whether the window can be manually minimized by user. On Linux does
     * nothing.
     *
     * @param minimizable
     */
    fun setMinimizable(minimizable: Boolean): Unit =
            instance.setMinimizable(minimizable)

    /**
     * On Linux always returns true.
     *
     * @returns Whether the window can be manually minimized by user
     */
    fun isMinimizable(): Boolean =
            instance.isMinimizable()

    /**
     * Sets whether the window can be manually maximized by user. On Linux does
     * nothing.
     *
     * @param maximizable
     */
    fun setMaximizable(maximizable: Boolean): Unit =
            instance.setMaximizable(maximizable)

    /**
     * On Linux always returns true.
     *
     * @returns Whether the window can be manually maximized by user.
     */
    fun isMaximizable(): Boolean =
            instance.isMaximizable()

    /**
     * Sets whether the maximize/zoom window button toggles fullscreen mode or
     * maximizes the window.
     *
     * @param fullscreenable
     */
    fun setFullScreenable(fullscreenable: Boolean): Unit =
            instance.setFullScreenable(fullscreenable)

    /**
     * @returns Whether the maximize/zoom window button toggles fullscreen mode or maximizes
     *          the window.
     */
    fun isFullScreenable(): Boolean =
            instance.isFullScreenable()

    /**
     * Sets whether the window can be manually closed by user. On Linux does nothing.
     *
     * @param closable
     */
    fun setClosable(closable: Boolean): Unit =
            instance.setClosable(closable)

    /**
     * On Linux always returns true.
     *
     * @returns Whether the window can be manually closed by user.
     */
    fun isClosable(): Boolean =
            instance.isClosable()

    /**
     * Sets whether the window should show always on top of other windows. After
     * setting this, the window is still a normal window, not a toolbox window which
     * can not be focused on.
     *
     * @param flag
     * @param level Values include normal, floating, torn-off-menu, modal-panel, main-menu,
     *              status, pop-up-menu, screen-saver, and dock (Deprecated). The default is
     *              floating. See the macOS docs for more details.
     * @param relativeLevel The number of layers higher to set this window relative to the given level.
     *                      The default is 0. Note that Apple discourages setting levels higher than 1
     *                      above screen-saver.
     */
    fun setAlwaysOnTop(flag: Boolean, level: String? = null, relativeLevel: Int? = null): Unit =
            instance.setAlwaysOnTop(flag, level, relativeLevel)

    /**
     * @returns Whether the window is always on top of other windows.
     */
    fun isAlwaysOnTop(): Boolean =
            instance.isAlwaysOnTop()

    /**
     * Moves window to the center of the screen.
     */
    fun center(): Unit =
            instance.center()

    /**
     * Moves window to x and y.
     *
     * @param x
     * @param y
     * @param animate
     */
    fun setPosition(x: Int, y: Int, animate: Boolean? = null): Unit =
            instance.setPosition(x, y, animate)

    /**
     * @returns Contains the window's current position.
     */
    fun getPosition(): Array<Int> =
            instance.getPosition()

    /**
     * Changes the title of native window to title.
     *
     * @param title
     */
    fun setTitle(title: String): Unit =
            instance.setTitle(title)

    /**
     * Note: The title of web page can be different from the title of the native
     * window.
     *
     * @returns The title of the native window.
     */
    fun getTitle(): String =
            instance.getTitle()

    /**
     * Changes the attachment point for sheets on macOS. By default, sheets are
     * attached just below the window frame, but you may want to display them beneath
     * a HTML-rendered toolbar. For example:
     *
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | let win = new BrowserWindow()
     *  |
     *  | let toolbarRect = document.getElementById('toolbar').getBoundingClientRect()
     *  | win.setSheetOffset(toolbarRect.height)
     *  |
     *
     * @param offsetY
     * @param offsetX
     */
    fun setSheetOffset(offsetY: Float, offsetX: Float? = null): Unit =
            instance.setSheetOffset(offsetY, offsetX)

    /**
     * Starts or stops flashing the window to attract user's attention.
     *
     * @param flag
     */
    fun flashFrame(flag: Boolean): Unit =
            instance.flashFrame(flag)

    /**
     * Makes the window not show in the taskbar.
     *
     * @param skip
     */
    fun setSkipTaskbar(skip: Boolean): Unit =
            instance.setSkipTaskbar(skip)

    /**
     * Enters or leaves the kiosk mode.
     *
     * @param flag
     */
    fun setKiosk(flag: Boolean): Unit =
            instance.setKiosk(flag)

    /**
     * @returns Whether the window is in kiosk mode.
     */
    fun isKiosk(): Boolean =
            instance.isKiosk()

    /**
     * The native type of the handle is HWND on Windows, NSView* on macOS, and Window
     * (unsigned long) on Linux.
     *
     * @returns The platform-specific handle of the window.
     */
    fun getNativeWindowHandle(): dynamic =
            instance.getNativeWindowHandle()

    /**
     * Hooks a windows message. The callback is called when the message is received
     * in the WndProc.
     *
     * @param message
     * @param callback
     */
    fun hookWindowMessage(message: Int, callback: (dynamic) -> Unit): Unit =
            instance.hookWindowMessage(message, callback)

    /**
     * @param message
     *
     * @returns true or false depending on whether the message is hooked.
     */
    fun isWindowMessageHooked(message: Int): Boolean =
            instance.isWindowMessageHooked(message)

    /**
     * Unhook the window message.
     *
     * @param message
     */
    fun unhookWindowMessage(message: Int): Unit =
            instance.unhookWindowMessage(message)

    /**
     * Unhooks all of the window messages.
     */
    fun unhookAllWindowMessages(): Unit =
            instance.unhookAllWindowMessages()

    /**
     * Sets the pathname of the file the window represents, and the icon of the file
     * will show in window's title bar.
     *
     * @param filename
     */
    fun setRepresentedFilename(filename: String): Unit =
            instance.setRepresentedFilename(filename)

    /**
     * @returns The pathname of the file the window represents.
     */
    fun getRepresentedFilename(): String =
            instance.getRepresentedFilename()

    /**
     * Specifies whether the window’s document has been edited, and the icon in title
     * bar will become gray when set to true.
     *
     * @param edited
     */
    fun setDocumentEdited(edited: Boolean): Unit =
            instance.setDocumentEdited(edited)

    /**
     * @returns Whether the window's document has been edited.
     */
    fun isDocumentEdited(): Boolean =
            instance.isDocumentEdited()

    /**
     *
     */
    fun focusOnWebView(): Unit =
            instance.focusOnWebView()

    /**
     *
     */
    fun blurWebView(): Unit =
            instance.blurWebView()

    /**
     * Same as webContents.capturePage([rect, ]callback).
     *
     * @param rect The bounds to capture
     * @param callback
     */
    fun capturePage(rect: Rectangle? = null, callback: (image: NativeImage) -> Unit): Unit =
            instance.capturePage(rect?.instance, callback)

    /**
     * Same as webContents.loadURL(url[, options]).
     *
     * The url can be a remote address (e.g. http://) or a path to a local HTML file
     * using the file:// protocol.
     *
     * To ensure that file URLs are properly formatted, it is recommended to use
     * Node's url.format method:
     *
     *  |
     *  | let url = require('url').format({
     *  |   protocol: 'file',
     *  |   slashes: true,
     *  |   pathname: require('path').join(__dirname, 'index.html')
     *  | })
     *  |
     *  | win.loadURL(url)
     *  |
     *
     * You can load a URL using a POST request with URL-encoded data by doing the
     * following:
     *
     *  |
     *  | win.loadURL('http://localhost:8000/post', {
     *  |   postData: [{
     *  |     type: 'rawData',
     *  |     bytes: Buffer.from('hello=world')
     *  |   }],
     *  |   extraHeaders: 'Content-Type: application/x-www-form-urlencoded'
     *  | })
     *  |
     *
     * @param url
     * @param options
     */
    fun loadURL(url: String, options: (electron.BrowserWindow.LoadURLOptions.() -> Unit)? = null): Unit =
            instance.loadURL(url, options?.let { electron.BrowserWindow.LoadURLOptions().apply(it) })

    /**
     * Same as webContents.reload.
     */
    fun reload(): Unit =
            instance.reload()

    /**
     * Sets the menu as the window's menu bar, setting it to null will remove the
     * menu bar.
     *
     * @param menu
     */
    fun setMenu(menu: Menu): Unit =
            instance.setMenu(menu.instance)

    /**
     * Sets progress value in progress bar. Valid range is [0, 1.0].
     *
     * Remove progress bar when progress < 0; Change to indeterminate mode when
     * progress > 1.
     *
     * On Linux platform, only supports Unity desktop environment, you need to
     * specify the *.desktop file name to desktopName field in package.json. By
     * default, it will assume app.getName().desktop.
     *
     * On Windows, a mode can be passed. Accepted values are none, normal,
     * indeterminate, error, and paused. If you call setProgressBar without a mode
     * set (but with a value within the valid range), normal will be assumed.
     *
     * @param progress
     * @param options
     */
    fun setProgressBar(progress: Double, options: electron.BrowserWindow.SetProgressBarOptions? = null): Unit =
            instance.setProgressBar(progress, options)

    /**
     * Sets a 16 x 16 pixel overlay onto the current taskbar icon, usually used to
     * convey some sort of application status or to passively notify the user.
     *
     * @param overlay the icon to display on the bottom right corner of the taskbar icon. If this
     *                parameter is null, the overlay is cleared
     * @param description a description that will be provided to Accessibility screen readers
     */
    fun setOverlayIcon(overlay: NativeImage, description: String): Unit =
            instance.setOverlayIcon(overlay.instance, description)

    /**
     * Sets whether the window should have a shadow. On Windows and Linux does
     * nothing.
     *
     * @param hasShadow
     */
    fun setHasShadow(hasShadow: Boolean): Unit =
            instance.setHasShadow(hasShadow)

    /**
     * On Windows and Linux always returns true.
     *
     * @returns Whether the window has a shadow.
     */
    fun hasShadow(): Boolean =
            instance.hasShadow()

    /**
     * Add a thumbnail toolbar with a specified set of buttons to the thumbnail image
     * of a window in a taskbar button layout. Returns a Boolean object indicates
     * whether the thumbnail has been added successfully.
     *
     * The number of buttons in thumbnail toolbar should be no greater than 7 due to
     * the limited room. Once you setup the thumbnail toolbar, the toolbar cannot be
     * removed due to the platform's limitation. But you can call the API with an
     * empty array to clean the buttons.
     *
     * The buttons is an array of Button objects:
     *
     *  . Button Object
     *
     *     . iconNativeImage - The icon showing in thumbnail toolbar.
     *     . click Function
     *     . tooltip String (optional) - The text of the button's tooltip.
     *     . flags String[] (optional) - Control specific states and behaviors of the
     *       button. By default, it is ['enabled'].
     *
     * The flags is an array that can include following Strings:
     *
     *  . enabled - The button is active and available to the user.
     *  . disabled - The button is disabled. It is present, but has a visual state
     *    indicating it will not respond to user action.
     *  . dismissonclick - When the button is clicked, the thumbnail window closes
     *    immediately.
     *  . nobackground - Do not draw a button border, use only the image.
     *  . hidden - The button is not shown to the user.
     *  . noninteractive - The button is enabled but not interactive; no pressed button
     *    state is drawn. This value is intended for instances where the button is used
     *    in a notification.
     *
     *
     * @param buttons
     *
     * @returns Whether the buttons were added successfully
     */
    fun setThumbarButtons(buttons: Array<ThumbarButton>): Boolean =
            instance.setThumbarButtons(buttons.map { it.instance })

    /**
     * Sets the region of the window to show as the thumbnail image displayed when
     * hovering over the window in the taskbar. You can reset the thumbnail to be the
     * entire window by specifying an empty region: {x: 0, y: 0, width: 0, height: 0}.
     *
     * @param region Region of the window
     */
    fun setThumbnailClip(region: Rectangle): Unit =
            instance.setThumbnailClip(region.instance)

    /**
     * Sets the toolTip that is displayed when hovering over the window thumbnail in
     * the taskbar.
     *
     * @param toolTip
     */
    fun setThumbnailToolTip(toolTip: String): Unit =
            instance.setThumbnailToolTip(toolTip)

    /**
     * Sets the properties for the window's taskbar button.
     *
     * Note:relaunchCommand and relaunchDisplayName must always be set together. If
     * one of those properties is not set, then neither will be used.
     *
     * @param options
     */
    fun setAppDetails(options: electron.BrowserWindow.SetAppDetailsOptions.() -> Unit): Unit =
            instance.setAppDetails(options.let { electron.BrowserWindow.SetAppDetailsOptions().apply(it) })

    /**
     * Same as webContents.showDefinitionForSelection().
     */
    fun showDefinitionForSelection(): Unit =
            instance.showDefinitionForSelection()

    /**
     * Changes window icon.
     *
     * @param icon
     */
    fun setIcon(icon: NativeImage): Unit =
            instance.setIcon(icon.instance)

    /**
     * Sets whether the window menu bar should hide itself automatically. Once set
     * the menu bar will only show when users press the single Alt key.
     *
     * If the menu bar is already visible, calling setAutoHideMenuBar(true) won't
     * hide it immediately.
     *
     * @param hide
     */
    fun setAutoHideMenuBar(hide: Boolean): Unit =
            instance.setAutoHideMenuBar(hide)

    /**
     * @returns Whether menu bar automatically hides itself.
     */
    fun isMenuBarAutoHide(): Boolean =
            instance.isMenuBarAutoHide()

    /**
     * Sets whether the menu bar should be visible. If the menu bar is auto-hide,
     * users can still bring up the menu bar by pressing the single Alt key.
     *
     * @param visible
     */
    fun setMenuBarVisibility(visible: Boolean): Unit =
            instance.setMenuBarVisibility(visible)

    /**
     * @returns Whether the menu bar is visible.
     */
    fun isMenuBarVisible(): Boolean =
            instance.isMenuBarVisible()

    /**
     * Sets whether the window should be visible on all workspaces.
     *
     * Note: This API does nothing on Windows.
     *
     * @param visible
     */
    fun setVisibleOnAllWorkspaces(visible: Boolean): Unit =
            instance.setVisibleOnAllWorkspaces(visible)

    /**
     * Note: This API always returns false on Windows.
     *
     * @returns Whether the window is visible on all workspaces.
     */
    fun isVisibleOnAllWorkspaces(): Boolean =
            instance.isVisibleOnAllWorkspaces()

    /**
     * Makes the window ignore all mouse events.
     *
     * All mouse events happened in this window will be passed to the window below
     * this window, but if this window has focus, it will still receive keyboard
     * events.
     *
     * @param ignore
     */
    fun setIgnoreMouseEvents(ignore: Boolean): Unit =
            instance.setIgnoreMouseEvents(ignore)

    /**
     * Prevents the window contents from being captured by other apps.
     *
     * On macOS it sets the NSWindow's sharingType to NSWindowSharingNone. On Windows
     * it calls SetWindowDisplayAffinity with WDA_MONITOR.
     *
     * @param enable
     */
    fun setContentProtection(enable: Boolean): Unit =
            instance.setContentProtection(enable)

    /**
     * Changes whether the window can be focused.
     *
     * @param focusable
     */
    fun setFocusable(focusable: Boolean): Unit =
            instance.setFocusable(focusable)

    /**
     * Sets parent as current window's parent window, passing null will turn current
     * window into a top-level window.
     *
     * @param parent
     */
    fun setParentWindow(parent: electron.BrowserWindow): Unit =
            instance.setParentWindow(parent.instance)

    /**
     * @returns The parent window.
     */
    fun getParentWindow(): electron.BrowserWindow =
            instance.getParentWindow()

    /**
     * @returns All child windows.
     */
    fun getChildWindows(): Array<electron.BrowserWindow> =
            instance.getChildWindows()

    /**
     * Controls whether to hide cursor when typing.
     *
     * @param autoHide
     */
    fun setAutoHideCursor(autoHide: Boolean): Unit =
            instance.setAutoHideCursor(autoHide)

    /**
     * Adds a vibrancy effect to the browser window. Passing null or an empty string
     * will remove the vibrancy effect on the window.
     *
     * @param type Can be appearance-based, light, dark, titlebar, selection, menu, popover,
     *             sidebar, medium-light or ultra-dark. See the macOS documentation for more
     *             details.
     */
    fun setVibrancy(type: String): Unit =
            instance.setVibrancy(type)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').BrowserWindow")

        // ~ Methods -------------------------------------------------------------------------------

        /**
         * @returns An array of all opened browser windows.
         */
        fun getAllWindows(): Array<electron.BrowserWindow> =
                electron.BrowserWindow.Companion.module.getAllWindows()

        /**
         * @returns The window that is focused in this application, otherwise returns null.
         */
        fun getFocusedWindow(): electron.BrowserWindow =
                electron.BrowserWindow.Companion.module.getFocusedWindow()

        /**
         * @param webContents
         *
         * @returns The window that owns the given webContents.
         */
        fun fromWebContents(webContents: WebContents): electron.BrowserWindow =
                electron.BrowserWindow.Companion.module.fromWebContents(webContents.instance)

        /**
         * @param id
         *
         * @returns The window with the given id.
         */
        fun fromId(id: Int): electron.BrowserWindow =
                electron.BrowserWindow.Companion.module.fromId(id)

        /**
         * Adds DevTools extension located at path, and returns extension's name.
         *
         * The extension will be remembered so you only need to call this API once, this
         * API is not for programming use. If you try to add an extension that has
         * already been loaded, this method will not return and instead log a warning to
         * the console.
         *
         * The method will also not return if the extension's manifest is missing or
         * incomplete.
         *
         * Note: This API cannot be called before the ready event of the app module is
         * emitted.
         *
         * @param path
         */
        fun addDevToolsExtension(path: String): Unit =
                electron.BrowserWindow.Companion.module.addDevToolsExtension(path)

        /**
         * Remove a DevTools extension by name.
         *
         * Note: This API cannot be called before the ready event of the app module is
         * emitted.
         *
         * @param name
         */
        fun removeDevToolsExtension(name: String): Unit =
                electron.BrowserWindow.Companion.module.removeDevToolsExtension(name)

        /**
         * To check if a DevTools extension is installed you can run the following:
         *
         *  |
         *  | const {BrowserWindow} = require('electron')
         *  |
         *  | let installed = BrowserWindow.getDevToolsExtensions().hasOwnProperty('devtron')
         *  | console.log(installed)
         *  |
         *
         * Note: This API cannot be called before the ready event of the app module is
         * emitted.
         *
         * @returns The keys are the extension names and each value is an Object containing name
         *          and version properties.
         */
        fun getDevToolsExtensions(): dynamic =
                electron.BrowserWindow.Companion.module.getDevToolsExtensions()
    }

    // ~ Builders ------------------------------------------------------------------------------

    class Options(
            /**
             * Window's width in pixels. Default is 800.
             */
            var width: Int? = null,

            /**
             * Window's height in pixels. Default is 600.
             */
            var height: Int? = null,

            /**
             * Window's left offset from screen. Default is to center the window.
             */
            var x: Int? = null,

            /**
             * Window's top offset from screen. Default is to center the window.
             */
            var y: Int? = null,

            /**
             * The width and height would be used as web page's size, which means the actual
             * window's size will include window frame's size and be slightly larger. Default
             * is false.
             */
            var useContentSize: Boolean? = null,

            /**
             * Show window in the center of the screen.
             */
            var center: Boolean? = null,

            /**
             * Window's minimum width. Default is 0.
             */
            var minWidth: Int? = null,

            /**
             * Window's minimum height. Default is 0.
             */
            var minHeight: Int? = null,

            /**
             * Window's maximum width. Default is no limit.
             */
            var maxWidth: Int? = null,

            /**
             * Window's maximum height. Default is no limit.
             */
            var maxHeight: Int? = null,

            /**
             * Whether window is resizable. Default is true.
             */
            var resizable: Boolean? = null,

            /**
             * Whether window is movable. This is not implemented on Linux. Default is true.
             */
            var movable: Boolean? = null,

            /**
             * Whether window is minimizable. This is not implemented on Linux. Default is
             * true.
             */
            var minimizable: Boolean? = null,

            /**
             * Whether window is maximizable. This is not implemented on Linux. Default is
             * true.
             */
            var maximizable: Boolean? = null,

            /**
             * Whether window is closable. This is not implemented on Linux. Default is true.
             */
            var closable: Boolean? = null,

            /**
             * Whether the window can be focused. Default is true. On Windows setting
             * focusable: false also implies setting skipTaskbar: true. On Linux setting
             * focusable: false makes the window stop interacting with wm, so the window will
             * always stay on top in all workspaces.
             */
            var focusable: Boolean? = null,

            /**
             * Whether the window should always stay on top of other windows. Default is
             * false.
             */
            var alwaysOnTop: Boolean? = null,

            /**
             * Whether the window should show in fullscreen. When explicitly set to false the
             * fullscreen button will be hidden or disabled on macOS. Default is false.
             */
            var fullscreen: Boolean? = null,

            /**
             * Whether the window can be put into fullscreen mode. On macOS, also whether the
             * maximize/zoom button should toggle full screen mode or maximize window.
             * Default is true.
             */
            var fullscreenable: Boolean? = null,

            /**
             * Whether to show the window in taskbar. Default is false.
             */
            var skipTaskbar: Boolean? = null,

            /**
             * The kiosk mode. Default is false.
             */
            var kiosk: Boolean? = null,

            /**
             * Default window title. Default is "Electron".
             */
            var title: String? = null,

            /**
             * The window icon. On Windows it is recommended to use ICO icons to get best
             * visual effects, you can also leave it undefined so the executable's icon will
             * be used.
             */
            var icon: dynamic? = null,

            /**
             * Whether window should be shown when created. Default is true.
             */
            var show: Boolean? = null,

            /**
             * Specify false to create a Frameless Window. Default is true.
             */
            var frame: Boolean? = null,

            /**
             * Specify parent window. Default is null.
             */
            var parent: electron.BrowserWindow? = null,

            /**
             * Whether this is a modal window. This only works when the window is a child
             * window. Default is false.
             */
            var modal: Boolean? = null,

            /**
             * Whether the web view accepts a single mouse-down event that simultaneously
             * activates the window. Default is false.
             */
            var acceptFirstMouse: Boolean? = null,

            /**
             * Whether to hide cursor when typing. Default is false.
             */
            var disableAutoHideCursor: Boolean? = null,

            /**
             * Auto hide the menu bar unless the Alt key is pressed. Default is false.
             */
            var autoHideMenuBar: Boolean? = null,

            /**
             * Enable the window to be resized larger than screen. Default is false.
             */
            var enableLargerThanScreen: Boolean? = null,

            /**
             * Window's background color as Hexadecimal value, like #66CD00 or #FFF or
             * #80FFFFFF (alpha is supported). Default is #FFF (white).
             */
            var backgroundColor: String? = null,

            /**
             * Whether window should have a shadow. This is only implemented on macOS.
             * Default is true.
             */
            var hasShadow: Boolean? = null,

            /**
             * Forces using dark theme for the window, only works on some GTK+3 desktop
             * environments. Default is false.
             */
            var darkTheme: Boolean? = null,

            /**
             * Makes the window transparent. Default is false.
             */
            var transparent: Boolean? = null,

            /**
             * The type of window, default is normal window. See more about this below.
             */
            var type: String? = null,

            /**
             * The style of window title bar. Default is default. Possible values are:
             */
            var titleBarStyle: String? = null,

            /**
             * Use WS_THICKFRAME style for frameless windows on Windows, which adds standard
             * window frame. Setting it to false will remove window shadow and window
             * animations. Default is true.
             */
            var thickFrame: Boolean? = null,

            /**
             * Add a type of vibrancy effect to the window, only on macOS. Can be
             * appearance-based, light, dark, titlebar, selection, menu, popover, sidebar,
             * medium-light or ultra-dark.
             */
            var vibrancy: String? = null,

            /**
             * Controls the behavior on macOS when option-clicking the green stoplight button
             * on the toolbar or by clicking the Window > Zoom menu item. If true, the window
             * will grow to the preferred width of the web page when zoomed, false will cause
             * it to zoom to the width of the screen. This will also affect the behavior when
             * calling maximize() directly. Default is false.
             */
            var zoomToPageWidth: Boolean? = null,

            /**
             * Settings of web page's features.
             */
            var webPreferences: electron.BrowserWindow.WebPreferences? = null

    )

    class WebPreferences(
            /**
             * Whether to enable DevTools. If it is set to false, can not use
             * BrowserWindow.webContents.openDevTools() to open DevTools. Default is true.
             */
            var devTools: Boolean? = null,

            /**
             * Whether node integration is enabled. Default is true.
             */
            var nodeIntegration: Boolean? = null,

            /**
             * Specifies a script that will be loaded before other scripts run in the page.
             * This script will always have access to node APIs no matter whether node
             * integration is turned on or off. The value should be the absolute file path to
             * the script. When node integration is turned off, the preload script can
             * reintroduce Node global symbols back to the global scope. See example here.
             */
            var preload: String? = null,

            /**
             * Sets the session used by the page. Instead of passing the Session object
             * directly, you can also choose to use the partition option instead, which
             * accepts a partition string. When both session and partition are provided,
             * session will be preferred. Default is the default session.
             */
            var session: Session? = null,

            /**
             * Sets the session used by the page according to the session's partition string.
             * If partition starts with persist:, the page will use a persistent session
             * available to all pages in the app with the same partition. If there is no
             * persist: prefix, the page will use an in-memory session. By assigning the same
             * partition, multiple pages can share the same session. Default is the default
             * session.
             */
            var partition: String? = null,

            /**
             * The default zoom factor of the page, 3.0 represents 300%. Default is 1.0.
             */
            var zoomFactor: Number? = null,

            /**
             * Enables JavaScript support. Default is true.
             */
            var javascript: Boolean? = null,

            /**
             * When false, it will disable the same-origin policy (usually using testing
             * websites by people), and set allowRunningInsecureContent to true if this
             * options has not been set by user. Default is true.
             */
            var webSecurity: Boolean? = null,

            /**
             * Allow an https page to run JavaScript, CSS or plugins from http URLs. Default
             * is false.
             */
            var allowRunningInsecureContent: Boolean? = null,

            /**
             * Enables image support. Default is true.
             */
            var images: Boolean? = null,

            /**
             * Make TextArea elements resizable. Default is true.
             */
            var textAreasAreResizable: Boolean? = null,

            /**
             * Enables WebGL support. Default is true.
             */
            var webgl: Boolean? = null,

            /**
             * Enables WebAudio support. Default is true.
             */
            var webaudio: Boolean? = null,

            /**
             * Whether plugins should be enabled. Default is false.
             */
            var plugins: Boolean? = null,

            /**
             * Enables Chromium's experimental features. Default is false.
             */
            var experimentalFeatures: Boolean? = null,

            /**
             * Enables Chromium's experimental canvas features. Default is false.
             */
            var experimentalCanvasFeatures: Boolean? = null,

            /**
             * Enables scroll bounce (rubber banding) effect on macOS. Default is false.
             */
            var scrollBounce: Boolean? = null,

            /**
             * A list of feature strings separated by ,, like CSSVariables,KeyboardEventKey
             * to enable. The full list of supported feature strings can be found in the
             * RuntimeEnabledFeatures.in file.
             */
            var blinkFeatures: String? = null,

            /**
             * A list of feature strings separated by ,, like CSSVariables,KeyboardEventKey
             * to disable. The full list of supported feature strings can be found in the
             * RuntimeEnabledFeatures.in file.
             */
            var disableBlinkFeatures: String? = null,

            /**
             * Sets the default font for the font-family.
             */
            var defaultFontFamily: electron.BrowserWindow.DefaultFontFamily? = null,

            /**
             * Defaults to 16.
             */
            var defaultFontSize: Int? = null,

            /**
             * Defaults to 13.
             */
            var defaultMonospaceFontSize: Int? = null,

            /**
             * Defaults to 0.
             */
            var minimumFontSize: Int? = null,

            /**
             * Defaults to ISO-8859-1.
             */
            var defaultEncoding: String? = null,

            /**
             * Whether to throttle animations and timers when the page becomes background.
             * Defaults to true.
             */
            var backgroundThrottling: Boolean? = null,

            /**
             * Whether to enable offscreen rendering for the browser window. Defaults to
             * false. See the offscreen rendering tutorial for more details.
             */
            var offscreen: Boolean? = null,

            /**
             * Whether to enable Chromium OS-level sandbox.
             */
            var sandbox: Boolean? = null,

            /**
             * Whether to run Electron APIs and the specified preload script in a separate
             * JavaScript context. Defaults to false. The context that the preload script
             * runs in will still have full access to the document and window globals but it
             * will use its own set of JavaScript builtins (Array, Object, JSON, etc.) and
             * will be isolated from any changes made to the global environment by the loaded
             * page. The Electron API will only be available in the preload script and not
             * the loaded page. This option should be used when loading potentially untrusted
             * remote content to ensure the loaded content cannot tamper with the preload
             * script and any Electron APIs being used. This option uses the same technique
             * used by Chrome Content Scripts. You can access this context in the dev tools
             * by selecting the 'Electron Isolated Context' entry in the combo box at the top
             * of the Console tab. Note: This option is currently experimental and may change
             * or be removed in future Electron releases.
             */
            var contextIsolation: Boolean? = null

    )

    class DefaultFontFamily(
            /**
             * Defaults to Times New Roman.
             */
            var standard: String? = null,

            /**
             * Defaults to Times New Roman.
             */
            var serif: String? = null,

            /**
             * Defaults to Arial.
             */
            var sansSerif: String? = null,

            /**
             * Defaults to Courier New.
             */
            var monospace: String? = null,

            /**
             * Defaults to Script.
             */
            var cursive: String? = null,

            /**
             * Defaults to Impact.
             */
            var fantasy: String? = null

    )


    class SetAspectRatioExtraSize(
            /**
             *
             */
            var width: Int,

            /**
             *
             */
            var height: Int

    )

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

    class SetProgressBarOptions(
            /**
             * Mode for the progress bar. Can be none, normal, indeterminate, error, or
             * paused.
             */
            var mode: String

    )

    class SetAppDetailsOptions(
            /**
             * Window's App User Model ID. It has to be set, otherwise the other options will
             * have no effect.
             */
            var appId: String? = null,

            /**
             * Window's Relaunch Icon.
             */
            var appIconPath: String? = null,

            /**
             * Index of the icon in appIconPath. Ignored when appIconPath is not set. Default
             * is 0.
             */
            var appIconIndex: Int? = null,

            /**
             * Window's Relaunch Command.
             */
            var relaunchCommand: String? = null,

            /**
             * Window's Relaunch Display Name.
             */
            var relaunchDisplayName: String? = null

    )
}

