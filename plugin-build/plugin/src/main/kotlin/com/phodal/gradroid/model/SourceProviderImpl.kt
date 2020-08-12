package com.phodal.gradroid.model

import java.io.File

class SourceProviderImpl : SourceProvider {
    private val name: String? = null
    private val manifestFile: File? = null
    private val javaDirs: Collection<File>? = null
    private val resourcesDirs: Collection<File>? = null
    private val resDirs: Collection<File>? = null
    private val assetsDirs: Collection<File>? = null

    override fun getName(): String? {
        return name
    }

    override fun getManifestFile(): File? {
        return manifestFile
    }

    override fun getJavaDirectories(): Collection<File?>? {
        return javaDirs
    }

    override fun getAssetsDirectories(): Collection<File?>? {
        return assetsDirs
    }

    override fun getResDirectories(): Collection<File?>? {
        return resDirs
    }

    override fun getResourcesDirectories(): Collection<File?>? {
        return resourcesDirs
    }

}