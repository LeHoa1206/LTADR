// app/build.gradle.kts
// build.gradle.kts (tệp cấp dự án)
plugins {
    alias(libs.plugins.android.application)
}




android {
    namespace = "com.example.baitapnhomlaptrinhadr_nhd_cosmetic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.baitapnhomlaptrinhadr_nhd_cosmetic"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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


}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation ("androidx.constraintlayout:constraintlayout:2.1.4") 
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
