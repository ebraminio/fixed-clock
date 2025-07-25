plugins {
    id("com.android.application")
}

android {
    namespace = "io.github.persiancalendar.fixedclock"
    compileSdk = 36

    defaultConfig {
        applicationId = "io.github.persiancalendar.fixedclock"
        minSdk = 17
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs["debug"]
        }
    }
}
