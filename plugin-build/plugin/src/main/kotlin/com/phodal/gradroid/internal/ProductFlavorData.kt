package com.phodal.gradroid.internal

import com.phodal.gradroid.internal.api.DefaultAndroidSourceDirectorySet
import com.phodal.gradroid.internal.api.DefaultAndroidSourceSet
import org.gradle.api.Project

class ProductFlavorData<T> {
    val sourceSet: DefaultAndroidSourceSet

    constructor(project: Project, sourceSet: DefaultAndroidSourceSet?) {
//        var assembleTask = project.tasks.create("assembleGradal")
//        assembleTask.description = "Assembles all builds."
//        assembleTask.setGroup("Build")

        val javaSrcDisplayName = String.format("%s Java source", "main")

        val javaSource = DefaultAndroidSourceDirectorySet(javaSrcDisplayName, project)
        javaSource.getFilter().include("**/*.java")

        this.sourceSet = sourceSet!!
    }

}
