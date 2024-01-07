plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
}
android {
    namespace = "net.kwmt27.jetpackcomposeplayground.core.ui"
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
}
