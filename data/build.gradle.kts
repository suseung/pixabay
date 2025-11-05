plugins {
    alias(libs.plugins.tving.android.library)
    alias(libs.plugins.tving.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.tving.data"
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit2)
    implementation(libs.bundles.okhttp3)

    kapt(libs.androidx.room.compiler)
}
