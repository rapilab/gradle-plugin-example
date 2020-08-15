plugins {
//    java
//    id("com.phodal.gradroid.plugin")
    id("com.android.application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

//phodal {
//    pConfig {
//        applicationId = "com.phodal.gra"
//        message("phodal")
//        sdkVersion(12)
//    }
//}

dependencies {
//    implementation(gradleApi())
    implementation("net.sf.proguard:proguard-gradle:5.2.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
//    phodalImpl()
}