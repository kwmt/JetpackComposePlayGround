plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
}
android {
    namespace = "net.kwmt27.jetpackcomposeplayground.feature.samples"

    flavorDimensions += listOf("default")
    productFlavors {
        register("exposed") {
            dimension = "default"
        }
        register("paid") {
            dimension = "default"
        }
        register("free") {
            dimension = "default"
        }
    }
}


dependencies {
    implementation(projects.core.ui)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.espresso)

    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    implementation("io.my-company:my-library:1.0")
}
