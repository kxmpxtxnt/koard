rootProject.name = "koard"

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

include(
  "koard-core"
)

dependencyResolutionManagement {
  versionCatalogs {
    create("jetbrains") {
      version("kotlin", "2.0.0")

      plugin("kotlin", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
      plugin("serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")

      library("kotlin.test", "org.jetbrains.kotlin", "kotlin-test").versionRef("kotlin")
      library("kotlin.test.common", "org.jetbrains.kotlin", "kotlin-test-common").versionRef("kotlin")
      library("kotlin.test.annotations", "org.jetbrains.kotlin", "kotlin-test-annotations-common").versionRef("kotlin")

      bundle("kotlin.testing", listOf(
        "kotlin.test",
        "kotlin.test.common",
        "kotlin.test.annotations"
      ))

      library("kotlinx.json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version("1.7.1")
      library("kotlinx.datetime", "org.jetbrains.kotlinx", "kotlinx-datetime").version("0.6.0")
    }

    create("third") {
      library("uuid", "com.benasher44", "uuid").version("0.8.4")
    }
  }
}
