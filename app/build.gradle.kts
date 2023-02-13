import java.util.Properties

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

        val props = Properties()
        props.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "TMDB_API_KEY", props["tmdb_api_key"] as String)
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
    }
}

dependencies {
    // TMDB
    implementation(Deps.TMDB.holgerbrandl) {
        exclude("commons-logging", "commons-logging")
    }

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

    // Compose
    implementation(platform(Deps.compose_bom))
    implementation(Deps.compose_material3)
    implementation(Deps.compose_pager)
    implementation(Deps.compose_preview)
    implementation(Deps.compose_ui_tooling)
    implementation(Deps.compose_nav)
    implementation(Deps.compose_hilt_nav)
    implementation(Deps.compose_activity)
    implementation(Deps.compose_viewmodel)
    implementation(Deps.compose_livedate)
    implementation(Deps.compose_flow)

    // Http
    implementation(platform(Deps.okHttpBOM))
    implementation(Deps.okHttp)
    implementation(Deps.okHttpLoggingInterceptor)
    implementation(Deps.coil)
    implementation(Deps.coilSvg)

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