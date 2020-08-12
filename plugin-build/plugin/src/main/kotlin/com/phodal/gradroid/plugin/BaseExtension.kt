package com.phodal.gradroid.plugin

import com.phodal.gradroid.internal.ProductFlavor
import com.phodal.gradroid.internal.api.AndroidSourceSet
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

abstract class BaseExtension {
    var project: ProjectInternal
    var instantiator: Instantiator
    val defaultConfig: ProductFlavor


    var sourceSetsContainer: NamedDomainObjectContainer<AndroidSourceSet>

    constructor(project: ProjectInternal, instantiator: Instantiator) {
        this.project = project
        this.instantiator = instantiator

        defaultConfig = instantiator.newInstance(ProductFlavor::class.java, "main", project, instantiator)

        this.sourceSetsContainer = project.container(AndroidSourceSet::class.java, AndroidSourceSetFactory(instantiator, project))

        sourceSetsContainer.whenObjectAdded {


        }

        sourceSetsContainer.create(defaultConfig.name)
    }



    fun getSourceSets(): NamedDomainObjectContainer<AndroidSourceSet> {
        return sourceSetsContainer
    }

}