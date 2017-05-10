@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class Cookie(
        /**
         * The name of the cookie.
         */
        var name: String,

        /**
         * The value of the cookie.
         */
        var value: String,

        /**
         * The domain of the cookie.
         */
        var domain: String? = null,

        /**
         * Whether the cookie is a host-only cookie.
         */
        var hostOnly: Boolean? = null,

        /**
         * The path of the cookie.
         */
        var path: String? = null,

        /**
         * Whether the cookie is marked as secure.
         */
        var secure: Boolean? = null,

        /**
         * Whether the cookie is marked as HTTP only.
         */
        var httpOnly: Boolean? = null,

        /**
         * Whether the cookie is a session cookie or a persistent cookie with an
         * expiration date.
         */
        var session: Boolean? = null,

        /**
         * The expiration date of the cookie as the number of seconds since the UNIX
         * epoch. Not provided for session cookies.
         */
        var expirationDate: Double? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

