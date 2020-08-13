package com.phodal.gradroid.plugin

import com.phodal.gradroid.PConfig
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

open class AppExtension(project: ProjectInternal, var instantiator: Instantiator) : BaseExtension(project, instantiator) {
    var pConfig:  NamedDomainObjectContainer<PConfig>

    init {
        this.pConfig = project.container(PConfig::class.java, PConfigFactory(instantiator))
    }
}
