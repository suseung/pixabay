package com.tving.convention

import org.gradle.api.JavaVersion

object TvingConfig {
    const val applicationId = "com.tving.assignment"
    const val minSdk = 28
    const val targetSdk = 35
    const val compileSdk = 35
    val javaCompileTarget = JavaVersion.VERSION_1_8
    val versionCode = 1
    val versionName = "1.0"
}
