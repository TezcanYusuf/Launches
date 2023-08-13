package com.yusuf.launches.utils

import java.util.Locale

object StringUtils {

    fun prepareForQuery(baseString: String): String {
        return baseString.lowercase(Locale.ROOT).trim().replace(" ", "")
    }
}