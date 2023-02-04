// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.apollo)

        classpath(BuildPlugins.dagger)
        classpath(BuildPlugins.navigation)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}