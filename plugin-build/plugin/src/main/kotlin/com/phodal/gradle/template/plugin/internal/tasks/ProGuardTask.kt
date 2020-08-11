package com.phodal.gradle.template.plugin.internal.tasks

import org.gradle.api.DefaultTask
import java.util.*

open class ProGuardTask: DefaultTask() {
    private val inJarFiles: List<*> = ArrayList<Any?>()
    private val inJarFilters: List<*> = ArrayList<Any?>()
    private val outJarFiles: List<*> = ArrayList<Any?>()
    private val outJarFilters: List<*> = ArrayList<Any?>()
    private val inJarCounts: List<*> = ArrayList<Any?>()
    private val libraryJarFiles: List<*> = ArrayList<Any?>()
    private val libraryJarFilters: List<*> = ArrayList<Any?>()
    private val configurationFiles: List<*> = ArrayList<Any?>()

    // Accumulated configuration.
//    private val configuration: Configuration = Configuration()

}
