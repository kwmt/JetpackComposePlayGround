import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import java.util.Locale

interface PublishPluginExtension {
    companion object {
        const val DEFAUlT_DIEMNSION = "io.github.kwmt.slide.default"
    }
}

class PublishPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("maven-publish")
                apply("com.android.library")
            }

            configure<LibraryExtension> {
                publishing {
                    buildTypes.all {
                        val buildType = this.name
                        productFlavors.all {
                            val flavor = this.name
                            singleVariant("${flavor}${buildType.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            }}")
                        }
                        singleVariant(buildType)
                    }
//                    singleVariant("productionRelease") {
//                        withSourcesJar()
//                    }
                }
            }

            configure<PublishingExtension> {
                publications {
                    register<MavenPublication>("productionRelease") {
                        groupId = "io.my-company"
                        artifactId = "my-library"
                        version = "1.0.3"
                        afterEvaluate {
                            components.forEach {
                                println("----- ${it.name}")
                            }
                            from(components["productionRelease"])
                        }
                    }
//                    register<MavenPublication>("stagingRelease") {
//                        groupId = "io.my-company"
//                        artifactId = "my-library-staging"
//                        version = "1.0"
//                        afterEvaluate {
//                            components.forEach {
//                                println("----- ${it.name}")
//                            }
//                            from(components["stagingRelease"])
//                        }
//                    }
                    repositories {
                        maven {
                            name = "myRepo"
                            url = uri(layout.buildDirectory.dir("repo"))
                        }
                    }
                }
            }
        }
    }
}
