package com.phodal.gradroid.plugin

import com.phodal.gradroid.internal.ProductFlavor
import com.phodal.gradroid.internal.api.AndroidSourceSet
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

abstract class BaseExtension(var project: ProjectInternal, private var instantiator: Instantiator) {
    val defaultConfig: ProductFlavor = instantiator.newInstance(ProductFlavor::class.java, "main", project, instantiator)
    var sourceSetsContainer: NamedDomainObjectContainer<AndroidSourceSet> = project.container(AndroidSourceSet::class.java, AndroidSourceSetFactory(instantiator, project))

    init {
        sourceSetsContainer.whenObjectAdded {

        }
        sourceSetsContainer.create(defaultConfig.name)
    }



    fun getSourceSets(): NamedDomainObjectContainer<AndroidSourceSet> {
        return sourceSetsContainer
    }

}