package com.phodal.gradroid

import com.phodal.gradroid.internal.ProductFlavor
import com.phodal.gradroid.internal.ProductFlavorData
import com.phodal.gradroid.internal.api.DefaultAndroidSourceSet
import com.phodal.gradroid.internal.variant.ApkVariantOutputData
import com.phodal.gradroid.internal.variant.BaseVariantData
import com.phodal.gradroid.internal.variant.BaseVariantOutputData
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer

class VariantManager(
    var project: Project,
    var taskManager: ApplicationTaskManager
) {
//    private val buildTypes: Map<String, BuildTypeData> = Maps.newHashMap()
    private val variantDataList: List<BaseVariantData<out BaseVariantOutputData>> = mutableListOf()
    private var defaultConfigData: ProductFlavorData<ProductFlavor>? = null

    init {

//        val mainSourceSet: DefaultAndroidSourceSet = extension.getSourceSets().getByName(extension.getDefaultConfig().getName()) as DefaultAndroidSourceSet

        this.defaultConfigData = ProductFlavorData<ProductFlavor>(project, null)
    }

    fun createAndroidTasks() {
        val tasks = project.tasks

        if (variantDataList.isEmpty()) {
            populateVariantDataList()
        }

        createTasksForVariantData(tasks)
    }

    private fun populateVariantDataList() {
        // Add a compile lint task
        taskManager.createLintCompileTask()

        createVariantDataForProductFlavors(listOf<ProductFlavor>())
    }

    private fun createVariantDataForProductFlavors(productFlavorList: List<ProductFlavor>) {
        createVariantData(productFlavorList)
    }

    private fun createVariantData(productFlavorList: List<ProductFlavor>) {
//        this.defaultConfigData!!.sourceSet
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
