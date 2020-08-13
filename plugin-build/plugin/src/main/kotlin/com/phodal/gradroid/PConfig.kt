package com.phodal.gradroid

import org.gradle.api.Named
import org.gradle.api.tasks.Input
import java.io.Serializable

class PConfig(private val name: String)  {
    private lateinit var mMessage: String

    fun getName(): String {
        return this.name
    }

    @Input
    fun setMessage(message: String): PConfig {
        mMessage = message
        return this
    }

    @Input
    fun getMessage(): String {
        return mMessage
    }
}
