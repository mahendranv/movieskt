package com.ex2.ktmovies.platform

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

/**
 * Helper class for display
 */
class DisplayHelper {
    companion object {
        val DP_4 = dipToPixels(4f)
        val DP_8 = dipToPixels(8f)
        val DP_16 = dipToPixels(16f)

        /**
         * returns the dp in pixels
         */
        fun dipToPixels(dp: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                Resources.getSystem().displayMetrics
            ).toInt()
        }

        /**
         * Get the screen width
         */
        fun getScreenWidth(): Int {
            val metrics = Resources.getSystem().displayMetrics
            return metrics.widthPixels
        }

        /**
         * Get the screen height
         */
        fun getScreenHeight(): Int {
            val metrics = Resources.getSystem().displayMetrics
            return metrics.heightPixels
        }

        fun getActionBarHeight(context: Context): Int {
            val tv = TypedValue()
            var actionBarHeight = 0
            if (context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(
                    tv.data,
                    context.resources.displayMetrics
                );
            }
            return actionBarHeight
        }

        fun getNavigationBarHeight(context: Context): Int {
            val resourceId: Int =
                context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
            return if (resourceId != 0) {
                context.resources.getDimensionPixelSize(resourceId)
            } else 0
        }
    }
}