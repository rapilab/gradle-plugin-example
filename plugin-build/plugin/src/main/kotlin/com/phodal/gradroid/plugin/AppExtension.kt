package com.phodal.gradroid.plugin

import com.phodal.gradroid.PConfig
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

open class AppExtension(project: ProjectInternal, instantiator: Instantiator, config: PConfig) : BaseExtension(project, instantiator) {

}
