package com.phodal.gradroid.internal.api

import com.phodal.gradroid.model.SourceProvider
import org.gradle.api.Project
import java.io.File

open class DefaultAndroidSourceSet(name: String, project: Project) : AndroidSourceSet, SourceProvider {

    private val manifestFile: File? = null
    private val javaDirs: Collection<File>? = null
    private val resourcesDirs: Collection<File>? = null
    private val resDirs: Collection<File>? = null
    private val assetsDirs: Collection<File>? = null

    override fun getName(): String? {
        TODO("Not yet implemented")
    }

    override fun getManifestFile(): File? {
        TODO("Not yet implemented")
    }

    override fun getJavaDirectories(): Collection<File?>? {
        TODO("Not yet implemented")
    }

    override fun getAssetsDirectories(): Collection<File?>? {
        TODO("Not yet implemented")
    }

    override fun getResDirectories(): Collection<File?>? {
        TODO("Not yet implemented")
    }

    override fun getResourcesDirectories(): Collection<File?>? {
        TODO("Not yet implemented")
    }

}