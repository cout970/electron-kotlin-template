@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class JumpListItem(
        /**
         * One of the following:
         */
        var type: String? = null,

        /**
         * Path of the file to open, should only be set if type is file.
         */
        var path: String? = null,

        /**
         * Path of the program to execute, usually you should specify process.execPath
         * which opens the current program. Should only be set if type is task.
         */
        var program: String? = null,

        /**
         * The command line arguments when program is executed. Should only be set if
         * type is task.
         */
        var args: String? = null,

        /**
         * The text to be displayed for the item in the Jump List. Should only be set if
         * type is task.
         */
        var title: String? = null,

        /**
         * Description of the task (displayed in a tooltip). Should only be set if type
         * is task.
         */
        var description: String? = null,

        /**
         * The absolute path to an icon to be displayed in a Jump List, which can be an
         * arbitrary resource file that contains an icon (e.g. .ico, .exe, .dll). You can
         * usually specify process.execPath to show the program icon.
         */
        var iconPath: String? = null,

        /**
         * The index of the icon in the resource file. If a resource file contains
         * multiple icons this value can be used to specify the zero-based index of the
         * icon that should be displayed for this task. If a resource file contains only
         * one icon, this property should be set to zero.
         */
        var iconIndex: Number? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

