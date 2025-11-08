plugins {
    alias(libs.plugins.tving.android.feature)
    alias(libs.plugins.tving.android.hilt)
}

android {
    namespace = "com.tving.presentation.home"
}

dependencies {
    implementation(libs.bundles.exoplayer)
}
