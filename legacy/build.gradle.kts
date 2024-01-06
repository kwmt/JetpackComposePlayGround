plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
}

android {
    namespace = "net.kwmt27.jetpackcomposeplayground.legacy"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.espresso)
}
