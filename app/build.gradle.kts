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
    implementation(Deps.Navigation.fragment)
    implementation(Deps.Navigation.ui)

    // UI
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.palette)

    // DI
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)

    // AndroidX
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.viewModelKtx)
    implementation(Deps.liveDataKtx)
    implementation(Deps.fragmentKtx)

    // Coroutines
    implementation(Deps.coroutinesCore)
    runtimeOnly(Deps.coroutinesAndroid)

    // Test
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitAndroid)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.navigationTest)
    testImplementation(Deps.truth)
    testImplementation(Deps.coroutineTest)
    androidTestImplementation(Deps.hiltAndroidTesting)
    kaptAndroidTest(Deps.hiltTestAndroidCompiler)
    androidTestImplementation(Deps.androidTestRunner)
}