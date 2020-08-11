package com.phodal.gradle.template.plugin.internal.variant

import com.phodal.gradle.template.plugin.internal.tasks.Dex
import com.phodal.gradle.template.plugin.internal.tasks.TaskManager

class ApkVariantOutputData(val taskManager: TaskManager): BaseVariantOutputData() {
    lateinit var dexTask: Dex
}