package com.phodal.gradle.template.plugin

import com.phodal.gradle.template.plugin.internal.DependencyManager
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer

class ApplicationTaskManager(val project: Project, dependencyManager: DependencyManager) {
    fun createMockableJarTask() {

    }

    fun createAssembleTask() {

    }

    fun createTasksForVariantData(tasks: TaskContainer) {
        createAnchorTasks()
        createCheckManifestTask()

        createMergeAppManifestsTask()
        createGenerateResValuesTask()
        createRenderscriptTask()
        createMergeResourcesTask()
        createMergeAssetsTask()
        createBuildConfigTask()
        createPreprocessResourcesTask()
        createProcessResTask()
        createProcessJavaResTask()
        createAidlTask()

        createJavaCompileTask()
        createJarTask()
        createPostCompilationTasks()

        val is_ndk = false
        if (is_ndk) {
            createNdkTasks()
        }

        createSplitResourcesTasks();
        createSplitAbiTasks();


        createPackagingTask(tasks)

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
    private fun createProcessResTask() {}
    private fun createProcessJavaResTask() {}
    private fun createAidlTask() {}
    private fun createJavaCompileTask() {}
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
    private fun createPackagingTask(tasks: TaskContainer) {
        val packageApp = project.tasks.create("package", PackageApplication::class.java)
        packageApp.run {  }
    }

    /**
     * Configure variantData to generate embedded wear application.
     */
    private fun handleMicroApp() {

    }
}
