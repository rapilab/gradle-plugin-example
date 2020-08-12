package com.phodal.gradroid.internal

import com.phodal.gradle.template.plugin.ApplicationTaskManager
import com.phodal.gradle.template.plugin.VariantManager
import org.gradle.api.Project
import org.gradle.tooling.provider.model.ToolingModelBuilder

class ModelBuilder(
        taskManager: ApplicationTaskManager,
        variantManager: VariantManager
): ToolingModelBuilder {
    override fun canBuild(modelName: String): Boolean {
        return modelName == "AndroidProject";
    }

    override fun buildAll(modelName: String, project: Project): Any {
        return ""
    }

}
