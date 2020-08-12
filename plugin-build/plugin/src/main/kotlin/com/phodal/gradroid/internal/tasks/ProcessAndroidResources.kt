package com.phodal.gradroid.internal.tasks

import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import java.io.File

open class ProcessAndroidResources: IncrementalTask() {
    @OutputDirectory
    @Optional
    val sourceOutputDir: File = File("dist")

    override fun doFullTaskAction() {
        val aaptPackageCommandBuilder = AaptPackageProcessBuilder(sourceOutputDir)
        getBuilder()?.processResources(aaptPackageCommandBuilder)
    }
}