plugins {
    alias(libs.plugins.tving.android.library)
    alias(libs.plugins.tving.android.hilt)
}

android {
    namespace = "com.tving.presentation.common"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material3)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.viewModel.lifecycle)
    implementation(libs.bundles.androidx.ui.compose)
    debugImplementation(libs.bundles.androidx.ui.compose.debug)
}