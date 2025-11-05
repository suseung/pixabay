plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "tving.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidlibrary") {
            id = "tving.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "tving.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("jvmHilt") {
            id = "tving.jvm.hilt"
            implementationClass = "JvmHiltConventionPlugin"
        }
        register("jvmLibrary") {
            id = "tving.jvm.library"
            implementationClass = "JvmLibraryPlugin"
        }
        register("androidFeature") {
            id = "tving.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}