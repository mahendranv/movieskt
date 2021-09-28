object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val apollo by lazy { "com.apollographql.apollo:apollo-gradle-plugin:2.5.9" }
    val dagger by lazy { "com.google.dagger:hilt-android-gradle-plugin:2.38.1" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}" }
}

object Deps {

    val appCompat by lazy { "androidx.appcompat:appcompat:1.3.1" }

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
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:2.1.0" }
    val palette by lazy { "androidx.palette:palette-ktx:1.0.0" }

    // AndroidX
    val coreKtx by lazy { "androidx.core:core-ktx:1.6.0" }
    val viewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }
    val liveDataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:1.3.6" }

    // Http
    val okHttpBOM by lazy { "com.squareup.okhttp3:okhttp-bom:4.9.0" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp" }
    val okHttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor" }
    val coil by lazy { "io.coil-kt:coil:1.3.2" }

    // Apollo
    val apolloRuntime by lazy { "com.apollographql.apollo:apollo-runtime:${Versions.apollo}" }
    val apolloCoroutines by lazy { "com.apollographql.apollo:apollo-coroutines-support:${Versions.apollo}" }
    val apolloHttpCache by lazy { "com.apollographql.apollo:apollo-http-cache:${Versions.apollo}" }

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