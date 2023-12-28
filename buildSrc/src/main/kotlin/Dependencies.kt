object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val dagger = "com.google.dagger:hilt-android-gradle-plugin:2.45"
    const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
}

object Deps {

    const val appCompat = "androidx.appcompat:appcompat:1.6.1"

    // TMDB
    object TMDB {
        // https://mvnrepository.com/artifact/com.github.holgerbrandl/themoviedbapi
        val holgerbrandl by lazy { "com.github.holgerbrandl:themoviedbapi:${Versions.tmdb_Api}" }
    }

    // Navigation
    object Navigation {
        val fragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
        val ui by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
    }

    // DI
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltKapt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }

    // UI
    val material by lazy { "com.google.android.material:material:1.4.0" }
    val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    val palette = "androidx.palette:palette-ktx:1.0.0"

    // AndroidX
    val coreKtx = "androidx.core:core-ktx:1.9.0"
    val viewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }
    val liveDataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
    val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.5"

    // Http
    val okHttpBOM by lazy { "com.squareup.okhttp3:okhttp-bom:4.10.0" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp" }
    val okHttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor" }
    val coil by lazy { "io.coil-kt:coil:${Versions.coil}" }
    val coilSvg by lazy { "io.coil-kt:coil-svg:${Versions.coil}" }

    // Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    // JUnit
    val junit by lazy { "junit:junit:4.13.2" }
    val junitAndroid by lazy { "androidx.test.ext:junit:1.1.3" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
    val navigationTest by lazy { "androidx.navigation:navigation-testing:${Versions.navVersion}" }
    val truth by lazy { "com.google.truth:truth:1.1.3" }
    val coroutineTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}" }
    val hiltAndroidTesting by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
    val hiltTestAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val androidTestRunner by lazy { "androidx.test:runner:1.4.0" }
}