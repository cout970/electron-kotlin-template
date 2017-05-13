@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class ShortcutDetails(
        /**
         * The target to launch from this shortcut.
         */
        var target: String,

        /**
         * The working directory. Default is empty.
         */
        var cwd: String? = null,

        /**
         * The arguments to be applied to target when launching from this shortcut.
         * Default is empty.
         */
        var args: String? = null,

        /**
         * The description of the shortcut. Default is empty.
         */
        var description: String? = null,

        /**
         * The path to the icon, can be a DLL or EXE. icon and iconIndex have to be set
         * together. Default is empty, which uses the target's icon.
         */
        var icon: String? = null,

        /**
         * The resource ID of icon when icon is a DLL or EXE. Default is 0.
         */
        var iconIndex: Number? = null,

        /**
         * The Application User Model ID. Default is empty.
         */
        var appUserModelId: String? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

