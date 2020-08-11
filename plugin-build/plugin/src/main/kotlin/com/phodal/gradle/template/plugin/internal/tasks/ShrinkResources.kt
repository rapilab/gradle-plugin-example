package com.phodal.gradle.template.plugin.internal.tasks

import org.gradle.api.tasks.TaskAction

open class ShrinkResources: BaseTask() {
    @TaskAction
    fun shrink() {
        println("shrink")
    }
}
