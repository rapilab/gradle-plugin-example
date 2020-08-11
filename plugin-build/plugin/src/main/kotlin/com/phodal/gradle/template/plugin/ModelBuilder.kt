package com.phodal.gradle.template.plugin

import org.gradle.api.Project
import org.gradle.tooling.provider.model.ToolingModelBuilder

class ModelBuilder(taskManager: ApplicationTaskManager): ToolingModelBuilder {
    override fun canBuild(modelName: String): Boolean {
        return modelName == "AndroidProject";
    }

    override fun buildAll(modelName: String, project: Project): Any {
        return ""
    }

}
