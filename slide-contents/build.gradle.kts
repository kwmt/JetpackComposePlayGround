plugins {
    alias(libs.plugins.jetpackcomposeplayground.android.library)
    alias(libs.plugins.jetpackcomposeplayground.android.library.compose)
}
android {
    namespace = "net.kwmt27.jetpackcomposeplayground.slide.contents"
}

dependencies {
    implementation(projects.core.ui)
    api(projects.slide)
    implementation(projects.feature.samples)
}
