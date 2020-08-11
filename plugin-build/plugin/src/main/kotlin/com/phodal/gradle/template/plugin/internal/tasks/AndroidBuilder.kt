package com.phodal.gradle.template.plugin.internal.tasks

class AndroidBuilder {
    fun packageApk() {

    }

    // todo: add aapt process
    fun processResources(aaptCommand: AaptPackageProcessBuilder) {
        aaptCommand.build()


        // First pass processing the libraries, collecting them by packageName,
        // and ignoring the ones that have the same package name as the application
        // (since that R class was already created).
        val appPackageName: String = aaptCommand.getPackageForR()
    }

}
