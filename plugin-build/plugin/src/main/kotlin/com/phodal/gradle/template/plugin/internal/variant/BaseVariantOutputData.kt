package com.phodal.gradle.template.plugin.internal.variant

import com.phodal.gradle.template.plugin.internal.tasks.ProcessAndroidResources
import org.gradle.api.Task

abstract class BaseVariantOutputData: VariantOutput {
    var assembleTask: Task? = null
    var processResourcesTask: ProcessAndroidResources? = null
}