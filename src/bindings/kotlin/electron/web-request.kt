@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class WebRequest constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').WebRequest")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.WebRequest.Companion.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * The listener will be called with listener(details, callback) when a request is
     * about to occur.
     *
     * The uploadData is an array of UploadData objects.
     *
     * The callback has to be called with an response object.
     *
     * @param filter
     * @param listener
     */
    fun onBeforeRequest(filter: electron.WebRequest.OnBeforeRequestFilter.() -> Unit,
                        listener: (details: electron.WebRequest.OnBeforeRequestDetails, callback: (response: electron.WebRequest.OnBeforeRequestResponse.() -> Unit) -> Unit) -> Unit): Unit =
            instance.onBeforeRequest(filter.let { electron.WebRequest.OnBeforeRequestFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details, callback) before sending an
     * HTTP request, once the request headers are available. This may occur after a
     * TCP connection is made to the server, but before any http data is sent.
     *
     *  . details Object
     *     . id Integer
     *     . url String
     *     . method String
     *     . resourceType String
     *     . timestamp Double
     *     . requestHeaders Object
     *
     *  . callback Function
     *
     *     . response Object
     *
     *        . cancel Boolean (optional)
     *        . requestHeaders Object (optional) - When provided, request will be made with
     *          these headers.
     *
     * The callback has to be called with an response object.
     *
     * @param filter
     * @param listener
     */
    fun onBeforeSendHeaders(filter: electron.WebRequest.OnBeforeSendHeadersFilter.() -> Unit,
                            listener: (dynamic) -> Unit): Unit =
            instance.onBeforeSendHeaders(filter.let { electron.WebRequest.OnBeforeSendHeadersFilter().apply(it) },
                    listener)

    /**
     * The listener will be called with listener(details) just before a request is
     * going to be sent to the server, modifications of previous onBeforeSendHeaders
     * response are visible by the time this listener is fired.
     *
     * @param filter
     * @param listener
     */
    fun onSendHeaders(filter: electron.WebRequest.OnSendHeadersFilter.() -> Unit,
                      listener: (details: electron.WebRequest.OnSendHeadersDetails) -> Unit): Unit =
            instance.onSendHeaders(filter.let { electron.WebRequest.OnSendHeadersFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details, callback) when HTTP
     * response headers of a request have been received.
     *
     *  . details Object
     *     . id String
     *     . url String
     *     . method String
     *     . resourceType String
     *     . timestamp Double
     *     . statusLine String
     *     . statusCode Integer
     *     . responseHeaders Object
     *
     *  . callback Function
     *
     *     . response Object
     *
     *        . cancel Boolean
     *        . responseHeaders Object (optional) - When provided, the server is assumed to
     *          have responded with these headers.
     *        . statusLine String (optional) - Should be provided when overriding
     *          responseHeaders to change header status otherwise original response header's
     *          status will be used.
     *
     * The callback has to be called with an response object.
     *
     * @param filter
     * @param listener
     */
    fun onHeadersReceived(filter: electron.WebRequest.OnHeadersReceivedFilter.() -> Unit,
                          listener: (dynamic) -> Unit): Unit =
            instance.onHeadersReceived(filter.let { electron.WebRequest.OnHeadersReceivedFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details) when first byte of the
     * response body is received. For HTTP requests, this means that the status line
     * and response headers are available.
     *
     * @param filter
     * @param listener
     */
    fun onResponseStarted(filter: electron.WebRequest.OnResponseStartedFilter.() -> Unit,
                          listener: (details: electron.WebRequest.OnResponseStartedDetails) -> Unit): Unit =
            instance.onResponseStarted(filter.let { electron.WebRequest.OnResponseStartedFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details) when a server initiated
     * redirect is about to occur.
     *
     * @param filter
     * @param listener
     */
    fun onBeforeRedirect(filter: electron.WebRequest.OnBeforeRedirectFilter.() -> Unit,
                         listener: (details: electron.WebRequest.OnBeforeRedirectDetails) -> Unit): Unit =
            instance.onBeforeRedirect(filter.let { electron.WebRequest.OnBeforeRedirectFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details) when a request is completed.
     *
     * @param filter
     * @param listener
     */
    fun onCompleted(filter: electron.WebRequest.OnCompletedFilter.() -> Unit,
                    listener: (details: electron.WebRequest.OnCompletedDetails) -> Unit): Unit =
            instance.onCompleted(filter.let { electron.WebRequest.OnCompletedFilter().apply(it) }, listener)

    /**
     * The listener will be called with listener(details) when an error occurs.
     *
     * @param filter
     * @param listener
     */
    fun onErrorOccurred(filter: electron.WebRequest.OnErrorOccurredFilter.() -> Unit,
                        listener: (details: electron.WebRequest.OnErrorOccurredDetails) -> Unit): Unit =
            instance.onErrorOccurred(filter.let { electron.WebRequest.OnErrorOccurredFilter().apply(it) }, listener)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').WebRequest")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class OnBeforeRequestFilter

    class OnBeforeRequestDetails(
            /**
             *
             */
            var id: Int,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var uploadData: Array<UploadData>

    )

    class OnBeforeRequestResponse(
            /**
             *
             */
            var cancel: Boolean? = null,

            /**
             * The original request is prevented from being sent or completed and is instead
             * redirected to the given URL.
             */
            var redirectURL: String? = null

    )

    class OnBeforeSendHeadersFilter

    class OnSendHeadersFilter

    class OnSendHeadersDetails(
            /**
             *
             */
            var id: Int,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var requestHeaders: electron.WebRequest.OnSendHeadersRequestHeaders

    )

    class OnSendHeadersRequestHeaders


    class OnHeadersReceivedFilter

    class OnResponseStartedFilter

    class OnResponseStartedDetails(
            /**
             *
             */
            var id: Int,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var responseHeaders: electron.WebRequest.OnResponseStartedResponseHeaders,

            /**
             * Indicates whether the response was fetched from disk cache.
             */
            var fromCache: Boolean,

            /**
             *
             */
            var statusCode: Int,

            /**
             *
             */
            var statusLine: String

    )

    class OnResponseStartedResponseHeaders


    class OnBeforeRedirectFilter

    class OnBeforeRedirectDetails(
            /**
             *
             */
            var id: String,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var redirectURL: String,

            /**
             *
             */
            var statusCode: Int,

            /**
             * The server IP address that the request was actually sent to.
             */
            var ip: String? = null,

            /**
             *
             */
            var fromCache: Boolean,

            /**
             *
             */
            var responseHeaders: electron.WebRequest.OnBeforeRedirectResponseHeaders

    )

    class OnBeforeRedirectResponseHeaders


    class OnCompletedFilter

    class OnCompletedDetails(
            /**
             *
             */
            var id: Int,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var responseHeaders: electron.WebRequest.OnCompletedResponseHeaders,

            /**
             *
             */
            var fromCache: Boolean,

            /**
             *
             */
            var statusCode: Int,

            /**
             *
             */
            var statusLine: String

    )

    class OnCompletedResponseHeaders


    class OnErrorOccurredFilter

    class OnErrorOccurredDetails(
            /**
             *
             */
            var id: Int,

            /**
             *
             */
            var url: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var resourceType: String,

            /**
             *
             */
            var timestamp: Double,

            /**
             *
             */
            var fromCache: Boolean,

            /**
             * The error description.
             */
            var error: String

    )
}

