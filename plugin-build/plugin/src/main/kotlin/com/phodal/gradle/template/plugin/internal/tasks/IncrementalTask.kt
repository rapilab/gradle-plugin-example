package com.phodal.gradle.template.plugin.internal.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs
import com.phodal.gradle.template.plugin.internal.FileStatus

import java.io.File

abstract class IncrementalTask: BaseTask() {

    protected open fun isIncremental(): Boolean {
        return false
    }

    /**
     * Actual entry point for the action.
     * Calls out to the doTaskAction as needed.
     */
    @TaskAction
    fun taskAction(inputs: IncrementalTaskInputs) {
        if (!isIncremental()) {
            doFullTaskAction()
            return
        }

        if (!inputs.isIncremental) {
            project.logger.info("Unable do incremental execution: full task run")
            doFullTaskAction()
            return
        }


        val changedInputs: MutableMap<File, FileStatus> = hashMapOf()
        inputs.outOfDate { change ->
            changedInputs[change.file] = if (change.isAdded) FileStatus.NEW else FileStatus.CHANGED
        }

        inputs.removed { change -> changedInputs[change.file] = FileStatus.REMOVED }

        doIncrementalTaskAction(changedInputs)
    }

    protected fun doIncrementalTaskAction(changedInputs: MutableMap<File, FileStatus>) {

    }
    abstract fun doFullTaskAction()
}