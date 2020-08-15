package com.phodal.gradroid

import org.gradle.api.Named
import org.gradle.api.tasks.Input

open class PConfig(private val name: String): Named {
    private var mSdkVersion: Int = 0
    private lateinit var mMessage: String

    override fun getName(): String {
        return this.name
    }

    @Input
    fun message(msg: String) {
        this.mMessage = msg
    }

    @Input
    fun sdkVersion(version: Int) {
        this.mSdkVersion = version
    }
}
//
//class ApiVersion(apiLevel: Int) {
//    private var mApiLevel: Int = apiLevel
//
//}
