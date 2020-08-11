package com.phodal.gradle.template.plugin.internal.variant

import com.phodal.gradle.template.plugin.PrepareDependenciesTask
import com.phodal.gradle.template.plugin.internal.tasks.ProcessAndroidResources
import org.gradle.api.Task

abstract class BaseVariantOutputData: VariantOutput {
    var preBuildTask: Task? = null
    var prepareDependenciesTask: PrepareDependenciesTask? = null
    var assembleTask: Task? = null
    var processResourcesTask: ProcessAndroidResources? = null
}