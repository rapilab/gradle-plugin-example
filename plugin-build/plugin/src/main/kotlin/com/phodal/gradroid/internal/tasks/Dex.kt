package com.phodal.gradroid.internal.tasks

import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import java.io.File

open class Dex : BaseTask() {
    @OutputDirectory
    val outputFolder = File("out")

    @TaskAction
    fun taskAction(inputs: IncrementalTaskInputs) {

    }
}
