package com.phodal.gradle.template.plugin.internal.tasks

import org.gradle.api.tasks.*
import java.io.File

open class PackageApplication : IncrementalTask() {
    @InputFile
    lateinit var resourceFile: File

    @InputDirectory
    lateinit var dexFolder: File

    @InputFiles
    lateinit var dexedLibraries: Collection<File>

    @InputDirectory
    @Optional
    lateinit var javaResourceDir: File

    lateinit var jniFolders: Set<File>

    @OutputFile
    lateinit var outputFile: File

    @Input
    @Optional
    lateinit var abiFilters: Set<String>

    @TaskAction
    fun perform() {
        println("Content printed to file successfully")
    }

    override fun doFullTaskAction() {
        getBuilder()?.packageApk()
    }
}
