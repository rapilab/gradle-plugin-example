package com.phodal.gradroid.plugin

import org.gradle.api.internal.project.ProjectInternal
import org.gradle.internal.reflect.Instantiator

open class BaseExtension(var project: ProjectInternal,var instantiator: Instantiator) {
}
