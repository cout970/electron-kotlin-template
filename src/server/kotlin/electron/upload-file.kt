@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class UploadFile(
        /**
         * file.
         */
        var type: String,

        /**
         * Path of file to be uploaded.
         */
        var filePath: String,

        /**
         * Defaults to 0.
         */
        var offset: Int,

        /**
         * Number of bytes to read from offset. Defaults to 0.
         */
        var length: Int,

        /**
         * Last Modification time in number of seconds sine the UNIX epoch.
         */
        var modificationTime: Double

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

