package com.phodal.gradroid.internal

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.ModuleVersionIdentifier
import org.gradle.api.artifacts.ResolvedArtifact
import org.gradle.internal.impldep.org.bouncycastle.asn1.x500.style.RFC4519Style.name

class DependencyManager(val project: Project, val extraModelInfo: ExtraModelInfo) {
    fun resolveDependencyForConfig(deps: VariantDependencies) {
        val compile: Configuration  = project.configurations.maybeCreate("_${name}Compile")

        val compileConfigs = hashSetOf<Configuration>()
        compile.setExtendsFrom(compileConfigs)

        val compileClasspath: Configuration = compile

        val artifacts: Map<ModuleVersionIdentifier, List<ResolvedArtifact>> = hashMapOf()
    }

    private fun collectArtifacts(
        compileClasspath: Configuration,
        artifacts: Map<ModuleVersionIdentifier, List<ResolvedArtifact>>
    ) {

    }
}
