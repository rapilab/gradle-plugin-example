pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = ("phodal-gradle-plugins")

include(":example")
includeBuild("plugin-build")
