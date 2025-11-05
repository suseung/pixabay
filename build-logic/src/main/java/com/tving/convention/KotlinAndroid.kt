package com.tving.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.collections.plus

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        defaultConfig {
            compileSdk = TvingConfig.compileSdk
            minSdk = TvingConfig.minSdk
        }

        compileOptions {
            sourceCompatibility = TvingConfig.javaCompileTarget
            targetCompatibility = TvingConfig.javaCompileTarget
        }

        buildFeatures {
            viewBinding = true
            compose = true
        }
    }

    configureKotlin()
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = TvingConfig.javaCompileTarget.toString()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
            )
        }
    }
}
