plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
    alias(libs.plugins.com.github.kwmt.publish)
}

android {
    namespace = "com.github.kwmt.slide"
    val defaultDimension = PublishPluginExtension.DEFAUlT_DIEMNSION
    flavorDimensions += listOf(defaultDimension)
    productFlavors {
        register("develop") {
            dimension = defaultDimension
        }
        register("staging") {
            dimension = defaultDimension
        }
        register("production") {
            dimension = defaultDimension
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.espresso)

    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.coil.compose)
    implementation(libs.coil.gif)
    implementation(libs.accompanist.webview)
}
