// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
}

ext {
    set("hilt_version", "2.47")
    set("retrofit_version", "2.9.0")
    set("room_version", "2.5.0")
}