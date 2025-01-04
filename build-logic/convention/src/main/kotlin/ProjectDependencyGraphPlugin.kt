// import org.gradle.api.Plugin
// import org.gradle.api.Project
// import org.gradle.api.artifacts.ProjectDependency
// import java.util.Locale
//
// class ProjectDependencyGraphPlugin : Plugin<Project> {
//    override fun apply(target: Project) {
//        // from: https://github.com/JakeWharton/SdkSearch/blob/3351cad9bfacb0a364858e843774147143f58c7a/gradle/projectDependencyGraph.gradle
// // you need to command `brew install graphviz`
//        with(target) {
//            task("projectDependencyGraph") {
//                doLast {
//                    val dot = rootProject.buildDir.resolve("reports/dependency-graph/project.dot")
//                    dot.parentFile.mkdirs()
//                    dot.delete()
//
//                    dot.writeText("digraph {\n")
//                    dot.appendText("  graph [label=\"${rootProject.name}\\n \",labelloc=t,fontsize=30,ranksep=1.4];\n")
//                    dot.appendText("  node [style=filled, fillcolor=\"#bbbbbb\"];\n")
//                    dot.appendText("  rankdir=TB;\n")
//                    val rootProjects = mutableListOf(rootProject)
//                    val queue: MutableList<Project> = mutableListOf(rootProject)
//
//                    while (queue.isNotEmpty()) {
//                        val project = queue.removeAt(0)
//                        rootProjects.add(project)
//                        queue.addAll(project.childProjects.values)
//                    }
//                    var projects = mutableSetOf<Project>()
//                    val dependencies = mutableMapOf<Pair<Project, Project>, List<String>>()
//                    val multiplatformProjects = mutableListOf<Project>()
//                    val jsProjects = mutableListOf<Project>()
//                    val androidProjects = mutableListOf<Project>()
//                    val javaProjects = mutableListOf<Project>()
//
//                    queue.add(rootProject)
//                    while (queue.isNotEmpty()) {
//                        val project = queue.removeAt(0)
//                        queue.addAll(project.childProjects.values)
//
//                        if (project.plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) {
//                            multiplatformProjects.add(project)
//                        }
//                        if (project.plugins.hasPlugin("kotlin2js")) {
//                            jsProjects.add(project)
//                        }
//                        if (project.plugins.hasPlugin("com.android.library") || project.plugins.hasPlugin(
//                                "com.android.application"
//                            )
//                        ) {
//                            androidProjects.add(project)
//                        }
//                        if (project.plugins.hasPlugin("java-library") || project.plugins.hasPlugin("java")) {
//                            javaProjects.add(project)
//                        }
//
//                        project.configurations.forEach { config ->
//                            config.dependencies
//                                .withType(ProjectDependency::class.java)
//                                .forEach { dependency ->
//                                    val graphKey = Pair(project, dependency.dependencyProject)
//                                    projects.add(project)
//                                    projects.add(dependency.dependencyProject)
//                                    rootProjects.remove(dependency.dependencyProject)
//                                    val traits =
//                                        dependencies.computeIfAbsent(graphKey) { mutableListOf<String>() }
//                                            .toMutableList()
//
//                                    if (config.name.lowercase().endsWith("implementation")) {
//                                        traits.add("style=dotted")
//                                    }
//                                }
//                        }
//                    }
//
//                    projects = projects.sortedBy { it.path }.toHashSet()
//
//                    dot.appendText("\n  # Projects\n\n")
//                    for (project in projects) {
//                        val traits = mutableListOf<String>()
//
//                        if (rootProjects.contains(project)) {
//                            traits.add("shape=box")
//                        }
//
//                        if (multiplatformProjects.contains(project)) {
//                            traits.add("fillcolor=\"#ffd2b3\"")
//                        } else if (jsProjects.contains(project)) {
//                            traits.add("fillcolor=\"#ffffba\"")
//                        } else if (androidProjects.contains(project)) {
//                            traits.add("fillcolor=\"#baffc9\"")
//                        } else if (javaProjects.contains(project)) {
//                            traits.add("fillcolor=\"#ffb3ba\"")
//                        } else {
//                            traits.add("fillcolor=\"#eeeeee\"")
//                        }
//
//                        dot.appendText("  \"${project.path}\" [${traits.joinToString(", ")}];\n")
//                    }
//
//                    dot.appendText("\n  {rank = same;")
//                    for (project in projects) {
//                        if (rootProjects.contains(project)) {
//                            dot.appendText(" \"${project.path}\";")
//                        }
//                    }
//                    dot.appendText("}\n")
//
//                    dot.appendText("\n  # Dependencies\n\n")
//                    dependencies.forEach { (key, traits) ->
//                        dot.appendText("  \"${key.first.path}\" -> \"${key.second.path}\"")
//                        if (traits.isNotEmpty()) {
//                            dot.appendText(" [${traits.joinToString(", ")}]")
//                        }
//                        dot.appendText("\n")
//                    }
//
//                    dot.appendText("}\n")
//                    val p = ProcessBuilder("dot", "-Tpng", "-O", "project.dot").start()
//                    p.waitFor()
//                    if (p.exitValue() != 0) {
//                        throw RuntimeException(p.errorStream.toString())
//                    }
//
//                    println("Project module dependency graph created at ${dot.absolutePath}.png")
//                }
//            }
//        }
//    }
// }
