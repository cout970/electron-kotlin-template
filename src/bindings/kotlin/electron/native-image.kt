@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object nativeImage {

    private val module: dynamic = js("require('electron').nativeImage")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.nativeImage.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Creates an empty NativeImage instance.
     *
     * @returns
     */
    fun createEmpty(): electron.NativeImage =
            electron.nativeImage.module.createEmpty()

    /**
     * Creates a new NativeImage instance from a file located at path. This method
     * returns an empty image if the path does not exist, cannot be read, or is not a
     * valid image.
     *
     *  |
     *  | const nativeImage = require('electron').nativeImage
     *  |
     *  | let image = nativeImage.createFromPath('/Users/somebody/images/icon.png')
     *  | console.log(image)
     *  |
     *
     * @param path
     *
     * @returns
     */
    fun createFromPath(path: String): electron.NativeImage =
            electron.nativeImage.module.createFromPath(path)

    /**
     * Creates a new NativeImage instance from buffer.
     *
     * @param buffer
     * @param options
     *
     * @returns
     */
    fun createFromBuffer(buffer: dynamic,
                         options: (electron.nativeImage.CreateFromBufferOptions.() -> Unit)? = null): electron.NativeImage =
            electron.nativeImage.module.createFromBuffer(buffer,
                    options?.let { electron.nativeImage.CreateFromBufferOptions().apply(it) })

    /**
     * Creates a new NativeImage instance from dataURL.
     *
     * @param dataURL
     */
    fun createFromDataURL(dataURL: String): Unit =
            electron.nativeImage.module.createFromDataURL(dataURL)

    // ~ Builders ------------------------------------------------------------------------------

    class CreateFromBufferOptions(
            /**
             * Required for bitmap buffers.
             */
            var width: Int? = null,

            /**
             * Required for bitmap buffers.
             */
            var height: Int? = null,

            /**
             * Defaults to 1.0.
             */
            var scaleFactor: Double? = null

    )
}

@Suppress("REDUNDANT_NULLABLE")
class NativeImage constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').NativeImage")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.NativeImage.Companion.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * @returns A Buffer that contains the image's PNG encoded data.
     */
    fun toPNG(): dynamic =
            instance.toPNG()

    /**
     * @param quality Between 0 - 100.
     *
     * @returns A Buffer that contains the image's JPEG encoded data.
     */
    fun toJPEG(quality: Int): dynamic =
            instance.toJPEG(quality)

    /**
     * @returns A Buffer that contains a copy of the image's raw bitmap pixel data.
     */
    fun toBitmap(): dynamic =
            instance.toBitmap()

    /**
     * @returns The data URL of the image.
     */
    fun toDataURL(): String =
            instance.toDataURL()

    /**
     * The difference between getBitmap() and toBitmap() is, getBitmap() does not
     * copy the bitmap data, so you have to use the returned Buffer immediately in
     * current event loop tick, otherwise the data might be changed or destroyed.
     *
     * @returns A Buffer that contains the image's raw bitmap pixel data.
     */
    fun getBitmap(): dynamic =
            instance.getBitmap()

    /**
     * Notice that the returned pointer is a weak pointer to the underlying native
     * image instead of a copy, so you must ensure that the associated nativeImage
     * instance is kept around.
     *
     * @returns A Buffer that stores C pointer to underlying native handle of the image. On
     *          macOS, a pointer to NSImage instance would be returned.
     */
    fun getNativeHandle(): dynamic =
            instance.getNativeHandle()

    /**
     * @returns Whether the image is empty.
     */
    fun isEmpty(): Boolean =
            instance.isEmpty()

    /**
     *  . width Integer
     *  . height Integer
     *
     *
     * @param width
     * @param height
     *
     * @returns
     */
    fun getSize(width: Int, height: Int): dynamic =
            instance.getSize(width, height)

    /**
     * Marks the image as a template image.
     *
     * @param option
     */
    fun setTemplateImage(option: Boolean): Unit =
            instance.setTemplateImage(option)

    /**
     * @returns Whether the image is a template image.
     */
    fun isTemplateImage(): Boolean =
            instance.isTemplateImage()

    /**
     * @param rect The area of the image to crop
     *
     * @returns The cropped image.
     */
    fun crop(rect: electron.NativeImage.CropRect): electron.NativeImage =
            instance.crop(rect)

    /**
     * If only the height or the width are specified then the current aspect ratio
     * will be preserved in the resized image.
     *
     * @param options
     *
     * @returns The resized image.
     */
    fun resize(options: electron.NativeImage.ResizeOptions.() -> Unit): electron.NativeImage =
            instance.resize(options.let { electron.NativeImage.ResizeOptions().apply(it) })

    /**
     * @returns The image's aspect ratio.
     */
    fun getAspectRatio(): Float =
            instance.getAspectRatio()

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').NativeImage")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class CropRect(
            /**
             *
             */
            var x: Int,

            /**
             *
             */
            var y: Int,

            /**
             *
             */
            var width: Int,

            /**
             *
             */
            var height: Int

    )

    class ResizeOptions(
            /**
             *
             */
            var width: Int? = null,

            /**
             *
             */
            var height: Int? = null,

            /**
             * The desired quality of the resize image. Possible values are good, better or
             * best. The default is best. These values express a desired quality/speed
             * tradeoff. They are translated into an algorithm-specific method that depends
             * on the capabilities (CPU, GPU) of the underlying platform. It is possible for
             * all three methods to be mapped to the same algorithm on a given platform.
             */
            var quality: String? = null

    )
}

