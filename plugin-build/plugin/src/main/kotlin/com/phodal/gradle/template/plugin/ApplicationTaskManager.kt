package com.phodal.gradle.template.plugin

import com.phodal.gradle.template.plugin.internal.DependencyManager
import com.phodal.gradle.template.plugin.internal.tasks.PackageApplication
import com.phodal.gradle.template.plugin.internal.tasks.ProcessAndroidResources
import com.phodal.gradle.template.plugin.internal.tasks.ShrinkResources
import com.phodal.gradle.template.plugin.internal.tasks.TaskManager
import com.phodal.gradle.template.plugin.internal.variant.ApkVariantOutputData
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.compile.JavaCompile

class ApplicationTaskManager(val project: Project, dependencyManager: DependencyManager) :
    TaskManager {
    fun createMockableJarTask() {

    }

    fun createAssembleTask() {

    }

    fun createTasksForVariantData(
        tasks: TaskContainer,
        apkVariantOutputData: ApkVariantOutputData
    ) {
        createAnchorTasks()
        createCheckManifestTask()

        createMergeAppManifestsTask()
        createGenerateResValuesTask()
        createRenderscriptTask()

        createMergeResourcesTask()
        createMergeAssetsTask()

        createBuildConfigTask()
        createPreprocessResourcesTask()
        createProcessResTask(apkVariantOutputData)
        createProcessJavaResTask()
        createAidlTask()

        // compile java
        createJavaCompileTask()
        createJarTask()
        createPostCompilationTasks()

        val is_ndk = false
        if (is_ndk) {
            createNdkTasks()
        }

        createSplitResourcesTasks();
        createSplitAbiTasks();


        createPackagingTask(tasks, apkVariantOutputData)

        handleMicroApp()
    }

    private fun createAnchorTasks() {}
    private fun createCheckManifestTask() {}
    private fun createMergeAppManifestsTask() {}
    private fun createGenerateResValuesTask() {}
    private fun createRenderscriptTask() {}
    private fun createMergeResourcesTask() {}
    private fun createMergeAssetsTask() {}
    private fun createBuildConfigTask() {}
    private fun createPreprocessResourcesTask() {}
    private fun createProcessResTask(variantOutputData: ApkVariantOutputData) {
        val processAndroidResources = project.tasks.create("processResources", ProcessAndroidResources::class.java)
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
    private fun createPostCompilationTasks() {

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

        createShrinkResourcesTask(variantOutputData)
    }

    private fun createShrinkResourcesTask(variantOutputData: ApkVariantOutputData) {
        project.tasks.create("shrinkResources", ShrinkResources::class.java);
    }

    /**
     * Configure variantData to generate embedded wear application.
     */
    private fun handleMicroApp() {

    }
}
