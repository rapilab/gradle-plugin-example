plugins {
    java
    id("com.phodal.gradroid.plugin")
}

//phodalConfig {
//    message.set("Just trying this gradle plugin...")
//}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

phodal {
    pConfig {
        message("phodal")
        sdkVersion(12)
    }
}

dependencies {
//    implementation(kotlin("stdlib-jdk7"))
//    implementation(gradleApi())
    implementation("net.sf.proguard:proguard-gradle:5.2.1")
}