package com.phodal.gradroid.internal

import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

open class ProductFlavor(var name: String, project: Project, instantiator: Instantiator) {
}
