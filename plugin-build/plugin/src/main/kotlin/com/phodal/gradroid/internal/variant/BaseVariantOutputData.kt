package com.phodal.gradroid.internal.variant

import com.phodal.gradroid.internal.tasks.AndroidProGuardTask
import com.phodal.gradroid.internal.tasks.PrepareDependenciesTask
import com.phodal.gradroid.internal.tasks.ProcessAndroidResources
import org.gradle.api.Task

abstract class BaseVariantOutputData: VariantOutput {
    var obfuscationTask: AndroidProGuardTask? = null
    var preBuildTask: Task? = null
    var prepareDependenciesTask: PrepareDependenciesTask? = null
    var assembleTask: Task? = null
    var processResourcesTask: ProcessAndroidResources? = null
}