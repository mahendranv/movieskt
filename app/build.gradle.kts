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
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
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

    // Compose
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.constraintlayout.compose)
    implementation(libs.hilt.navigation.compose)

    // UI
    implementation(libs.material)
    implementation(libs.constraintLayout)
    implementation(libs.palette)

    // DI
    implementation(libs.hilt)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
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

    // Coil
    implementation(libs.coil.compose)
}