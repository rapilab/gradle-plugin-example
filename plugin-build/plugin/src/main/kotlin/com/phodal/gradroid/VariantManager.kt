package com.phodal.gradroid

import com.phodal.gradle.template.plugin.internal.ProductFlavor
import com.phodal.gradle.template.plugin.internal.ProductFlavorData
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
