package com.phodal.gradle.template.plugin

import org.gradle.api.Project

class VariantManager(
    project: Project,
    taskManager: ApplicationTaskManager
) {
    private var defaultConfigData: ProductFlavorData<ProductFlavor>? = null

    init {
        this.defaultConfigData = ProductFlavorData<ProductFlavor>(project)
    }

    fun createAndroidTasks() {

    }
}
