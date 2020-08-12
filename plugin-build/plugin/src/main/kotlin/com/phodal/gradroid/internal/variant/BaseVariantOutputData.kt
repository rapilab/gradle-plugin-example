package com.phodal.gradroid.internal.variant

import com.phodal.gradroid.internal.tasks.AndroidProGuardTask
import com.phodal.gradroid.internal.tasks.PrepareDependenciesTask
import com.phodal.gradroid.internal.tasks.ProcessAndroidResources
import org.gradle.api.Task
import org.gradle.api.tasks.compile.JavaCompile

abstract class BaseVariantOutputData(javaSources: Array<Any>) : VariantOutput {
    var assembleVariantTask: Task? = null
    var compileTask: Task? = null
    var javaCompileTask: JavaCompile? = null
    var obfuscationTask: AndroidProGuardTask? = null
    var preBuildTask: Task? = null
    var prepareDependenciesTask: PrepareDependenciesTask? = null
    var assembleTask: Task? = null
    var processResourcesTask: ProcessAndroidResources? = null
    var javaSources: Array<Any> = javaSources
        get() {
            if (field.isEmpty()) {
                val sourceList: List<Any> = arrayListOf()

                field = sourceList.toTypedArray()
            }
            return field
        }
        set(value) {}
}