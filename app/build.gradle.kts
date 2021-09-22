plugins {
    id("kotlin-kapt")
    id("com.android.application")
    id("kotlin-android")
    id("com.apollographql.apollo")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.ex2.ktmovies"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

apollo {
    generateKotlinModels.set(true)
    customTypeMapping.set(
        mapOf(
            "URL" to "kotlin.String",
            "Date" to "java.util.Calendar"
        )
    )
}

dependencies {

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

    // Http
    implementation(platform(Deps.okHttpBOM))
    implementation(Deps.okHttp)
    implementation(Deps.okHttpLoggingInterceptor)
    implementation(Deps.coil)

    // Apollo
    implementation(Deps.apolloRuntime)
    implementation(Deps.apolloCoroutines)
    implementation(Deps.apolloHttpCache)

    // Coroutines
    implementation(Deps.coroutinesCore)
    runtimeOnly(Deps.coroutinesAndroid)

    // Test
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitAndroid)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.navigationTest)
}