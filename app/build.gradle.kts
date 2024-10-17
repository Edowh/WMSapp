plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.9.0"
    id("kotlin-android") // 替换掉 kotlin("android")
    id("kotlin-kapt") // 替换掉 kotlin("kapt")
    id("kotlin-parcelize") // 添加 kotlin-parcelize 以替代 Android Extensions 的序列化功能
}

android {
    namespace = "com.hs.wmsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hs.wmsapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true // 启用 Jetpack Compose
        viewBinding = true // 启用 View Binding，代替 Android Extensions
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0" // 根据使用的 Compose 版本调整
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.navigation:navigation-compose:2.5.0") // 可选：使用导航时添加

    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0") // UI 工具
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0")

    // 单元测试
    testImplementation("junit:junit:4.13.2")

    // Android 仪器测试
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

repositories {
    google()
    mavenCentral()
}
