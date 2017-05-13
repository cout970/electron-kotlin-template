@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class RemovePassword(
        /**
         * password.
         */
        var type: String,

        /**
         * When provided, the authentication info related to the origin will only be
         * removed otherwise the entire cache will be cleared.
         */
        var origin: String? = null,

        /**
         * Scheme of the authentication. Can be basic, digest, ntlm, negotiate. Must be
         * provided if removing by origin.
         */
        var scheme: String? = null,

        /**
         * Realm of the authentication. Must be provided if removing by origin.
         */
        var realm: String? = null,

        /**
         * Credentials of the authentication. Must be provided if removing by origin.
         */
        var username: String? = null,

        /**
         * Credentials of the authentication. Must be provided if removing by origin.
         */
        var password: String? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

