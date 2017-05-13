@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object clipboard {

    private val module: dynamic = js("require('electron').clipboard")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.clipboard.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * @param type
     *
     * @returns The content in the clipboard as plain text.
     */
    fun readText(type: String? = null): String =
            electron.clipboard.module.readText(type)

    /**
     * Writes the text into the clipboard as plain text.
     *
     * @param text
     * @param type
     */
    fun writeText(text: String, type: String? = null): Unit =
            electron.clipboard.module.writeText(text, type)

    /**
     * @param type
     *
     * @returns The content in the clipboard as markup.
     */
    fun readHTML(type: String? = null): String =
            electron.clipboard.module.readHTML(type)

    /**
     * Writes markup to the clipboard.
     *
     * @param markup
     * @param type
     */
    fun writeHTML(markup: String, type: String? = null): Unit =
            electron.clipboard.module.writeHTML(markup, type)

    /**
     * @param type
     *
     * @returns The image content in the clipboard.
     */
    fun readImage(type: String? = null): electron.NativeImage =
            electron.clipboard.module.readImage(type)

    /**
     * Writes image to the clipboard.
     *
     * @param image
     * @param type
     */
    fun writeImage(image: electron.NativeImage, type: String? = null): Unit =
            electron.clipboard.module.writeImage(image.instance, type)

    /**
     * @param type
     *
     * @returns The content in the clipboard as RTF.
     */
    fun readRTF(type: String? = null): String =
            electron.clipboard.module.readRTF(type)

    /**
     * Writes the text into the clipboard in RTF.
     *
     * @param text
     * @param type
     */
    fun writeRTF(text: String, type: String? = null): Unit =
            electron.clipboard.module.writeRTF(text, type)

    /**
     *  . title String
     *  . url String
     *
     *
     * @param title
     * @param url
     *
     * @returns
     */
    fun readBookmark(title: String, url: String): dynamic =
            electron.clipboard.module.readBookmark(title, url)

    /**
     * Writes the title and url into the clipboard as a bookmark.
     *
     * Note: Most apps on Windows don't support pasting bookmarks into them so you
     * can use clipboard.write to write both a bookmark and fallback text to the
     * clipboard.
     *
     *  |
     *  | clipboard.write({
     *  |   text: 'http://electron.atom.io',
     *  |   bookmark: 'Electron Homepage'
     *  | })
     *  |
     *
     * @param title
     * @param url
     * @param type
     */
    fun writeBookmark(title: String, url: String, type: String? = null): Unit =
            electron.clipboard.module.writeBookmark(title, url, type)

    /**
     * @returns The text on the find pasteboard. This method uses synchronous IPC when called
     *          from the renderer process. The cached value is reread from the find pasteboard
     *          whenever the application is activated.
     */
    fun readFindText(): String =
            electron.clipboard.module.readFindText()

    /**
     * Writes the text into the find pasteboard as plain text. This method uses
     * synchronous IPC when called from the renderer process.
     *
     * @param text
     */
    fun writeFindText(text: String): Unit =
            electron.clipboard.module.writeFindText(text)

    /**
     * Clears the clipboard content.
     *
     * @param type
     */
    fun clear(type: String? = null): Unit =
            electron.clipboard.module.clear(type)

    /**
     * @param type
     *
     * @returns An array of supported formats for the clipboard type.
     */
    fun availableFormats(type: String? = null): Array<String> =
            electron.clipboard.module.availableFormats(type)

    /**
     *  |
     *  | const {clipboard} = require('electron')
     *  | console.log(clipboard.has('<p>selection</p>'))
     *  |
     *
     * @param data
     * @param type
     *
     * @returns Whether the clipboard supports the format of specified data.
     */
    fun has(data: String, type: String? = null): Boolean =
            electron.clipboard.module.has(data, type)

    /**
     * @param data
     * @param type
     *
     * @returns Reads data from the clipboard.
     */
    fun read(data: String, type: String? = null): String =
            electron.clipboard.module.read(data, type)

    /**
     *  |
     *  | const {clipboard} = require('electron')
     *  | clipboard.write({text: 'test', html: '<b>test</b>'})
     *  |
     *
     * Writes data to the clipboard.
     *
     * @param data
     * @param type
     */
    fun write(data: electron.clipboard.WriteData.() -> Unit, type: String? = null): Unit =
            electron.clipboard.module.write(data.let { electron.clipboard.WriteData().apply(it) }, type)

    // ~ Builders ------------------------------------------------------------------------------

    class WriteData(
            /**
             *
             */
            var text: String? = null,

            /**
             *
             */
            var html: String? = null,

            /**
             *
             */
            var image: electron.NativeImage? = null,

            /**
             *
             */
            var rtf: String? = null,

            /**
             * The title of the url at text.
             */
            var bookmark: String? = null

    )
}

