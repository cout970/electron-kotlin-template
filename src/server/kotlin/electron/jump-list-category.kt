@file:Suppress("UnsafeCastFromDynamic")

package electron

@Suppress("REDUNDANT_NULLABLE")
class JumpListCategory(
        /**
         * One of the following:
         */
        var type: String? = null,

        /**
         * Must be set if type is custom, otherwise it should be omitted.
         */
        var name: String? = null,

        /**
         * Array of JumpListItem objects if type is tasks or custom, otherwise it should
         * be omitted.
         */
        var items: Array<electron.JumpListItem>? = null

) {

    val instance: dynamic = this

    // ~ Builders ------------------------------------------------------------------------------
}

