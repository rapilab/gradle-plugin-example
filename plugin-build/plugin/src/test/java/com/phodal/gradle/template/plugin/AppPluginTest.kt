package com.phodal.gradle.template.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class AppPluginTest {

    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.phodal.gradle.template.plugin")

        assert(project.tasks.getByName("templateExample") is TemplateExampleTask)
    }
}
