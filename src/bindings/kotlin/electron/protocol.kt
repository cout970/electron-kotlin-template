@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object protocol {

    private val module: dynamic = js("require('electron').protocol")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.protocol.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * A standard scheme adheres to what RFC 3986 calls generic URI syntax. For
     * example http and https are standard schemes, while file is not.
     *
     * Registering a scheme as standard, will allow relative and absolute resources
     * to be resolved correctly when served. Otherwise the scheme will behave like
     * the file protocol, but without the ability to resolve relative URLs.
     *
     * For example when you load following page with custom protocol without
     * registering it as standard scheme, the image will not be loaded because
     * non-standard schemes can not recognize relative URLs:
     *
     *  |
     *  | <body>
     *  |   <img src='test.png'>
     *  | </body>
     *  |
     *
     * Registering a scheme as standard will allow access to files through the
     * FileSystem API. Otherwise the renderer will throw a security error for the
     * scheme.
     *
     * By default web storage apis (localStorage, sessionStorage, webSQL, indexedDB,
     * cookies) are disabled for non standard schemes. So in general if you want to
     * register a custom protocol to replace the http protocol, you have to register
     * it as a standard scheme:
     *
     *  |
     *  | const {app, protocol} = require('electron')
     *  |
     *  | protocol.registerStandardSchemes(['atom'])
     *  | app.on('ready', () => {
     *  |   protocol.registerHttpProtocol('atom', '...')
     *  | })
     *  |
     *
     * Note: This method can only be used before the ready event of the app module
     * gets emitted.
     *
     * @param schemes Custom schemes to be registered as standard schemes.
     * @param options
     */
    fun registerStandardSchemes(schemes: Array<String>,
                                options: (electron.protocol.RegisterStandardSchemesOptions.() -> Unit)? = null): Unit =
            electron.protocol.module.registerStandardSchemes(schemes,
                    options?.let { electron.protocol.RegisterStandardSchemesOptions().apply(it) })

    /**
     * @param schemes Custom schemes to be registered to handle service workers.
     */
    fun registerServiceWorkerSchemes(schemes: Array<String>): Unit =
            electron.protocol.module.registerServiceWorkerSchemes(schemes)

    /**
     * Registers a protocol of scheme that will send the file as a response. The
     * handler will be called with handler(request, callback) when a request is going
     * to be created with scheme. completion will be called with completion(null)
     * when scheme is successfully registered or completion(error) when failed.
     *
     * To handle the request, the callback should be called with either the file's
     * path or an object that has a path property, e.g. callback(filePath) or
     * callback({path: filePath}).
     *
     * When callback is called with nothing, a number, or an object that has an error
     * property, the request will fail with the error number you specified. For the
     * available error numbers you can use, please see the net error list.
     *
     * By default the scheme is treated like http:, which is parsed differently than
     * protocols that follow the "generic URI syntax" like file:, so you probably
     * want to call protocol.registerStandardSchemes to have your scheme treated as a
     * standard scheme.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun registerFileProtocol(scheme: String,
                             handler: (request: electron.protocol.RegisterFileProtocolRequest, callback: (filePath: String?) -> Unit) -> Unit,
                             completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.registerFileProtocol(scheme, handler, completion)

    /**
     * Registers a protocol of scheme that will send a Buffer as a response.
     *
     * The usage is the same with registerFileProtocol, except that the callback
     * should be called with either a Buffer object or an object that has the data,
     * mimeType, and charset properties.
     *
     * Example:
     *
     *  |
     *  | const {protocol} = require('electron')
     *  |
     *  | protocol.registerBufferProtocol('atom', (request, callback) => {
     *  |   callback({mimeType: 'text/html', data: new Buffer('<h5>Response</h5>')})
     *  | }, (error) => {
     *  |   if (error) console.error('Failed to register protocol')
     *  | })
     *  |
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun registerBufferProtocol(scheme: String,
                               handler: (request: electron.protocol.RegisterBufferProtocolRequest, callback: (buffer: dynamic?) -> Unit) -> Unit,
                               completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.registerBufferProtocol(scheme, handler, completion)

    /**
     * Registers a protocol of scheme that will send a String as a response.
     *
     * The usage is the same with registerFileProtocol, except that the callback
     * should be called with either a String or an object that has the data,
     * mimeType, and charset properties.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun registerStringProtocol(scheme: String,
                               handler: (request: electron.protocol.RegisterStringProtocolRequest, callback: (data: String?) -> Unit) -> Unit,
                               completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.registerStringProtocol(scheme, handler, completion)

    /**
     * Registers a protocol of scheme that will send an HTTP request as a response.
     *
     * The usage is the same with registerFileProtocol, except that the callback
     * should be called with a redirectRequest object that has the url, method,
     * referrer, uploadData and session properties.
     *
     * By default the HTTP request will reuse the current session. If you want the
     * request to have a different session you should set session to null.
     *
     * For POST requests the uploadData object must be provided.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun registerHttpProtocol(scheme: String,
                             handler: (request: electron.protocol.RegisterHttpProtocolRequest, callback: (redirectRequest: electron.protocol.RegisterHttpProtocolRedirectRequest) -> Unit) -> Unit,
                             completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.registerHttpProtocol(scheme, handler, completion)

    /**
     * Unregisters the custom protocol of scheme.
     *
     * @param scheme
     * @param completion
     */
    fun unregisterProtocol(scheme: String, completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.unregisterProtocol(scheme, completion)

    /**
     * The callback will be called with a boolean that indicates whether there is
     * already a handler for scheme.
     *
     * @param scheme
     * @param callback
     */
    fun isProtocolHandled(scheme: String, callback: (error: Error) -> Unit): Unit =
            electron.protocol.module.isProtocolHandled(scheme, callback)

    /**
     * Intercepts scheme protocol and uses handler as the protocol's new handler
     * which sends a file as a response.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun interceptFileProtocol(scheme: String,
                              handler: (request: electron.protocol.InterceptFileProtocolRequest, callback: (filePath: String) -> Unit) -> Unit,
                              completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.interceptFileProtocol(scheme, handler, completion)

    /**
     * Intercepts scheme protocol and uses handler as the protocol's new handler
     * which sends a String as a response.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun interceptStringProtocol(scheme: String,
                                handler: (request: electron.protocol.InterceptStringProtocolRequest, callback: (data: String?) -> Unit) -> Unit,
                                completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.interceptStringProtocol(scheme, handler, completion)

    /**
     * Intercepts scheme protocol and uses handler as the protocol's new handler
     * which sends a Buffer as a response.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun interceptBufferProtocol(scheme: String,
                                handler: (request: electron.protocol.InterceptBufferProtocolRequest, callback: (buffer: dynamic?) -> Unit) -> Unit,
                                completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.interceptBufferProtocol(scheme, handler, completion)

    /**
     * Intercepts scheme protocol and uses handler as the protocol's new handler
     * which sends a new HTTP request as a response.
     *
     * @param scheme
     * @param handler
     * @param completion
     */
    fun interceptHttpProtocol(scheme: String,
                              handler: (request: electron.protocol.InterceptHttpProtocolRequest, callback: (redirectRequest: electron.protocol.InterceptHttpProtocolRedirectRequest) -> Unit) -> Unit,
                              completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.interceptHttpProtocol(scheme, handler, completion)

    /**
     * Remove the interceptor installed for scheme and restore its original handler.
     *
     * @param scheme
     * @param completion
     */
    fun uninterceptProtocol(scheme: String, completion: ((error: Error) -> Unit)? = null): Unit =
            electron.protocol.module.uninterceptProtocol(scheme, completion)

    // ~ Builders ------------------------------------------------------------------------------

    class RegisterStandardSchemesOptions(
            /**
             * true to register the scheme as secure. Default false.
             */
            var secure: Boolean? = null

    )

    class RegisterFileProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class RegisterBufferProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class RegisterStringProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class RegisterHttpProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class RegisterHttpProtocolRedirectRequest(
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
            var session: electron.protocol.RegisterHttpProtocolSession? = null,

            /**
             *
             */
            var uploadData: electron.protocol.RegisterHttpProtocolUploadData? = null

    )

    class RegisterHttpProtocolSession

    class RegisterHttpProtocolUploadData(
            /**
             * MIME type of the content.
             */
            var contentType: String,

            /**
             * Content to be sent.
             */
            var data: String

    )


    class InterceptFileProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class InterceptStringProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class InterceptBufferProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class InterceptHttpProtocolRequest(
            /**
             *
             */
            var url: String,

            /**
             *
             */
            var referrer: String,

            /**
             *
             */
            var method: String,

            /**
             *
             */
            var uploadData: Array<electron.UploadData>

    )

    class InterceptHttpProtocolRedirectRequest(
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
            var session: electron.protocol.InterceptHttpProtocolSession? = null,

            /**
             *
             */
            var uploadData: electron.protocol.InterceptHttpProtocolUploadData? = null

    )

    class InterceptHttpProtocolSession

    class InterceptHttpProtocolUploadData(
            /**
             * MIME type of the content.
             */
            var contentType: String,

            /**
             * Content to be sent.
             */
            var data: String

    )

}

