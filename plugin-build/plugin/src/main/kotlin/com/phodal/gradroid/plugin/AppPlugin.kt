package com.phodal.gradroid.plugin

import com.phodal.gradroid.ApplicationTaskManager
import com.phodal.gradroid.VariantManager
import com.phodal.gradroid.internal.DependencyManager
import com.phodal.gradroid.internal.ExtraModelInfo
import com.phodal.gradroid.internal.ModelBuilder
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.internal.reflect.Instantiator
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry
import javax.inject.Inject

const val EXTENSION_NAME = "phodalConfig"
const val TASK_NAME = "Samples"

abstract class AppPlugin @Inject constructor(private var instantiator: Instantiator, private var registry: ToolingModelBuilderRegistry) : Plugin<Project> {
    private lateinit var taskManager: ApplicationTaskManager
    private lateinit var project: Project
    private lateinit var extraModelInfo: ExtraModelInfo
    private lateinit var variantManager: VariantManager

    init {
        verifyRetirementAge()
    }

    private fun verifyRetirementAge() {
    }

    override fun apply(project: Project) {
//        // Add the 'template' extension object
//        val extension = project.extensions.create(EXTENSION_NAME, TemplateExtension::class.java, project)
//        // Add a task that uses configuration from the extension object
//        project.tasks.register(TASK_NAME, TemplateExampleTask::class.java) {
//            it.tag.set(extension.tag)
//            it.message.set(extension.message)
//            it.outputFile.set(extension.outputFile)
//        }

        this.project = project

        configureProject()

        createExtension()

        createTasks()
    }

    private fun configureProject() {
        extraModelInfo = ExtraModelInfo(project)
        project.apply { JavaBasePlugin::class.java }
//        project.apply { JacocoPlugin::class.java }

//        project.tasks.getByName("assemble").description = "Assembles all variants of all applications and secondary packages."
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
        project.extensions.create("phodal", BaseExtension::class.java, project, instantiator)

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
//        if (project.plugins.hasPlugin(JavaPlugin::class.java)) {
//            throw GradleException(
//                "The 'java' plugin has been applied, but it is not compatible with the Android plugins."
//            )
//        }

        taskManager.createMockableJarTask()
        variantManager.createAndroidTasks()
    }

    private fun ensureTargetSetup() {
    }
}
