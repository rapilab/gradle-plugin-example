package com.phodal.gradle.template.plugin.internal.tasks

import org.gradle.api.Task
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.impldep.org.eclipse.jgit.annotations.NonNull
import org.jetbrains.annotations.Nullable
import proguard.ParseException
import proguard.gradle.ProGuardTask
import java.io.File
import java.io.IOException

open class AndroidProGuardTask: ProGuardTask() {
    /**
     * resulting obfuscation mapping file.
     */
    @Nullable
    @InputFile
    @Optional
    var mappingFile: File? = null

    /**
     * if this is a test related proguard task, this will point to tested application mapping file
     * which can be absent in case the tested application did not request obfuscation.
     */
    @Nullable
    @InputFile
    @Optional
    var testedAppMappingFile: File? = null

    @Throws(ParseException::class)
    override fun printmapping(printMapping: Any?) {
        mappingFile = printMapping as File?
        super.printmapping(printMapping)
    }

    @Throws(ParseException::class)
    override fun applymapping(applyMapping: Any?) {
        testedAppMappingFile = applyMapping as File?
    }

    open fun get(): File? {
        return mappingFile
    }

    @NonNull
    open fun getTask(): Task? {
        return this
    }

    @TaskAction
    @Throws(ParseException::class, IOException::class)
    override fun proguard() {
        // only set the tested application mapping file if it exists (it must at this point or that
        // means the tested application did not request obfuscation).
        if (testedAppMappingFile != null && testedAppMappingFile!!.exists()) {
            super.applymapping(testedAppMappingFile)
        }

        super.proguard()
    }
}
