package com.phodal.gradroid.plugin

import com.phodal.gradroid.internal.api.AndroidSourceSet
import com.phodal.gradroid.internal.api.DefaultAndroidSourceSet
import org.gradle.api.NamedDomainObjectFactory
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

class AndroidSourceSetFactory(var instantiator: Instantiator, var project: ProjectInternal) : NamedDomainObjectFactory<AndroidSourceSet> {
    override fun create(name: String): AndroidSourceSet {
        return instantiator.newInstance(DefaultAndroidSourceSet::class.java, name, project)
    }
}
