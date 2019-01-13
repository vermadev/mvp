package com.triarc.tutorial.android.mvp.logger

import android.util.Log
import com.triarc.tutorial.android.mvp.intf.Logger

/**
 * Created by Devanshu Verma on 13/1/19
 */
class LoggerImpl private constructor(target: Any): Logger {

    private var tag: String? =null

    init {
        tag = target::class.java.simpleName
    }

    companion object {
        @Synchronized
        fun getLogger(target: Any) : Logger {

            return LoggerImpl(target)
        }
    }

    override fun info(logMsg: String) {
        Log.i(tag, logMsg)
    }

    override fun error(logMsg: String) {
        Log.e(tag, logMsg)
    }

    override fun debug(logMsg: String) {
        Log.d(tag, logMsg)
    }
}
