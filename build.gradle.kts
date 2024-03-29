// Top-level build file where you can add configuration options core to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.android.gradlePlugin)
    }
}

plugins {
    id("com.diffplug.spotless") version "5.15.1"
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
}
spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt")
        targetExclude("bin/**/*.kt")
        ktlint("0.42.1")
    }
}

apply(from = rootProject.file("gradle/projectDependencyGraph.gradle"))
