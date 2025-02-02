pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

     /*   maven ("https://storage.zego.im/maven")  // <- Add this line.
        maven ("https://www.jitpack.io") // <- Add this line.*/

        mavenCentral()
        gradlePluginPortal()

        maven {
            url = uri("https://jitpack.io")
        }

        maven {
            url = uri("https://storage.zego.im/maven")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            url = uri("https://jitpack.io")
        }

        maven {
            url = uri("https://storage.zego.im/maven")
        }
    }
}

rootProject.name = "VideoCallApp"
include(":app")
