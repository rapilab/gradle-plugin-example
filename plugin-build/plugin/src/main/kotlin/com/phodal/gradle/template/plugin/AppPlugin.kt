package com.phodal.gradle.template.plugin

import com.phodal.gradle.template.plugin.internal.DependencyManager
import com.phodal.gradle.template.plugin.internal.ExtraModelInfo
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.TaskContainer
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry
import javax.inject.Inject

const val EXTENSION_NAME = "phodalConfig"
const val TASK_NAME = "Samples"

abstract class AppPlugin : Plugin<Project> {
    private lateinit var taskManager: ApplicationTaskManager
    private lateinit var project: Project
    private lateinit var extraModelInfo: ExtraModelInfo
    private var registry: ToolingModelBuilderRegistry
    protected lateinit var variantManager: VariantManager

    @Inject
    constructor(registry: ToolingModelBuilderRegistry) {
        this.registry = registry
    }

    override fun apply(project: Project) {
        // Add the 'template' extension object
        val extension = project.extensions.create(EXTENSION_NAME, TemplateExtension::class.java, project)

        this.project = project

        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME, TemplateExampleTask::class.java) {
            it.tag.set(extension.tag)
            it.message.set(extension.message)
            it.outputFile.set(extension.outputFile)
        }

        configureProject()

        createExtension()

        createTasks()
    }

    private fun configureProject() {
        extraModelInfo = ExtraModelInfo(project)
        project.apply { JavaBasePlugin::class.java }
//        project.apply { JacocoPlugin::class.java }

        project.gradle.buildFinished {
            // clear cache
        }

        project.gradle.taskGraph.whenReady {
            for (task in it.allTasks) {
                // load cache
            }
        }
    }

    private fun createExtension() {
        val dependencyManager = DependencyManager(project, extraModelInfo)
        taskManager = ApplicationTaskManager(project, dependencyManager)
        variantManager = VariantManager(project, taskManager)

        val modelBuilder = ModelBuilder(taskManager, variantManager)
        registry.register(modelBuilder)
    }

    private fun createTasks() {
        project.afterEvaluate {
            ensureTargetSetup()
            createAndroidTasks(false)
        }
    }

    private fun createAndroidTasks(force: Boolean) {
        if (project.plugins.hasPlugin(JavaPlugin::class.java)) {
            throw GradleException(
                "The 'java' plugin has been applied, but it is not compatible with the Android plugins."
            )
        }

        taskManager.createMockableJarTask()
        variantManager.createAndroidTasks()
    }

    private fun ensureTargetSetup() {
        val tasks = project.tasks
        println(".............................................")
        println(tasks)
        createTasksForVariantData(tasks)
    }

    private fun createTasksForVariantData(tasks: TaskContainer) {
        createAssembleTaskForVariantData(tasks)
        taskManager.createTasksForVariantData(tasks)
    }

    private fun createAssembleTaskForVariantData(tasks: TaskContainer) {
        taskManager.createAssembleTask()
    }

}
