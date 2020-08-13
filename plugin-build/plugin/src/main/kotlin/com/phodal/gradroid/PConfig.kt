package com.phodal.gradroid

import org.gradle.api.Named
import org.gradle.api.tasks.Input

class PConfig(private val name: String): Named {
    private lateinit var mMessage: String

    override fun getName(): String {
        return this.name
    }

    @Input
    fun message(msg: String) {
        this.mMessage = msg
    }
}
