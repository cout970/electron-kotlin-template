@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class RemoveClientCertificate(
        /**
         * clientCertificate.
         */
        var type: String,

        /**
         * Origin of the server whose associated client certificate must be removed from
         * the cache.
         */
        var origin: String

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

