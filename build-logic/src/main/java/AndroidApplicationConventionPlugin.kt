import com.android.build.api.dsl.ApplicationExtension
import com.tving.convention.TvingConfig
import com.tving.convention.configureAndroidCompose
import com.tving.convention.configureKotlinAndroid
import com.tving.convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig.apply {
                    applicationId = TvingConfig.applicationId
                    minSdk = TvingConfig.minSdk
                    targetSdk = TvingConfig.targetSdk
                    versionCode = TvingConfig.versionCode
                    versionName = TvingConfig.versionName

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                configureAndroidCompose(this)

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                        excludes += "META-INF/gradle/incremental.annotation.processors"
                    }
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                }
            }

            dependencies {
                implementation(project(":data"))
                implementation(project(":designSystem"))
                implementation(project(":domain"))
            }
        }
    }
}
