plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
}
android {
    namespace = "net.kwmt27.jetpackcomposeplayground.core.ui"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.google.material)
    testApi(libs.junit)
    androidTestApi(libs.androidx.test.junit)
    androidTestApi(libs.espresso)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
}
