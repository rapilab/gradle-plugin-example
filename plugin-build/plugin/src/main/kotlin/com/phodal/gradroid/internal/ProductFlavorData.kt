package com.phodal.gradroid.internal

import com.phodal.gradroid.internal.api.DefaultAndroidSourceSet
import org.gradle.api.Project

class ProductFlavorData<T> {
    val sourceSet: DefaultAndroidSourceSet

    constructor(project: Project, sourceSet: DefaultAndroidSourceSet?) {
//        var assembleTask = project.tasks.create("assembleGradal")
//        assembleTask.description = "Assembles all builds."
//        assembleTask.setGroup("Build")

        this.sourceSet = sourceSet!!
    }

}
