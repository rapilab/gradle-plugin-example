package com.ncorti.kotlin.gradle.template.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin

const val EXTENSION_NAME = "templateExampleConfig"
const val TASK_NAME = "templateExample"

abstract class TemplatePlugin : Plugin<Project> {
    private lateinit var project: Project

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

    private fun createTasks() {
        project.apply { JavaBasePlugin::class.java }
    }

    private fun createExtension() {

    }

    private fun configureProject() {

    }
}
