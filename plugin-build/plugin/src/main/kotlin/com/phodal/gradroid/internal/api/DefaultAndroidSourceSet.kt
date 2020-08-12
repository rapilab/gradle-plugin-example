package com.phodal.gradroid.internal.api

import com.phodal.gradroid.model.SourceProvider
import org.gradle.api.Project
import org.gradle.util.GUtil
import java.io.File

open class DefaultAndroidSourceSet(private val name: String, project: Project) : AndroidSourceSet, SourceProvider {
    private var manifestFile: File? = null
    private var javaDirs: Collection<File>? = null
    private var resourcesDirs: Collection<File>? = null
    private var resDirs: Collection<File>? = null
    private var assetsDirs: Collection<File>? = null

    private var javaSource: AndroidSourceDirectorySet
    private var displayName: String = GUtil.toWords(name)

    init {
        val javaSrcDisplayName = String.format("%s Java source", displayName)

        javaSource = DefaultAndroidSourceDirectorySet(javaSrcDisplayName, project)
        javaSource.getFilter().include("**/*.java")
//
//        val javaResourcesDisplayName = String.format("%s Java resources", displayName)
//        javaResources = DefaultAndroidSourceDirectorySet(javaResourcesDisplayName, project)
//        javaResources.getFilter().exclude("**/*.java")
    }

    override fun getName(): String? {
        return name
    }

    override fun getManifestFile(): File? {
        return null
    }

    override fun getJavaDirectories(): Collection<File?>? {
        return null
    }

    override fun getAssetsDirectories(): Collection<File?>? {
        return null
    }

    override fun getResDirectories(): Collection<File?>? {
        return null
    }

    override fun getResourcesDirectories(): Collection<File?>? {
        return null
    }

}