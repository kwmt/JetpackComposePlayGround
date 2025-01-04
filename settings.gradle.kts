import java.net.URI

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
//        mavenLocal()
        maven {
            url = uri("/Users/kwmt/personal/dev/JetpackComposePlayGround/slide/build/repo")
        }
    }
}

rootProject.name = "JetpackComposePlayGround"
include(":app")
include(":slide")
include(":core:ui")
include(":feature:camerax")
include(":feature:samples")
include(":slide-contents")
