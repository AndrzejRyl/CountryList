object Versions {
    const val minSdk = 24
    const val compileSdk = 29
    const val targetSdk = 29

    const val gradle = "3.6.1"
    const val kotlin = "1.3.70"
    const val kotlinCoroutines = "1.3.3"
    const val leakCanary = "2.2"

    const val appCompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val navigation = "2.2.1"

    const val constraintLayout = "1.1.3"
    const val lifecycle = "2.2.0"
    const val paging_version = "2.1.2"

    const val room = "2.2.5"

    const val moshi = "1.9.2"
    const val okHttp = "4.5.0"
    const val koin = "2.1.5"
    const val retrofit = "2.8.1"

    const val junit = "5.6.1"
    const val mockitoAndroid = "3.3.0"
    const val mockitoKotlin = "2.2.0"
}

object Libs {
    const val gradle_classpath = "com.android.tools.build:gradle:${Versions.gradle}"
    const val navigation_classpath = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"

    const val leak_canary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val androidX_appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidX_coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    const val androidX_lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val androidX_lifecycle_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val androidX_lifecycle_vmx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val androidX_constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidx_paging =  "androidx.paging:paging-runtime:${Versions.paging_version}"
    const val androidx_paging_test =  "androidx.paging:paging-common:${Versions.paging_version}"

    const val androidX_room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val androidX_room_kapt = "androidx.room:room-compiler:${Versions.room}"
    const val androidX_room_ktx = "androidx.room:room-ktx:${Versions.room}"

    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koin_view_model = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshi_kapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val moshi_adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val scalar_converter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"

    const val ok_http = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val ok_http_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
}

object TestLibs {
    const val junit_api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val junit_params = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"

    const val junit = "junit:junit:${Versions.junit}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoAndroid}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
}