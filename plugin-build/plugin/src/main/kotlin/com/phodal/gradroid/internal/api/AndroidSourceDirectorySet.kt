package com.phodal.gradroid.internal.api

import org.gradle.api.tasks.util.PatternFilterable

interface AndroidSourceDirectorySet: PatternFilterable {
    fun getFilter(): PatternFilterable

}
