package com.phodal.gradle.template.plugin.internal.tasks

import java.io.File

class AaptPackageProcessBuilder(sourceOutputDir: File) {
    fun build() {
        val builder = ProcessInfoBuilder()
        builder.addEnvironments()

        builder.setExecutable()

        builder.addArgs("package")

        builder.addArgs("-f")
        builder.addArgs("--no-crunch")
        //...
        builder.createProcess()
    }

    fun getPackageForR(): String {
        return ""
    }

}
