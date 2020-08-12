package com.phodal.gradroid

import com.phodal.gradroid.internal.ProductFlavor
import com.phodal.gradroid.internal.ProductFlavorData
import com.phodal.gradroid.internal.variant.ApkVariantOutputData
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer

class VariantManager(
    var project: Project,
    var taskManager: ApplicationTaskManager
) {
    private var defaultConfigData: ProductFlavorData<ProductFlavor>? = null

    init {
        this.defaultConfigData = ProductFlavorData<ProductFlavor>(project)
    }

    fun createAndroidTasks() {
        val tasks = project.tasks
        createTasksForVariantData(tasks)
    }


    private fun createTasksForVariantData(tasks: TaskContainer) {
        val apkVariantOutputData = ApkVariantOutputData(taskManager);
        createAssembleTaskForVariantData(tasks, apkVariantOutputData)
        taskManager.createTasksForVariantData(tasks, apkVariantOutputData)
    }

    private fun createAssembleTaskForVariantData(
        tasks: TaskContainer,
        variantOutputData: ApkVariantOutputData
    ) {
        taskManager.createAssembleTask(variantOutputData)
    }

}
