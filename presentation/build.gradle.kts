plugins {
    alias(libs.plugins.tving.android.library)
    alias(libs.plugins.tving.android.hilt)
}

android {
    namespace = "com.tving.presentation"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.viewModel.lifecycle)
}