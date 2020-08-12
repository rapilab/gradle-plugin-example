package com.phodal.gradroid.internal.tasks

import com.phodal.gradroid.internal.variant.BaseVariantData
import org.gradle.api.tasks.TaskAction

open class PrepareDependenciesTask: BaseTask() {
//    var variant: BaseVariantData
    var checkers: MutableList<DependencyChecker> = mutableListOf()
    var androidDependencies: MutableSet<Pair<Int, String>> = mutableSetOf()

    @TaskAction
    fun prepare() {
    }

    fun addChecker(checker: DependencyChecker) {
        checkers.add(checker)
    }
}
