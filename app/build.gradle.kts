plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

val computedVersionName = findProperty("versionName") as String? ?: "v0.2"
println("Computed version name: $computedVersionName")

android {
    namespace = "com.ex2.ktmovies"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.ex2.ktmovies"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        versionCode = ConfigData.versionCode
        versionName = computedVersionName
        setProperty("archivesBaseName", "MoviesKt")

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.ex2.ktmovies.MovieAppTestRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }

    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/DEPENDENCIES",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/NOTICE.txt"
            )
        }
    }
}

dependencies {
    // Modules
    implementation(project(":droid"))
    implementation(project(":data-core"))

    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // UI
    implementation(libs.material)
    implementation(libs.constraintLayout)
    implementation(libs.palette)

    // DI
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // AndroidX
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.fragment.ktx)

    // Coroutines
    implementation(libs.coroutines.core)
    runtimeOnly(libs.coroutines.android)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.extJunit)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.navigation.testing)
    testImplementation(libs.truth)
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)
    androidTestImplementation(libs.test.runner)
}