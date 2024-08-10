import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest

plugins {
  alias(jetbrains.plugins.kotlin)
  alias(jetbrains.plugins.serialization)
}

repositories {
  mavenCentral()
}

kotlin {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    freeCompilerArgs.add("-Xcontext-receivers")
  }

  jvm()

  iosX64()
  tvosX64()
  iosArm64()
  macosX64()
  tvosArm64()
  macosArm64()
  watchosX64()
  watchosArm64()
  tvosSimulatorArm64()
  watchosSimulatorArm64()

  mingwX64()

  linuxX64()
  linuxArm64()

  applyDefaultHierarchyTemplate()

  sourceSets {
    commonMain {
      dependencies {
        implementation(third.uuid)
        implementation(jetbrains.kotlinx.json)
        implementation(jetbrains.kotlinx.datetime)
      }
    }

    commonTest {
      dependencies {
        implementation(jetbrains.bundles.kotlin.testing)
      }
    }
  }
}

tasks.withType<KotlinJvmTest> {
  useJUnitPlatform()
}