import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.ex2.movies"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val props = Properties()
        props.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "TMDB_API_KEY", props["tmdb_api_key"] as String)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }
}

dependencies {
    // DI
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // TMDB
    implementation(libs.tmdbHolger) {
        exclude("commons-logging", "commons-logging")
    }

    // Android X
    implementation(libs.lifecycle.viewmodel)

    testImplementation(libs.junit)
    androidTestImplementation(libs.extJunit)
    androidTestImplementation(libs.espressoCore)
}