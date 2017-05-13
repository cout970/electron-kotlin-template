@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object session {

    private val module: dynamic = js("require('electron').session")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.session.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * If partition starts with persist:, the page will use a persistent session
     * available to all pages in the app with the same partition. if there is no
     * persist: prefix, the page will use an in-memory session. If the partition is
     * empty then default session of the app will be returned.
     *
     * To create a Session with options, you have to ensure the Session with the
     * partition has never been used before. There is no way to change the options of
     * an existing Session object.
     *
     * @param partition
     * @param options
     *
     * @returns A session instance from partition string. When there is an existing Session
     *          with the same partition, it will be returned; otherwise a new Session instance
     *          will be created with options.
     */
    fun fromPartition(partition: String, options: electron.session.FromPartitionOptions): electron.Session =
            electron.session.module.fromPartition(partition, options)

    // ~ Builders ------------------------------------------------------------------------------

    class FromPartitionOptions(
            /**
             * Whether to enable cache.
             */
            var cache: Boolean

    )
}

@Suppress("REDUNDANT_NULLABLE")
class Session constructor(val instance: dynamic, @Suppress("UNUSED_PARAMETER") ignoreMe: Unit) {

    @Suppress("UNUSED_VARIABLE")
    constructor() : this(Unit.let {
        val _constructor = js("require('electron').Session")
        js("new _constructor()")
    }, Unit)

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.Session.Companion.module.on(event, callback)

    // ~ Properties ----------------------------------------------------------------------------

    /**
     * A Cookies object for this session.
     */
    val cookies: electron.Cookies get() = electron.Cookies(instance.cookies, Unit)

    /**
     * A WebRequest object for this session.
     */
    val webRequest: electron.WebRequest get() = electron.WebRequest(instance.webRequest, Unit)

    /**
     * A Protocol object (an instance of protocol module) for this session.
     *
     *  |
     *  | const {app, session} = require('electron')
     *  | const path = require('path')
     *  |
     *  | app.on('ready', function () {
     *  |   const protocol = session.fromPartition('some-partition').protocol
     *  |   protocol.registerFileProtocol('atom', function (request, callback) {
     *  |     var url = request.url.substr(7)
     *  |     callback({path: path.normalize(`${__dirname}/${url}`)})
     *  |   }, function (error) {
     *  |     if (error) console.error('Failed to register protocol')
     *  |   })
     *  | })
     *  |
     */
    val protocol: dynamic get() = instance.protocol


    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Callback is invoked with the session's current cache size.
     *
     * @param callback
     */
    fun getCacheSize(callback: (size: Int) -> Unit): Unit =
            instance.getCacheSize(callback)

    /**
     * Clears the session’s HTTP cache.
     *
     * @param callback Called when operation is done
     */
    fun clearCache(callback: (dynamic) -> Unit): Unit =
            instance.clearCache(callback)

    /**
     * Clears the data of web storages.
     *
     * @param options
     * @param callback Called when operation is done.
     */
    fun clearStorageData(options: electron.Session.ClearStorageDataOptions? = null,
                         callback: ((dynamic) -> Unit)? = null): Unit =
            instance.clearStorageData(options, callback)

    /**
     * Writes any unwritten DOMStorage data to disk.
     */
    fun flushStorageData(): Unit =
            instance.flushStorageData()

    /**
     * Sets the proxy settings.
     *
     * When pacScript and proxyRules are provided together, the proxyRules option is
     * ignored and pacScript configuration is applied.
     *
     * The proxyRules has to follow the rules below:
     *
     *  |
     *  | proxyRules = schemeProxies[";"<schemeProxies>]
     *  | schemeProxies = [<urlScheme>"="]<proxyURIList>
     *  | urlScheme = "http" | "https" | "ftp" | "socks"
     *  | proxyURIList = <proxyURL>[","<proxyURIList>]
     *  | proxyURL = [<proxyScheme>"://"]<proxyHost>[":"<proxyPort>]
     *  |
     *
     * For example:
     *
     *  . http=foopy:80;ftp=foopy2 - Use HTTP proxy foopy:80 for http:// URLs, and HTTP
     *    proxy foopy2:80 for ftp:// URLs.
     *  . foopy:80 - Use HTTP proxy foopy:80 for all URLs.
     *  . foopy:80,bar,direct:// - Use HTTP proxy foopy:80 for all URLs, failing over to
     *    bar if foopy:80 is unavailable, and after that using no proxy.
     *  . socks4://foopy - Use SOCKS v4 proxy foopy:1080 for all URLs.
     *  . http=foopy,socks5://bar.com - Use HTTP proxy foopy for http URLs, and fail
     *    over to the SOCKS5 proxy bar.com if foopy is unavailable.
     *  . http=foopy,direct:// - Use HTTP proxy foopy for http URLs, and use no proxy if
     *    foopy is unavailable.
     *  . http=foopy;socks=foopy2 - Use HTTP proxy foopy for http URLs, and use
     *    socks4://foopy2 for all other URLs.
     *
     * The proxyBypassRules is a comma separated list of rules described below:
     *
     *  . [ URL_SCHEME "://" ] HOSTNAME_PATTERN [ ":" <port> ]
     *
     * Match all hostnames that match the pattern HOSTNAME_PATTERN.
     *
     * Examples: "foobar.com", "foobar.com", ".foobar.com", "foobar.com:99",
     * "https://x..y.com:99"
     *
     *  . "." HOSTNAME_SUFFIX_PATTERN [ ":" PORT ]
     *
     * Match a particular domain suffix.
     *
     * Examples: ".google.com", ".com", "http://.google.com"
     *
     *  . [ SCHEME "://" ] IP_LITERAL [ ":" PORT ]
     *
     * Match URLs which are IP address literals.
     *
     * Examples: "127.0.1", "[0:0::1]", "[::1]", "http://[::1]:99"
     *
     *  . IP_LITERAL "/" PREFIX_LENGHT_IN_BITS
     *
     * Match any URL that is to an IP literal that falls between the given range. IP
     * range is specified using CIDR notation.
     *
     * Examples: "192.168.1.1/16", "fefe:13::abc/33".
     *
     *  . <local>
     *
     * Match local addresses. The meaning of <local> is whether the host matches one
     * of: "127.0.0.1", "::1", "localhost".
     *
     * @param config
     * @param callback Called when operation is done.
     */
    fun setProxy(config: electron.Session.SetProxyConfig, callback: (dynamic) -> Unit): Unit =
            instance.setProxy(config, callback)

    /**
     * Resolves the proxy information for url. The callback will be called with
     * callback(proxy) when the request is performed.
     *
     * @param url URL
     * @param callback
     */
    fun resolveProxy(url: String, callback: (proxy: electron.Session.ResolveProxyProxy.() -> Unit) -> Unit): Unit =
            instance.resolveProxy(url, callback)

    /**
     * Sets download saving directory. By default, the download directory will be the
     * Downloads under the respective app folder.
     *
     * @param path The download location
     */
    fun setDownloadPath(path: String): Unit =
            instance.setDownloadPath(path)

    /**
     * Emulates network with the given configuration for the session.
     *
     *  |
     *  | // To emulate a GPRS connection with 50kbps throughput and 500 ms latency.
     *  | window.webContents.session.enableNetworkEmulation({
     *  |   latency: 500,
     *  |   downloadThroughput: 6400,
     *  |   uploadThroughput: 6400
     *  | })
     *  |
     *  | // To emulate a network outage.
     *  | window.webContents.session.enableNetworkEmulation({offline: true})
     *  |
     *
     * @param options
     */
    fun enableNetworkEmulation(options: electron.Session.EnableNetworkEmulationOptions.() -> Unit): Unit =
            instance.enableNetworkEmulation(options.let { electron.Session.EnableNetworkEmulationOptions().apply(it) })

    /**
     * Disables any network emulation already active for the session. Resets to the
     * original network configuration.
     */
    fun disableNetworkEmulation(): Unit =
            instance.disableNetworkEmulation()

    /**
     * Sets the certificate verify proc for session, the proc will be called with
     * proc(request, callback) whenever a server certificate verification is
     * requested. Calling callback(0) accepts the certificate, calling callback(-2)
     * rejects it.
     *
     * Calling setCertificateVerifyProc(null) will revert back to default certificate
     * verify proc.
     *
     *  |
     *  | const {BrowserWindow} = require('electron')
     *  | let win = new BrowserWindow()
     *  |
     *  | win.webContents.session.setCertificateVerifyProc((hostname, cert, callback) => {
     *  |   callback(hostname === 'github.com')
     *  | })
     *  |
     *
     * @param proc
     */
    fun setCertificateVerifyProc(
            proc: (request: electron.Session.SetCertificateVerifyProcRequest, callback: (verificationResult: Int) -> Unit) -> Unit): Unit =
            instance.setCertificateVerifyProc(proc)

    /**
     * Sets the handler which can be used to respond to permission requests for the
     * session. Calling callback(true) will allow the permission and callback(false)
     * will reject it.
     *
     *  |
     *  | const {session} = require('electron')
     *  | session.fromPartition('some-partition').setPermissionRequestHandler((webContents, permission, callback) => {
     *  |   if (webContents.getURL() === 'some-host' && permission === 'notifications') {
     *  |     return callback(false) // denied.
     *  |   }
     *  |
     *  |   callback(true)
     *  | })
     *  |
     *
     * @param handler
     */
    fun setPermissionRequestHandler(
            handler: (webContents: electron.Session.SetPermissionRequestHandlerWebContents.() -> Unit, permission: String, callback: (permissionGranted: Boolean) -> Unit) -> Unit): Unit =
            instance.setPermissionRequestHandler(handler)

    /**
     * Clears the host resolver cache.
     *
     * @param callback Called when operation is done.
     */
    fun clearHostResolverCache(callback: ((dynamic) -> Unit)? = null): Unit =
            instance.clearHostResolverCache(callback)

    /**
     * Dynamically sets whether to always send credentials for HTTP NTLM or Negotiate
     * authentication.
     *
     *  |
     *  | const {session} = require('electron')
     *  | // consider any url ending with `example.com`, `foobar.com`, `baz`
     *  | // for integrated authentication.
     *  | session.defaultSession.allowNTLMCredentialsForDomains('*example.com, *foobar.com, *baz')
     *  |
     *  | // consider all urls for integrated authentication.
     *  | session.defaultSession.allowNTLMCredentialsForDomains('*')
     *  |
     *
     * @param domains A comma-seperated list of servers for which integrated authentication is
     *                enabled.
     */
    fun allowNTLMCredentialsForDomains(domains: String): Unit =
            instance.allowNTLMCredentialsForDomains(domains)

    /**
     * Overrides the userAgent and acceptLanguages for this session.
     *
     * The acceptLanguages must a comma separated ordered list of language codes, for
     * example "en-US,fr,de,ko,zh-CN,ja".
     *
     * This doesn't affect existing WebContents, and each WebContents can use
     * webContents.setUserAgent to override the session-wide user agent.
     *
     * @param userAgent
     * @param acceptLanguages
     */
    fun setUserAgent(userAgent: String, acceptLanguages: String? = null): Unit =
            instance.setUserAgent(userAgent, acceptLanguages)

    /**
     * @returns The user agent for this session.
     */
    fun getUserAgent(): String =
            instance.getUserAgent()

    /**
     * @param identifier Valid UUID.
     * @param callback
     *
     * @returns The blob data associated with the identifier.
     */
    fun getBlobData(identifier: String, callback: (result: dynamic) -> Unit): org.w3c.files.Blob =
            instance.getBlobData(identifier, callback)

    /**
     * Allows resuming cancelled or interrupted downloads from previous Session. The
     * API will generate a DownloadItem that can be accessed with the will-download
     * event. The DownloadItem will not have any WebContents associated with it and
     * the initial state will be interrupted. The download will start only when the
     * resume API is called on the DownloadItem.
     *
     * @param options
     */
    fun createInterruptedDownload(options: electron.Session.CreateInterruptedDownloadOptions): Unit =
            instance.createInterruptedDownload(options)

    /**
     * Clears the session’s HTTP authentication cache.
     *
     * @param options
     * @param callback Called when operation is done
     */
    fun clearAuthCache(options: dynamic, callback: ((dynamic) -> Unit)? = null): Unit =
            instance.clearAuthCache(options, callback)

    // ~ Companion -----------------------------------------------------------------------------

    companion object {

        private val module: dynamic = js("require('electron').Session")

    }

    // ~ Builders ------------------------------------------------------------------------------

    class ClearStorageDataOptions(
            /**
             * Should follow window.location.origin’s representation scheme://host:port.
             */
            var origin: String,

            /**
             * The types of storages to clear, can contain: appcache, cookies, filesystem,
             * indexdb, localstorage, shadercache, websql, serviceworkers
             */
            var storages: Array<String>,

            /**
             * The types of quotas to clear, can contain: temporary, persistent, syncable.
             */
            var quotas: Array<String>

    )

    class SetProxyConfig(
            /**
             * The URL associated with the PAC file.
             */
            var pacScript: String,

            /**
             * Rules indicating which proxies to use.
             */
            var proxyRules: String,

            /**
             * Rules indicating which URLs should bypass the proxy settings.
             */
            var proxyBypassRules: String

    )

    class ResolveProxyProxy

    class EnableNetworkEmulationOptions(
            /**
             * Whether to emulate network outage. Defaults to false.
             */
            var offline: Boolean? = null,

            /**
             * RTT in ms. Defaults to 0 which will disable latency throttling.
             */
            var latency: Double? = null,

            /**
             * Download rate in Bps. Defaults to 0 which will disable download throttling.
             */
            var downloadThroughput: Double? = null,

            /**
             * Upload rate in Bps. Defaults to 0 which will disable upload throttling.
             */
            var uploadThroughput: Double? = null

    )

    class SetCertificateVerifyProcRequest(
            /**
             *
             */
            var hostname: String,

            /**
             *
             */
            var certificate: Certificate,

            /**
             * Verification result from chromium.
             */
            var error: String

    )

    class SetPermissionRequestHandlerWebContents

    class CreateInterruptedDownloadOptions(
            /**
             * Absolute path of the download.
             */
            var path: String,

            /**
             * Complete URL chain for the download.
             */
            var urlChain: Array<String>,

            /**
             *
             */
            var mimeType: String? = null,

            /**
             * Start range for the download.
             */
            var offset: Int,

            /**
             * Total length of the download.
             */
            var length: Int,

            /**
             * Last-Modified header value.
             */
            var lastModified: String,

            /**
             * ETag header value.
             */
            var eTag: String,

            /**
             * Time when download was started in number of seconds since UNIX epoch.
             */
            var startTime: Double? = null

    )
}

