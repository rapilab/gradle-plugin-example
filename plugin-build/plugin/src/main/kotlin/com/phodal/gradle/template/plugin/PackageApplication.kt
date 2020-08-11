package com.phodal.gradle.template.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class PackageApplication: DefaultTask() {
    @TaskAction
    fun perform() {
        println("Content printed to file successfully")
    }
}
