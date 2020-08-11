# Android Gradle Plugin Research


Android Gradle Plugin Code: [The Android Gradle Plugin](https://android.googlesource.com/platform/tools/base/+/studio-master-dev/build-system/README.md)

## Process

1. used `com.android.application` or `com.android.library` in project

```groovy
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
```

2.


## Documents

### Application Build logs

```bash
Executing tasks: [assemble] in project /Users/fdhuang/works/fework/MyApplication

Starting Gradle Daemon...
Gradle Daemon started in 1 s 260 ms
> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:compileDebugAidl NO-SOURCE
> Task :app:generateDebugBuildConfig UP-TO-DATE
> Task :app:compileDebugRenderscript NO-SOURCE
> Task :app:generateDebugResValues UP-TO-DATE
> Task :app:generateDebugResources UP-TO-DATE
> Task :app:mergeDebugResources UP-TO-DATE
> Task :app:createDebugCompatibleScreenManifests UP-TO-DATE
> Task :app:extractDeepLinksDebug UP-TO-DATE
> Task :app:processDebugManifest UP-TO-DATE
> Task :app:javaPreCompileDebug UP-TO-DATE
> Task :app:mergeDebugShaders UP-TO-DATE
> Task :app:compileDebugShaders NO-SOURCE
> Task :app:generateDebugAssets UP-TO-DATE
> Task :app:mergeDebugAssets UP-TO-DATE
> Task :app:processDebugJavaRes NO-SOURCE
> Task :app:checkDebugDuplicateClasses UP-TO-DATE
> Task :app:processDebugResources UP-TO-DATE
> Task :app:compileDebugKotlin UP-TO-DATE
> Task :app:compileDebugJavaWithJavac UP-TO-DATE
> Task :app:compileDebugSources UP-TO-DATE
> Task :app:mergeDebugJavaResource UP-TO-DATE
> Task :app:dexBuilderDebug UP-TO-DATE
> Task :app:desugarDebugFileDependencies UP-TO-DATE
> Task :app:mergeDebugJniLibFolders UP-TO-DATE
> Task :app:mergeDebugNativeLibs UP-TO-DATE
> Task :app:stripDebugDebugSymbols NO-SOURCE
> Task :app:validateSigningDebug UP-TO-DATE
> Task :app:preReleaseBuild UP-TO-DATE
> Task :app:compileReleaseAidl NO-SOURCE
> Task :app:compileReleaseRenderscript NO-SOURCE
> Task :app:generateReleaseBuildConfig
> Task :app:generateReleaseResValues
> Task :app:generateReleaseResources
> Task :app:createReleaseCompatibleScreenManifests
> Task :app:extractDeepLinksRelease
> Task :app:processReleaseManifest
> Task :app:mergeReleaseResources
> Task :app:processReleaseResources
> Task :app:compileReleaseKotlin
> Task :app:mergeExtDexDebug UP-TO-DATE
> Task :app:mergeDexDebug UP-TO-DATE
> Task :app:packageDebug UP-TO-DATE
> Task :app:assembleDebug UP-TO-DATE
> Task :app:javaPreCompileRelease
> Task :app:compileReleaseJavaWithJavac
> Task :app:compileReleaseSources
> Task :app:prepareLintJar
> Task :app:checkReleaseDuplicateClasses
> Task :app:lintVitalRelease
> Task :app:dexBuilderRelease
> Task :app:desugarReleaseFileDependencies
> Task :app:mergeReleaseShaders
> Task :app:compileReleaseShaders NO-SOURCE
> Task :app:generateReleaseAssets UP-TO-DATE
> Task :app:mergeReleaseAssets
> Task :app:processReleaseJavaRes NO-SOURCE
> Task :app:collectReleaseDependencies
> Task :app:sdkReleaseDependencyData
> Task :app:mergeReleaseJniLibFolders
> Task :app:mergeReleaseJavaResource
> Task :app:mergeReleaseNativeLibs
> Task :app:stripReleaseDebugSymbols NO-SOURCE
> Task :app:mergeExtDexRelease
> Task :app:mergeDexRelease
> Task :app:packageRelease
> Task :app:assembleRelease
> Task :app:assemble

BUILD SUCCESSFUL in 1m 58s
47 actionable tasks: 25 executed, 22 up-to-date

Build Analyzer results available
```
