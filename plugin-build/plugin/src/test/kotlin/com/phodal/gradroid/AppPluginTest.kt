package com.phodal.gradroid

import com.phodal.gradroid.plugin.TemplateExampleTask
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class AppPluginTest {

    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.phodal.gradroid.plugin")

        assert(project.tasks.getByName("Samples") is TemplateExampleTask)
    }
}
