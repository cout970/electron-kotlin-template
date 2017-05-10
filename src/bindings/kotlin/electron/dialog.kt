@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object dialog {

    private val module: dynamic = js("require('electron').dialog")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.dialog.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * The browserWindow argument allows the dialog to attach itself to a parent
     * window, making it modal.
     *
     * The filters specifies an array of file types that can be displayed or selected
     * when you want to limit the user to a specific type. For example:
     *
     *  |
     *  | {
     *  |   filters: [
     *  |     {name: 'Images', extensions: ['jpg', 'png', 'gif']},
     *  |     {name: 'Movies', extensions: ['mkv', 'avi', 'mp4']},
     *  |     {name: 'Custom File Type', extensions: ['as']},
     *  |     {name: 'All Files', extensions: ['*']}
     *  |   ]
     *  | }
     *  |
     *
     * The extensions array should contain extensions without wildcards or dots (e.g.
     * 'png' is good but '.png' and '*.png' are bad). To show all files, use the '*'
     * wildcard (no other wildcard is supported).
     *
     * If a callback is passed, the API call will be asynchronous and the result will
     * be passed via callback(filenames)
     *
     * Note: On Windows and Linux an open dialog can not be both a file selector and
     * a directory selector, so if you set properties to ['openFile',
     * 'openDirectory'] on these platforms, a directory selector will be shown.
     *
     * @param browserWindow
     * @param options
     * @param callback
     *
     * @returns
     */
    fun showOpenDialog(browserWindow: electron.BrowserWindow? = null,
                       options: electron.dialog.ShowOpenDialogOptions.() -> Unit,
                       callback: ((filePaths: Array<String>) -> Unit)? = null): Array<String> =
            electron.dialog.module.showOpenDialog(browserWindow?.instance,
                    options.let { electron.dialog.ShowOpenDialogOptions().apply(it) }, callback)

    /**
     * The browserWindow argument allows the dialog to attach itself to a parent
     * window, making it modal.
     *
     * The filters specifies an array of file types that can be displayed, see
     * dialog.showOpenDialog for an example.
     *
     * If a callback is passed, the API call will be asynchronous and the result will
     * be passed via callback(filename)
     *
     * @param browserWindow
     * @param options
     * @param callback
     *
     * @returns
     */
    fun showSaveDialog(browserWindow: electron.BrowserWindow? = null,
                       options: electron.dialog.ShowSaveDialogOptions.() -> Unit,
                       callback: ((filename: String) -> Unit)? = null): String =
            electron.dialog.module.showSaveDialog(browserWindow?.instance,
                    options.let { electron.dialog.ShowSaveDialogOptions().apply(it) }, callback)

    /**
     * Shows a message box, it will block the process until the message box is
     * closed. It returns the index of the clicked button.
     *
     * The browserWindow argument allows the dialog to attach itself to a parent
     * window, making it modal.
     *
     * If a callback is passed, the API call will be asynchronous and the result will
     * be passed via callback(response).
     *
     * @param browserWindow
     * @param options
     * @param callback
     *
     * @returns
     */
    fun showMessageBox(browserWindow: electron.BrowserWindow? = null, options: electron.dialog.ShowMessageBoxOptions,
                       callback: ((response: Number, checkboxChecked: Boolean) -> Unit)? = null): Int =
            electron.dialog.module.showMessageBox(browserWindow?.instance, options, callback)

    /**
     * Displays a modal dialog that shows an error message.
     *
     * This API can be called safely before the ready event the app module emits, it
     * is usually used to report errors in early stage of startup. If called before
     * the app readyevent on Linux, the message will be emitted to stderr, and no GUI
     * dialog will appear.
     *
     * @param title The title to display in the error box
     * @param content The text content to display in the error box
     */
    fun showErrorBox(title: String, content: String): Unit =
            electron.dialog.module.showErrorBox(title, content)

    // ~ Builders ------------------------------------------------------------------------------

    class ShowOpenDialogOptions(
            /**
             *
             */
            var title: String? = null,

            /**
             *
             */
            var defaultPath: String? = null,

            /**
             * Custom label for the confirmation button, when left empty the default label
             * will be used.
             */
            var buttonLabel: String? = null,

            /**
             *
             */
            var filters: Array<FileFilter>? = null,

            /**
             * Contains which features the dialog should use. The following values are
             * supported:
             */
            var properties: Array<String>? = null,

            /**
             * Normalize the keyboard access keys across platforms. Default is false.
             * Enabling this assumes & is used in the button labels for the placement of the
             * keyboard shortcut access key and labels will be converted so they work
             * correctly on each platform, & characters are removed on macOS, converted to _
             * on Linux, and left untouched on Windows. For example, a button label of Vie&w
             * will be converted to Vie_w on Linux and View on macOS and can be selected via
             * Alt-W on Windows and Linux.
             */
            var normalizeAccessKeys: Boolean? = null

    )

    class ShowSaveDialogOptions(
            /**
             *
             */
            var title: String? = null,

            /**
             *
             */
            var defaultPath: String? = null,

            /**
             * Custom label for the confirmation button, when left empty the default label
             * will be used.
             */
            var buttonLabel: String? = null,

            /**
             *
             */
            var filters: Array<FileFilter>? = null,

            /**
             * Message to display above text fields.
             */
            var message: String? = null,

            /**
             * Custom label for the text displayed in front of the filename text field.
             */
            var nameFieldLabel: String? = null,

            /**
             * Show the tags input box, defaults to true.
             */
            var showsTagField: Boolean? = null

    )

    class ShowMessageBoxOptions(
            /**
             * Can be "none", "info", "error", "question" or "warning". On Windows,
             * "question" displays the same icon as "info", unless you set an icon using the
             * "icon" option.
             */
            var type: String? = null,

            /**
             * Array of texts for buttons. On Windows, an empty array will result in one
             * button labeled "OK".
             */
            var buttons: Array<String>? = null,

            /**
             * Index of the button in the buttons array which will be selected by default
             * when the message box opens.
             */
            var defaultId: Int? = null,

            /**
             * Title of the message box, some platforms will not show it.
             */
            var title: String? = null,

            /**
             * Content of the message box.
             */
            var message: String,

            /**
             * Extra information of the message.
             */
            var detail: String? = null,

            /**
             * If provided, the message box will include a checkbox with the given label. The
             * checkbox state can be inspected only when using callback.
             */
            var checkboxLabel: String? = null,

            /**
             * Initial checked state of the checkbox. false by default.
             */
            var checkboxChecked: Boolean? = null,

            /**
             *
             */
            var icon: NativeImage? = null,

            /**
             * The value will be returned when user cancels the dialog instead of clicking
             * the buttons of the dialog. By default it is the index of the buttons that have
             * "cancel" or "no" as label, or 0 if there is no such buttons. On macOS and
             * Windows the index of the "Cancel" button will always be used as cancelId even
             * if it is specified.
             */
            var cancelId: Int? = null,

            /**
             * On Windows Electron will try to figure out which one of the buttons are common
             * buttons (like "Cancel" or "Yes"), and show the others as command links in the
             * dialog. This can make the dialog appear in the style of modern Windows apps.
             * If you don't like this behavior, you can set noLink to true.
             */
            var noLink: Boolean? = null

    )
}

