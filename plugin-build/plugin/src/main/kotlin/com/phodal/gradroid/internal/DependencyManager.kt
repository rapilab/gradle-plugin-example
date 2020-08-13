package com.phodal.gradroid.internal

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.ModuleVersionIdentifier
import org.gradle.api.artifacts.ResolvedArtifact

class DependencyManager(val project: Project, val extraModelInfo: ExtraModelInfo) {
    fun resolveDependencyForConfig(deps: VariantDependencies) {
        var compileClasspath: Configuration = deps.compileConfiguration
        var packageClasspath: Configuration = deps.packageConfiguration


        // TODO - defer downloading until required -- This is hard to do as we need the info to build the variant config.
        val artifacts: Map<ModuleVersionIdentifier, List<ResolvedArtifact>> = hashMapOf()

        collectArtifacts(compileClasspath, artifacts)
        collectArtifacts(packageClasspath, artifacts)

        // --- Handle the external/module dependencies ---
        // keep a map of modules already processed so that we don't go through sections of the
        // graph that have been seen elsewhere.
//        val foundLibraries: Map<ModuleVersionIdentifier, List<LibInfo>> = hashMapOf()
//        val foundJars: Map<ModuleVersionIdentifier, List<JarInfo>> = hashMapOf()

    }

    private fun collectArtifacts(
        compileClasspath: Configuration,
        artifacts: Map<ModuleVersionIdentifier, List<ResolvedArtifact>>
    ) {

    }
}
