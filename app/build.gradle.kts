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
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    // Activity
    implementation ("androidx.activity:activity-ktx:1.2.2")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    // Room
    implementation ("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
    kapt ("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
    implementation ("androidx.room:room-ktx:${rootProject.extra["room_version"]}")
    // mockk
    implementation ("io.mockk:mockk:1.12.0")
    // robolectric
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.robolectric:robolectric:4.12.1")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_version"]}")
    implementation ("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofit_version"]}")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_version"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["hilt_version"]}")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    //Compose
    implementation (platform("androidx.compose:compose-bom:2024.02.00"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.material:material")
    implementation ("androidx.compose.runtime:runtime")
    implementation ("androidx.activity:activity-compose:1.9.0")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
}

kapt {
    correctErrorTypes = true
}