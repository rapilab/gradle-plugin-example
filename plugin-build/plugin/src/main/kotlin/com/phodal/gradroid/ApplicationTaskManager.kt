package com.phodal.gradroid

import com.phodal.gradroid.internal.DependencyManager
import com.phodal.gradroid.internal.tasks.*
import com.phodal.gradroid.internal.variant.ApkVariantOutputData
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.compile.JavaCompile
import java.io.File

class ApplicationTaskManager(val project: Project, dependencyManager: DependencyManager) :
        TaskManager {
    var FD_INTERMEDIATES = "intermediates"
    fun createMockableJarTask() {

    }

    fun createAssembleTask(variantOutputData: ApkVariantOutputData): Task {
        val assembleTask = project.tasks.create("assembleDebug")
        return assembleTask
    }

    fun createTasksForVariantData(
        tasks: TaskContainer,
        variantData: ApkVariantOutputData
    ) {
        createAnchorTasks(variantData)
        createCheckManifestTask()

        createMergeAppManifestsTask()
        createGenerateResValuesTask()
        createRenderscriptTask()

        createMergeResourcesTask()
        createMergeAssetsTask()

        createBuildConfigTask()
        createPreprocessResourcesTask()
        createProcessResTask(variantData)
        createProcessJavaResTask()
        createAidlTask()

        // compile java
        createJavaCompileTask()
        createJarTask()
        createPostCompilationTasks(variantData)

        val is_ndk = false
        if (is_ndk) {
            createNdkTasks()
        }

        createSplitResourcesTasks();
        createSplitAbiTasks();


        createPackagingTask(tasks, variantData)

        handleMicroApp()
    }

    private fun createAnchorTasks(variantData: ApkVariantOutputData) {
        createPreBuildTasks(variantData)
    }

    private fun createPreBuildTasks(variantData: ApkVariantOutputData) {
        variantData.preBuildTask = project.tasks.create("preBuild")
        val prepareDependenciesTask = project.tasks.create("prepareDependencies", PrepareDependenciesTask::class.java)

        variantData.prepareDependenciesTask = prepareDependenciesTask
        prepareDependenciesTask.dependsOn(variantData.preBuildTask)
    }

    private fun createCheckManifestTask() {}
    private fun createMergeAppManifestsTask() {}
    private fun createGenerateResValuesTask() {}
    private fun createRenderscriptTask() {}
    private fun createMergeResourcesTask() {}
    private fun createMergeAssetsTask() {}
    private fun createBuildConfigTask() {}
    private fun createPreprocessResourcesTask() {}
    private fun createProcessResTask(variantOutputData: ApkVariantOutputData) {
        val processAndroidResources = project.tasks.create("processResources2", ProcessAndroidResources::class.java)
        variantOutputData.processResourcesTask = processAndroidResources
    }

    private fun createProcessJavaResTask() {}
    private fun createAidlTask() {}
    private fun createJavaCompileTask() {
        val javaCompileTask = project.tasks.create("compileDebugJava", JavaCompile::class.java)
    }

    private fun createJarTask() {}

    /**
     * Creates the post-compilation tasks for the given Variant.
     *
     * These tasks create the dex file from the .class files, plus optional intermediary steps
     * like proguard and jacoco
     *
     * @param variantData the variant data.
     */
    private fun createPostCompilationTasks(variantData: ApkVariantOutputData) {
        val dexTask = project.tasks.create("dex", Dex::class.java)
        variantData.dexTask = dexTask

        maybeCreateProguardTasks(variantData)

        variantData.dexTask.dependsOn(variantData.obfuscationTask)
    }

    private fun maybeCreateProguardTasks(variantData: ApkVariantOutputData) {
        val proguardTask = project.tasks.create("proguard", AndroidProGuardTask::class.java)
        variantData.obfuscationTask = proguardTask

        proguardTask.configuration {
            val proguardFiles: MutableList<File> = mutableListOf()
            proguardFiles.add(File("proguard-android.txt"))
            proguardFiles
        }


        // libraryJars: the runtime jars. Do this in doFirst since the boot classpath isn't
        // available until the SDK is loaded in the prebuild task
        proguardTask.doFirst {

            //todo: remove this with really android.jar
            proguardTask.libraryjars("libs/android.jar")
            //            for (runtimeJar : getBootClasspathAsStrings()) {
//        }
        }

        proguardTask.injars("${project.buildDir}/libs/example.jar")
        proguardTask.outjars("${project.buildDir}/${FD_INTERMEDIATES}/example.jar")
    }

    private fun getBootClasspathAsStrings(project: Project) {
        project.configurations
//        var classpath: List<String> = mutableListOf()
    }

    private fun createNdkTasks() {}

    private fun createSplitAbiTasks() {}
    private fun createSplitResourcesTasks() {}
    private fun createPackagingTask(
        tasks: TaskContainer,
        variantOutputData: ApkVariantOutputData
    ) {
        val packageApp = project.tasks.create("package", PackageApplication::class.java)

        packageApp.dependsOn(variantOutputData.processResourcesTask)

        val shrink = createShrinkResourcesTask(variantOutputData)
        packageApp.dependsOn(shrink)

//        packageApp.convention
        var appTask: Task = packageApp

//        variantOutputData.assembleTask = createAssembleTask(variantOutputData)
//        variantOutputData.assembleTask!!.dependsOn(appTask)

    }

    private fun createShrinkResourcesTask(variantOutputData: ApkVariantOutputData): ShrinkResources {
        val task = project.tasks.create("shrinkResources", ShrinkResources::class.java)
        return task
    }

    /**
     * Configure variantData to generate embedded wear application.
     */
    private fun handleMicroApp() {

    }

    fun optionalDependsOn(main: Task, vararg dependencies: Task) {
        for (dependency in dependencies) {
            main.dependsOn(dependency)
        }

    }

}
