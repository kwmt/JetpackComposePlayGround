plugins {
    id("net.kwmt27.jetpackcomposeplayground.library")
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
