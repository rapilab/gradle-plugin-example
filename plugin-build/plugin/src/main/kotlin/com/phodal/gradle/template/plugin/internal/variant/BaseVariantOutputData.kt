package com.phodal.gradle.template.plugin.internal.variant

import com.phodal.gradle.template.plugin.internal.tasks.ProcessAndroidResources

abstract class BaseVariantOutputData: VariantOutput {

    lateinit var processResourcesTask: ProcessAndroidResources
}