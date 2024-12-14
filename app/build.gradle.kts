plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.clean_test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.clean_test"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        viewBinding = true
        compose = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions{
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation (libs.kotlinx.coroutines.test)
    // Activity
    implementation (libs.androidx.activity.ktx)
    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)
    // Room
    implementation (libs.androidx.room.runtime)
    ksp (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)
    // mockk
    implementation (libs.mockk)
    // robolectric
    testImplementation (libs.junit)
    testImplementation (libs.robolectric)
    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    // Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
    //Compose
    implementation (platform(libs.androidx.compose.bom))
    implementation (libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation (libs.androidx.runtime)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.ui.graphics)
    implementation (libs.androidx.ui.tooling.preview)
    // paging
    implementation (libs.androidx.paging.compose)
    // coil
    implementation (libs.coil.compose)
}

kapt {
    correctErrorTypes = true
}