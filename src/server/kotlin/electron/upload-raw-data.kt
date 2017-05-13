@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class UploadRawData(
        /**
         * rawData.
         */
        var type: String,

        /**
         * Data to be uploaded.
         */
        var bytes: dynamic

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

