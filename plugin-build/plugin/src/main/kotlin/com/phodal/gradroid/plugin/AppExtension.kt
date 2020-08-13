package com.phodal.gradroid.plugin

import com.phodal.gradroid.PConfig
import org.gradle.api.Action
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

open class AppExtension(project: ProjectInternal, var instantiator: Instantiator) : BaseExtension(project, instantiator) {
    var pConfig: PConfig = instantiator.newInstance(PConfig::class.java, "name")

    fun pConfig(action: Action<in PConfig>) {
        action.execute(pConfig);
    }
}