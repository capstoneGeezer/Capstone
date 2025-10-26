// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}
buildscript {
    repositories {
        google()  // Make sure this is here
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.12.3") // or your AGP version
        classpath("com.google.gms:google-services:4.4.2") // ✅ Add this line

    }
}