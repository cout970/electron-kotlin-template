@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class UploadData(
        /**
         * Content being sent.
         */
        var bytes: dynamic,

        /**
         * Path of file being uploaded.
         */
        var file: String,

        /**
         * UUID of blob data. Use ses.getBlobData method to retrieve the data.
         */
        var blobUUID: String

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

