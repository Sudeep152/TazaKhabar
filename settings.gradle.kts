pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TazaKhabar"
include(":app")
include(":remote")
include(":auth:data")
include(":auth:domain")
include(":auth:ui")
include(":common")
include(":onBoarding")
include(":common:composable")
include(":common:theme")
include(":core")
include(":dashboard:ui")
include(":dashboard:domain")
include(":dashboard:data")
