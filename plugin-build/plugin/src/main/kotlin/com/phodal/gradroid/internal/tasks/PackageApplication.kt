package com.phodal.gradroid.internal.tasks

import org.gradle.api.tasks.*
import java.io.File

open class PackageApplication : IncrementalTask() {
//    @InputFile
//    lateinit var resourceFile: File
//
//    @InputDirectory
//    lateinit var dexFolder: File
//
//    @InputFiles
//    lateinit var dexedLibraries: Collection<File>
//
//    @InputDirectory
//    @Optional
//    lateinit var javaResourceDir: File
//
//    lateinit var jniFolders: Set<File>
//
//    @OutputFile
//    lateinit var outputFile: File
//
//    @Input
//    @Optional
//    lateinit var abiFilters: Set<String>


    init {
        this.outputs.upToDateWhen {
            logger.debug("Install task is always run.");
            false;
        }
    }

    @TaskAction
    fun perform() {
        println("Content printed to file successfully")
    }

    override fun doFullTaskAction() {
        getBuilder()?.packageApk()
    }
}
