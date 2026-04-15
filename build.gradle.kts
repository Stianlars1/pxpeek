plugins {
    kotlin("jvm") version "2.1.20"
    id("org.jetbrains.intellij.platform")
}

group = "dev.stianl"
version = "0.1.0"

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2025.1")
        bundledPlugin("com.intellij.css")
    }
}

kotlin {
    jvmToolchain(21)
}

intellijPlatform {
    buildSearchableOptions = false
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
            untilBuild = provider { null }
        }
    }
}
