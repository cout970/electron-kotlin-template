@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class UploadBlob(
        /**
         * blob.
         */
        var type: String,

        /**
         * UUID of blob data to upload.
         */
        var blobUUID: String

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

