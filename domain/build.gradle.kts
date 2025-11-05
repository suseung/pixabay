plugins {
    alias(libs.plugins.tving.jvm.library)
    alias(libs.plugins.tving.jvm.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
