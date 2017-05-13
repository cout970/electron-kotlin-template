@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class CertificatePrincipal(
        /**
         * Common Name
         */
        var commonName: String,

        /**
         * Organization names
         */
        var organizations: Array<String>,

        /**
         * Organization Unit names
         */
        var organizationUnits: Array<String>,

        /**
         * Locality
         */
        var locality: String,

        /**
         * State or province
         */
        var state: String,

        /**
         * Country or region
         */
        var country: String

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

