plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "io.noties.shareelements"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api ("androidx.recyclerview:recyclerview:1.0.0")
//    api("com.facebook.fresco:fresco:3.6.0")
    // 如果需要支持WebP，还需要添加
//    api("com.facebook.fresco:webpsupport:3.2.0")

    api("com.facebook.fresco:fresco:2.6.0")
// 如果使用中间件相关功能，可能需要额外依赖
    api("com.facebook.fresco:middleware:2.6.0")

    api ("com.github.bumptech.glide:glide:4.16.0")
//    implementation ("com.shuyu:gsyVideoPlayer-java:6.0.0-beta")
//    implementation ("com.shuyu:gsyVideoPlayer-armv7a:6.0.0-beta")
//    implementation ("com.shuyu:gsyVideoPlayer-x86:6.0.0-beta")
    api ("io.github.carguo:gsyvideoplayer:11.1.0")
//    implementation ("io.github.carguo:gsyvideoplayer-aliplay:11.1.0")
}