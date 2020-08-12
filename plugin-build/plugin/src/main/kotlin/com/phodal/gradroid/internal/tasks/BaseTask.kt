package com.phodal.gradroid.internal.tasks

import org.gradle.api.DefaultTask
import org.jetbrains.annotations.Nullable

abstract class BaseTask: DefaultTask() {
    @Nullable
    private val androidBuilder: AndroidBuilder? = null

    @Nullable
    protected open fun getBuilder(): AndroidBuilder? {
        return androidBuilder
    }
}
