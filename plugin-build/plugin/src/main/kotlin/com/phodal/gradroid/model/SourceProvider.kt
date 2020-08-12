package com.phodal.gradroid.model

import java.io.File

interface SourceProvider {
    fun getName(): String?
    fun getManifestFile(): File?
    fun getJavaDirectories(): Collection<File?>?
    fun getAssetsDirectories(): Collection<File?>?
    fun getResDirectories(): Collection<File?>?
    fun getResourcesDirectories(): Collection<File?>?
}