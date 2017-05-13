@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
object app {

    private val module: dynamic = js("require('electron').app")

    // ~ Events --------------------------------------------------------------------------------

    fun onEvent(event: String, callback: () -> Unit): Unit =
            electron.app.module.on(event, callback)

    // ~ Methods -------------------------------------------------------------------------------

    /**
     * Try to close all windows. The before-quit event will be emitted first. If all
     * windows are successfully closed, the will-quit event will be emitted and by
     * default the application will terminate.
     *
     * This method guarantees that all beforeunload and unload event handlers are
     * correctly executed. It is possible that a window cancels the quitting by
     * returning false in the beforeunload event handler.
     */
    fun quit(): Unit =
            electron.app.module.quit()

    /**
     * Exits immediately with exitCode. exitCode defaults to 0.
     *
     * All windows will be closed immediately without asking user and the before-quit
     * and will-quit events will not be emitted.
     *
     * @param exitCode
     */
    fun exit(exitCode: Int? = null): Unit =
            electron.app.module.exit(exitCode)

    /**
     * Relaunches the app when current instance exits.
     *
     * By default the new instance will use the same working directory and command
     * line arguments with current instance. When args is specified, the args will be
     * passed as command line arguments instead. When execPath is specified, the
     * execPath will be executed for relaunch instead of current app.
     *
     * Note that this method does not quit the app when executed, you have to call
     * app.quit or app.exit after calling app.relaunch to make the app restart.
     *
     * When app.relaunch is called for multiple times, multiple instances will be
     * started after current instance exited.
     *
     * An example of restarting current instance immediately and adding a new command
     * line argument to the new instance:
     *
     *  |
     *  | const {app} = require('electron')
     *  |
     *  | app.relaunch({args: process.argv.slice(1).concat(['--relaunch'])})
     *  | app.exit(0)
     *  |
     *
     * @param options
     */
    fun relaunch(options: (electron.app.RelaunchOptions.() -> Unit)? = null): Unit =
            electron.app.module.relaunch(options?.let { electron.app.RelaunchOptions().apply(it) })

    /**
     * @returns true if Electron has finished initializing, false otherwise.
     */
    fun isReady(): Boolean =
            electron.app.module.isReady()

    /**
     * On Linux, focuses on the first visible window. On macOS, makes the application
     * the active app. On Windows, focuses on the application's first window.
     */
    fun focus(): Unit =
            electron.app.module.focus()

    /**
     * Hides all application windows without minimizing them.
     */
    fun hide(): Unit =
            electron.app.module.hide()

    /**
     * Shows application windows after they were hidden. Does not automatically focus
     * them.
     */
    fun show(): Unit =
            electron.app.module.show()

    /**
     * @returns The current application directory.
     */
    fun getAppPath(): String =
            electron.app.module.getAppPath()

    /**
     * You can request the following paths by the name:
     *
     *  . home User's home directory.
     *  . appData Per-user application data directory, which by default points to:
     *     . %APPDATA% on Windows
     *     . $XDG_CONFIG_HOME or ~/.config on Linux
     *     . ~/Library/Application Support on macOS
     *
     *  . userData The directory for storing your app's configuration files, which by
     *    default it is the appData directory appended with your app's name.
     *  . temp Temporary directory.
     *  . exe The current executable file.
     *  . module The libchromiumcontent library.
     *  . desktop The current user's Desktop directory.
     *  . documents Directory for a user's "My Documents".
     *  . downloads Directory for a user's downloads.
     *  . music Directory for a user's music.
     *  . pictures Directory for a user's pictures.
     *  . videos Directory for a user's videos.
     *  . pepperFlashSystemPlugin Full path to the system version of the Pepper Flash
     *    plugin.
     *
     *
     * @param name
     *
     * @returns A path to a special directory or file associated with name. On failure an
     *          Error is thrown.
     */
    fun getPath(name: String): String =
            electron.app.module.getPath(name)

    /**
     * Fetches a path's associated icon.
     *
     * On Windows, there a 2 kinds of icons:
     *
     *  . Icons associated with certain file extensions, like .mp3, .png, etc.
     *  . Icons inside the file itself, like .exe, .dll, .ico.
     *
     * On Linux and macOS, icons depend on the application associated with file mime
     * type.
     *
     * @param path
     * @param options
     * @param callback
     */
    fun getFileIcon(path: String, options: electron.app.GetFileIconOptions? = null,
                    callback: (error: Error, icon: electron.NativeImage) -> Unit): Unit =
            electron.app.module.getFileIcon(path, options, callback)

    /**
     * Overrides the path to a special directory or file associated with name. If the
     * path specifies a directory that does not exist, the directory will be created
     * by this method. On failure an Error is thrown.
     *
     * You can only override paths of a name defined in app.getPath.
     *
     * By default, web pages' cookies and caches will be stored under the userData
     * directory. If you want to change this location, you have to override the
     * userData path before the ready event of the app module is emitted.
     *
     * @param name
     * @param path
     */
    fun setPath(name: String, path: String): Unit =
            electron.app.module.setPath(name, path)

    /**
     * @returns The version of the loaded application. If no version is found in the
     *          application's package.json file, the version of the current bundle or
     *          executable is returned.
     */
    fun getVersion(): String =
            electron.app.module.getVersion()

    /**
     * Usually the name field of package.json is a short lowercased name, according
     * to the npm modules spec. You should usually also specify a productName field,
     * which is your application's full capitalized name, and which will be preferred
     * over name by Electron.
     *
     * @returns The current application's name, which is the name in the application's
     *          package.json file.
     */
    fun getName(): String =
            electron.app.module.getName()

    /**
     * Overrides the current application's name.
     *
     * @param name
     */
    fun setName(name: String): Unit =
            electron.app.module.setName(name)

    /**
     * Note: When distributing your packaged app, you have to also ship the locales
     * folder.
     *
     * Note: On Windows you have to call it after the ready events gets emitted.
     *
     * @returns The current application locale. Possible return values are documented here.
     */
    fun getLocale(): String =
            electron.app.module.getLocale()

    /**
     * Adds path to the recent documents list.
     *
     * This list is managed by the OS. On Windows you can visit the list from the
     * task bar, and on macOS you can visit it from dock menu.
     *
     * @param path
     */
    fun addRecentDocument(path: String): Unit =
            electron.app.module.addRecentDocument(path)

    /**
     * Clears the recent documents list.
     */
    fun clearRecentDocuments(): Unit =
            electron.app.module.clearRecentDocuments()

    /**
     * This method sets the current executable as the default handler for a protocol
     * (aka URI scheme). It allows you to integrate your app deeper into the
     * operating system. Once registered, all links with your-protocol:// will be
     * opened with the current executable. The whole link, including protocol, will
     * be passed to your application as a parameter.
     *
     * On Windows you can provide optional parameters path, the path to your
     * executable, and args, an array of arguments to be passed to your executable
     * when it launches.
     *
     * Note: On macOS, you can only register protocols that have been added to your
     * app's info.plist, which can not be modified at runtime. You can however change
     * the file with a simple text editor or script during build time. Please refer
     * to Apple's documentation for details.
     *
     * The API uses the Windows Registry and LSSetDefaultHandlerForURLScheme
     * internally.
     *
     * @param protocol The name of your protocol, without ://. If you want your app to handle
     *                 electron:// links, call this method with electron as the parameter.
     * @param path Defaults to process.execPath
     * @param args Defaults to an empty array
     *
     * @returns Whether the call succeeded.
     */
    fun setAsDefaultProtocolClient(protocol: String, path: String? = null, args: Array<String>? = null): Boolean =
            electron.app.module.setAsDefaultProtocolClient(protocol, path, args)

    /**
     * This method checks if the current executable as the default handler for a
     * protocol (aka URI scheme). If so, it will remove the app as the default
     * handler.
     *
     * @param protocol The name of your protocol, without ://.
     * @param path Defaults to process.execPath
     * @param args Defaults to an empty array
     *
     * @returns Whether the call succeeded.
     */
    fun removeAsDefaultProtocolClient(protocol: String, path: String? = null, args: Array<String>? = null): Boolean =
            electron.app.module.removeAsDefaultProtocolClient(protocol, path, args)

    /**
     * This method checks if the current executable is the default handler for a
     * protocol (aka URI scheme). If so, it will return true. Otherwise, it will
     * return false.
     *
     * Note: On macOS, you can use this method to check if the app has been
     * registered as the default protocol handler for a protocol. You can also verify
     * this by checking ~/Library/Preferences/com.apple.LaunchServices.plist on the
     * macOS machine. Please refer to Apple's documentation for details.
     *
     * The API uses the Windows Registry and LSCopyDefaultHandlerForURLScheme
     * internally.
     *
     * @param protocol The name of your protocol, without ://.
     * @param path Defaults to process.execPath
     * @param args Defaults to an empty array
     *
     * @returns
     */
    fun isDefaultProtocolClient(protocol: String, path: String? = null, args: Array<String>? = null): Boolean =
            electron.app.module.isDefaultProtocolClient(protocol, path, args)

    /**
     * Adds tasks to the Tasks category of the JumpList on Windows.
     *
     * tasks is an array of Task objects.
     *
     * Note: If you'd like to customize the Jump List even more use
     * app.setJumpList(categories) instead.
     *
     * @param tasks Array of Task objects
     *
     * @returns Whether the call succeeded.
     */
    fun setUserTasks(tasks: Array<Task>): Boolean =
            electron.app.module.setUserTasks(tasks.map { it.instance })

    /**
     *  . minItems Integer - The minimum number of items that will be shown in the Jump
     *    List (for a more detailed description of this value see the MSDN docs).
     *  . removedItemsJumpListItem[] - Array of JumpListItem objects that correspond to
     *    items that the user has explicitly removed from custom categories in the Jump
     *    List. These items must not be re-added to the Jump List in the next call to
     *    app.setJumpList(), Windows will not display any custom category that contains
     *    any of the removed items.
     *
     *
     * @param minItems The minimum number of items that will be shown in the Jump List (for a more
     *                 detailed description of this value see the MSDN docs).
     * @param removedItems Array of JumpListItem objects that correspond to items that the user has
     *                     explicitly removed from custom categories in the Jump List. These items must
     *                     not be re-added to the Jump List in the next call to app.setJumpList(),
     *                     Windows will not display any custom category that contains any of the removed
     *                     items.
     *
     * @returns
     */
    fun getJumpListSettings(minItems: Int, removedItems: Array<JumpListItem>): dynamic =
            electron.app.module.getJumpListSettings(minItems, removedItems.map { it.instance })

    /**
     * Sets or removes a custom Jump List for the application, and returns one of the
     * following strings:
     *
     *  . ok - Nothing went wrong.
     *  . error - One or more errors occurred, enable runtime logging to figure out the
     *    likely cause.
     *  . invalidSeparatorError - An attempt was made to add a separator to a custom
     *    category in the Jump List. Separators are only allowed in the standard Tasks
     *    category.
     *  . fileTypeRegistrationError - An attempt was made to add a file link to the Jump
     *    List for a file type the app isn't registered to handle.
     *  . customCategoryAccessDeniedError - Custom categories can't be added to the Jump
     *    List due to user privacy or group policy settings.
     *
     * If categories is null the previously set custom Jump List (if any) will be
     * replaced by the standard Jump List for the app (managed by Windows).
     *
     * Note: If a JumpListCategory object has neither the type nor the name property
     * set then its type is assumed to be tasks. If the name property is set but the
     * type property is omitted then the type is assumed to be custom.
     *
     * Note: Users can remove items from custom categories, and Windows will not
     * allow a removed item to be added back into a custom category until after the
     * next successful call to app.setJumpList(categories). Any attempt to re-add a
     * removed item to a custom category earlier than that will result in the entire
     * custom category being omitted from the Jump List. The list of removed items
     * can be obtained using app.getJumpListSettings().
     *
     * Here's a very simple example of creating a custom Jump List:
     *
     *  |
     *  | const {app} = require('electron')
     *  |
     *  | app.setJumpList([
     *  |   {
     *  |     type: 'custom',
     *  |     name: 'Recent Projects',
     *  |     items: [
     *  |       { type: 'file', path: 'C:\\Projects\\project1.proj' },
     *  |       { type: 'file', path: 'C:\\Projects\\project2.proj' }
     *  |     ]
     *  |   },
     *  |   { // has a name so `type` is assumed to be "custom"
     *  |     name: 'Tools',
     *  |     items: [
     *  |       {
     *  |         type: 'task',
     *  |         title: 'Tool A',
     *  |         program: process.execPath,
     *  |         args: '--run-tool-a',
     *  |         icon: process.execPath,
     *  |         iconIndex: 0,
     *  |         description: 'Runs Tool A'
     *  |       },
     *  |       {
     *  |         type: 'task',
     *  |         title: 'Tool B',
     *  |         program: process.execPath,
     *  |         args: '--run-tool-b',
     *  |         icon: process.execPath,
     *  |         iconIndex: 0,
     *  |         description: 'Runs Tool B'
     *  |       }
     *  |     ]
     *  |   },
     *  |   { type: 'frequent' },
     *  |   { // has no name and no type so `type` is assumed to be "tasks"
     *  |     items: [
     *  |       {
     *  |         type: 'task',
     *  |         title: 'New Project',
     *  |         program: process.execPath,
     *  |         args: '--new-project',
     *  |         description: 'Create a new project.'
     *  |       },
     *  |       { type: 'separator' },
     *  |       {
     *  |         type: 'task',
     *  |         title: 'Recover Project',
     *  |         program: process.execPath,
     *  |         args: '--recover-project',
     *  |         description: 'Recover Project'
     *  |       }
     *  |     ]
     *  |   }
     *  | ])
     *  |
     *
     * @param categories Array of JumpListCategory objects.
     */
    fun setJumpList(categories: Array<JumpListCategory>): Unit =
            electron.app.module.setJumpList(categories.map { it.instance })

    /**
     * This method makes your application a Single Instance Application - instead of
     * allowing multiple instances of your app to run, this will ensure that only a
     * single instance of your app is running, and other instances signal this
     * instance and exit.
     *
     * callback will be called with callback(argv, workingDirectory) when a second
     * instance has been executed. argv is an Array of the second instance's command
     * line arguments, and workingDirectory is its current working directory. Usually
     * applications respond to this by making their primary window focused and
     * non-minimized.
     *
     * The callback is guaranteed to be executed after the ready event of app gets
     * emitted.
     *
     * This method returns false if your process is the primary instance of the
     * application and your app should continue loading. And returns true if your
     * process has sent its parameters to another instance, and you should
     * immediately quit.
     *
     * On macOS the system enforces single instance automatically when users try to
     * open a second instance of your app in Finder, and the open-file and open-url
     * events will be emitted for that. However when users start your app in command
     * line the system's single instance mechanism will be bypassed and you have to
     * use this method to ensure single instance.
     *
     * An example of activating the window of primary instance when a second instance
     * starts:
     *
     *  |
     *  | const {app} = require('electron')
     *  | let myWindow = null
     *  |
     *  | const shouldQuit = app.makeSingleInstance((commandLine, workingDirectory) => {
     *  |   // Someone tried to run a second instance, we should focus our window.
     *  |   if (myWindow) {
     *  |     if (myWindow.isMinimized()) myWindow.restore()
     *  |     myWindow.focus()
     *  |   }
     *  | })
     *  |
     *  | if (shouldQuit) {
     *  |   app.quit()
     *  | }
     *  |
     *  | // Create myWindow, load the rest of the app, etc...
     *  | app.on('ready', () => {
     *  | })
     *  |
     *
     * @param callback
     */
    fun makeSingleInstance(callback: (argv: Array<String>, workingDirectory: String) -> Unit): Unit =
            electron.app.module.makeSingleInstance(callback)

    /**
     * Releases all locks that were created by makeSingleInstance. This will allow
     * multiple instances of the application to once again run side by side.
     */
    fun releaseSingleInstance(): Unit =
            electron.app.module.releaseSingleInstance()

    /**
     * Creates an NSUserActivity and sets it as the current activity. The activity is
     * eligible for Handoff to another device afterward.
     *
     * @param type Uniquely identifies the activity. Maps to NSUserActivity.activityType.
     * @param userInfo App-specific state to store for use by another device.
     * @param webpageURL The webpage to load in a browser if no suitable app is installed on the
     *                   resuming device. The scheme must be http or https.
     */
    fun setUserActivity(type: String, userInfo: electron.app.SetUserActivityUserInfo.() -> Unit,
                        webpageURL: String? = null): Unit =
            electron.app.module.setUserActivity(type, userInfo.let { electron.app.SetUserActivityUserInfo().apply(it) },
                    webpageURL)

    /**
     * @returns The type of the currently running activity.
     */
    fun getCurrentActivityType(): String =
            electron.app.module.getCurrentActivityType()

    /**
     * Changes the Application User Model ID to id.
     *
     * @param id
     */
    fun setAppUserModelId(id: String): Unit =
            electron.app.module.setAppUserModelId(id)

    /**
     * Imports the certificate in pkcs12 format into the platform certificate store.
     * callback is called with the result of import operation, a value of 0 indicates
     * success while any other value indicates failure according to chromium
     * net_error_list.
     *
     * @param options
     * @param callback
     */
    fun importCertificate(options: electron.app.ImportCertificateOptions, callback: (result: Int) -> Unit): Unit =
            electron.app.module.importCertificate(options, callback)

    /**
     * Disables hardware acceleration for current app.
     *
     * This method can only be called before app is ready.
     */
    fun disableHardwareAcceleration(): Unit =
            electron.app.module.disableHardwareAcceleration()

    /**
     * Sets the counter badge for current app. Setting the count to 0 will hide the
     * badge.
     *
     * On macOS it shows on the dock icon. On Linux it only works for Unity launcher,
     *
     * Note: Unity launcher requires the existence of a .desktop file to work, for
     * more information please read Desktop Environment Integration.
     *
     * @param count
     *
     * @returns Whether the call succeeded.
     */
    fun setBadgeCount(count: Int): Boolean =
            electron.app.module.setBadgeCount(count)

    /**
     * @returns The current value displayed in the counter badge.
     */
    fun getBadgeCount(): Int =
            electron.app.module.getBadgeCount()

    /**
     * @returns Whether the current desktop environment is Unity launcher.
     */
    fun isUnityRunning(): Boolean =
            electron.app.module.isUnityRunning()

    /**
     * If you provided path and args options to app.setLoginItemSettings then you
     * need to pass the same arguments here for openAtLogin to be set correctly.
     *
     *  . openAtLogin Boolean - true if the app is set to open at login.
     *  . openAsHidden Boolean - true if the app is set to open as hidden at login. This
     *    setting is only supported on macOS.
     *  . wasOpenedAtLogin Boolean - true if the app was opened at login automatically.
     *    This setting is only supported on macOS.
     *  . wasOpenedAsHidden Boolean - true if the app was opened as a hidden login item.
     *    This indicates that the app should not open any windows at startup. This
     *    setting is only supported on macOS.
     *  . restoreState Boolean - true if the app was opened as a login item that should
     *    restore the state from the previous session. This indicates that the app
     *    should restore the windows that were open the last time the app was closed.
     *    This setting is only supported on macOS.
     *
     * Note: This API has no effect on MAS builds.
     *
     * @param options
     *
     * @returns
     */
    fun getLoginItemSettings(options: (electron.app.GetLoginItemSettingsOptions.() -> Unit)? = null): dynamic =
            electron.app.module.getLoginItemSettings(
                    options?.let { electron.app.GetLoginItemSettingsOptions().apply(it) })

    /**
     * Set the app's login item settings.
     *
     * To work with Electron's autoUpdater on Windows, which uses Squirrel, you'll
     * want to set the launch path to Update.exe, and pass arguments that specify
     * your application name. For example:
     *
     *  |
     *  | const appFolder = path.dirname(process.execPath)
     *  | const updateExe = path.resolve(appFolder, '..', 'Update.exe')
     *  | const exeName = path.basename(process.execPath)
     *  |
     *  | app.setLoginItemSettings({
     *  |   openAtLogin: true,
     *  |   path: updateExe,
     *  |   args: [
     *  |     '--processStart', `"${exeName}"`,
     *  |     '--process-start-args', `"--hidden"`
     *  |   ]
     *  | })
     *  |
     *
     * Note: This API has no effect on MAS builds.
     *
     * @param settings
     */
    fun setLoginItemSettings(settings: electron.app.SetLoginItemSettingsSettings.() -> Unit): Unit =
            electron.app.module.setLoginItemSettings(
                    settings.let { electron.app.SetLoginItemSettingsSettings().apply(it) })

    /**
     * @returns true if Chrome's accessibility support is enabled, false otherwise. This API
     *          will return true if the use of assistive technologies, such as screen readers,
     *          has been detected. See
     *          https://www.chromium.org/developers/design-documents/accessibility for more
     *          details.
     */
    fun isAccessibilitySupportEnabled(): Boolean =
            electron.app.module.isAccessibilitySupportEnabled()

    /**
     * Set the about panel options. This will override the values defined in the
     * app's .plist file. See the Apple docs for more details.
     *
     * @param options
     */
    fun setAboutPanelOptions(options: electron.app.SetAboutPanelOptionsOptions.() -> Unit): Unit =
            electron.app.module.setAboutPanelOptions(
                    options.let { electron.app.SetAboutPanelOptionsOptions().apply(it) })

    // ~ Builders ------------------------------------------------------------------------------

    class RelaunchOptions(
            /**
             * (optional)
             */
            var args: Array<String>? = null,

            /**
             *
             */
            var execPath: String? = null

    )

    class GetFileIconOptions(
            /**
             *
             */
            var size: String

    )

    class SetUserActivityUserInfo

    class ImportCertificateOptions(
            /**
             * Path for the pkcs12 file.
             */
            var certificate: String,

            /**
             * Passphrase for the certificate.
             */
            var password: String

    )

    class GetLoginItemSettingsOptions(
            /**
             * The executable path to compare against. Defaults to process.execPath.
             */
            var path: String? = null,

            /**
             * The command-line arguments to compare against. Defaults to an empty array.
             */
            var args: Array<String>? = null

    )

    class SetLoginItemSettingsSettings(
            /**
             * true to open the app at login, false to remove the app as a login item.
             * Defaults to false.
             */
            var openAtLogin: Boolean? = null,

            /**
             * true to open the app as hidden. Defaults to false. The user can edit this
             * setting from the System Preferences so
             * app.getLoginItemStatus().wasOpenedAsHidden should be checked when the app is
             * opened to know the current value. This setting is only supported on macOS.
             */
            var openAsHidden: Boolean? = null,

            /**
             * The executable to launch at login. Defaults to process.execPath.
             */
            var path: String? = null,

            /**
             * The command-line arguments to pass to the executable. Defaults to an empty
             * array. Take care to wrap paths in quotes.
             */
            var args: Array<String>? = null

    )

    class SetAboutPanelOptionsOptions(
            /**
             * The app's name.
             */
            var applicationName: String? = null,

            /**
             * The app's version.
             */
            var applicationVersion: String? = null,

            /**
             * Copyright information.
             */
            var copyright: String? = null,

            /**
             * Credit information.
             */
            var credits: String? = null,

            /**
             * The app's build version number.
             */
            var version: String? = null

    )
}

