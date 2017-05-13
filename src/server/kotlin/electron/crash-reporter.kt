@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object crashReporter {

    private val module: dynamic = js("require('electron').crashReporter")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.crashReporter.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * You are required to call this method before using any other crashReporter APIs
     * and in each process (main/renderer) from which you want to collect crash
     * reports. You can pass different options to crashReporter.start when calling
     * from different processes.
     *
     * Note Child processes created via the child_process module will not have access
     * to the Electron modules. Therefore, to collect crash reports from them, use
     * process.crashReporter.start instead. Pass the same options as above along with
     * an additional one called crashesDirectory that should point to a directory to
     * store the crash reports temporarily. You can test this out by calling
     * process.crash() to crash the child process.
     *
     * Note: To collect crash reports from child process in Windows, you need to add
     * this extra code as well. This will start the process that will monitor and
     * send the crash reports. Replace submitURL, productName and crashesDirectory
     * with appropriate values.
     *
     * Note: If you need send additional/updated extra parameters after your first
     * call start you can call setExtraParameter on macOS or call start again with
     * the new/updated extra parameters on Linux and Windows.
     *
     *  |
     *  |  const args = [
     *  |    `--reporter-url=${submitURL}`,
     *  |    `--application-name=${productName}`,
     *  |    `--crashes-directory=${crashesDirectory}`
     *  |  ]
     *  |  const env = {
     *  |    ELECTRON_INTERNAL_CRASH_SERVICE: 1
     *  |  }
     *  |  spawn(process.execPath, args, {
     *  |    env: env,
     *  |    detached: true
     *  |  })
     *  |
     *
     * Note: On macOS, Electron uses a new crashpad client for crash collection and
     * reporting. If you want to enable crash reporting, initializing crashpad from
     * the main process using crashReporter.start is required regardless of which
     * process you want to collect crashes from. Once initialized this way, the
     * crashpad handler collects crashes from all processes. You still have to call
     * crashReporter.start from the renderer or child process, otherwise crashes from
     * them will get reported without companyName, productName or any of the extra
     * information.
     *
     * @param options
     */
    fun start(options: electron.crashReporter.StartOptions): Unit =
            electron.crashReporter.module.start(options)

    /**
     * @returns
     */
    fun getLastCrashReport(): electron.CrashReport =
            electron.crashReporter.module.getLastCrashReport()

    /**
     * @returns
     */
    fun getUploadedReports(): Array<electron.CrashReport> =
            electron.crashReporter.module.getUploadedReports()

    /**
     * Note: This API can only be called from the main process.
     *
     * @returns Whether reports should be submitted to the server. Set through the start
     *          method or setUploadToServer.
     */
    fun getUploadToServer(): Boolean =
            electron.crashReporter.module.getUploadToServer()

    /**
     * This would normally be controlled by user preferences. This has no effect if
     * called before start is called.
     *
     * Note: This API can only be called from the main process.
     *
     * @param uploadToServer Whether reports should be submitted to the server
     */
    fun setUploadToServer(uploadToServer: Boolean): Unit =
            electron.crashReporter.module.setUploadToServer(uploadToServer)

    /**
     * Set an extra parameter to set be sent with the crash report. The values
     * specified here will be sent in addition to any values set via the extra option
     * when start was called. This API is only available on macOS, if you need to
     * add/update extra parameters on Linux and Windows after your first call to
     * start you can call start again with the updated extra options.
     *
     * @param key Parameter key.
     * @param value Parameter value. Specifying null or undefined will remove the key from the
     *              extra parameters.
     */
    fun setExtraParameter(key: String, value: String): Unit =
            electron.crashReporter.module.setExtraParameter(key, value)

    // ~ Builders ------------------------------------------------------------------------------

    class StartOptions(
            /**
             *
             */
            var companyName: String? = null,

            /**
             * URL that crash reports will be sent to as POST.
             */
            var submitURL: String,

            /**
             * Defaults to app.getName().
             */
            var productName: String? = null,

            /**
             * Whether crash reports should be sent to the server Default is true.
             */
            var uploadToServer: Boolean? = null,

            /**
             * Default is false.
             */
            var ignoreSystemCrashHandler: Boolean? = null,

            /**
             * An object you can define that will be sent along with the report. Only string
             * properties are sent correctly. Nested objects are not supported.
             */
            var extra: electron.crashReporter.StartExtra? = null

    )

    class StartExtra

}

