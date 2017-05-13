@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class Cookies constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').Cookies")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.Cookies.Companion.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Sends a request to get all cookies matching details, callback will be called
     * with callback(error, cookies) on complete.
     *
     * cookies is an Array of cookie objects.
     *
     * @param filter
     * @param callback
     */
    fun get(filter: electron.Cookies.GetFilter.() -> Unit,
            callback: (error: Error, cookies: Array<electron.Cookies>) -> Unit): Unit =
            instance.get(filter.let { electron.Cookies.GetFilter().apply(it) }, callback)

    /**
     * Sets a cookie with details, callback will be called with callback(error) on
     * complete.
     *
     * @param details
     * @param callback
     */
    fun set(details: electron.Cookies.SetDetails, callback: (error: Error) -> Unit): Unit =
            instance.set(details, callback)

    /**
     * Removes the cookies matching url and name, callback will called with
     * callback() on complete.
     *
     * @param url The URL associated with the cookie.
     * @param name The name of cookie to remove.
     * @param callback
     */
    fun remove(url: String, name: String, callback: (dynamic) -> Unit): Unit =
            instance.remove(url, name, callback)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').Cookies")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class GetFilter(
            /**
             * Retrieves cookies which are associated with url. Empty implies retrieving
             * cookies of all urls.
             */
            var url: String? = null,

            /**
             * Filters cookies by name.
             */
            var name: String? = null,

            /**
             * Retrieves cookies whose domains match or are subdomains of domains
             */
            var domain: String? = null,

            /**
             * Retrieves cookies whose path matches path.
             */
            var path: String? = null,

            /**
             * Filters cookies by their Secure property.
             */
            var secure: Boolean? = null,

            /**
             * Filters out session or persistent cookies.
             */
            var session: Boolean? = null

    )

    class SetDetails(
            /**
             * The url to associate the cookie with.
             */
            var url: String,

            /**
             * The name of the cookie. Empty by default if omitted.
             */
            var name: String? = null,

            /**
             * The value of the cookie. Empty by default if omitted.
             */
            var value: String? = null,

            /**
             * The domain of the cookie. Empty by default if omitted.
             */
            var domain: String? = null,

            /**
             * The path of the cookie. Empty by default if omitted.
             */
            var path: String? = null,

            /**
             * Whether the cookie should be marked as Secure. Defaults to false.
             */
            var secure: Boolean? = null,

            /**
             * Whether the cookie should be marked as HTTP only. Defaults to false.
             */
            var httpOnly: Boolean? = null,

            /**
             * The expiration date of the cookie as the number of seconds since the UNIX
             * epoch. If omitted then the cookie becomes a session cookie and will not be
             * retained between sessions.
             */
            var expirationDate: Double? = null

    )
}

