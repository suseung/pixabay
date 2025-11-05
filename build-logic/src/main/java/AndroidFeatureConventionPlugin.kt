import com.tving.convention.debugImplementation
import com.tving.convention.implementation
import com.tving.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dongsani.android.library")
            }

            dependencies {
                implementation(project(":designSystem"))
                implementation(project(":domain"))

                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.material3)
                implementation(libs.coil.compose)

                implementation(libs.androidx.hilt.navigation.compose)
                implementation(libs.bundles.androidx.ui.compose)
                debugImplementation(libs.bundles.androidx.ui.compose.debug)
                implementation(platform(libs.androidx.compose.bom))
            }
        }
    }
}
