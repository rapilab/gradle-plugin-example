package com.phodal.gradroid.internal.api

import groovy.lang.Closure
import org.gradle.api.Project
import org.gradle.api.file.FileTreeElement
import org.gradle.api.specs.Spec
import org.gradle.api.tasks.util.PatternFilterable
import org.gradle.api.tasks.util.PatternSet

class DefaultAndroidSourceDirectorySet(val javaSrcDisplayName: String, val project: Project) : AndroidSourceDirectorySet {
    private val filter = PatternSet()

    override fun getFilter(): PatternFilterable {
        return filter
    }


    override fun getIncludes(): Set<String> {
        return filter.includes
    }

    override fun getExcludes(): Set<String> {
        return filter.excludes
    }

    override fun setIncludes(includes: Iterable<String>): PatternFilterable {
        filter.setIncludes(includes)
        return this
    }

    override fun setExcludes(excludes: Iterable<String>): PatternFilterable {
        filter.setExcludes(excludes)
        return this
    }

    override fun include(vararg includes: String): PatternFilterable {
        filter.include(*includes)
        return this
    }

    override fun include(includes: Iterable<String>): PatternFilterable {
        filter.include(includes)
        return this
    }

    override fun include(includeSpec: Spec<FileTreeElement>): PatternFilterable {
        filter.include(includeSpec)
        return this
    }

    override fun include(includeSpec: Closure<*>): PatternFilterable {
        filter.include(includeSpec)
        return this
    }

    override fun exclude(excludes: Iterable<String>): PatternFilterable {
        filter.exclude(excludes)
        return this
    }

    override fun exclude(vararg excludes: String): PatternFilterable {
        filter.exclude(*excludes)
        return this
    }

    override fun exclude(excludeSpec: Spec<FileTreeElement>): PatternFilterable {
        filter.exclude(excludeSpec)
        return this
    }

    override fun exclude(excludeSpec: Closure<*>): PatternFilterable {
        filter.exclude(excludeSpec)
        return this
    }
}