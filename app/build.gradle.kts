plugins {
    id("com.android.application")
}


android {
    namespace = "com.example.neteasecloudmusic"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.neteasecloudmusic"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    viewBinding {
        enable = true
    }
}

dependencies {


    //动画
    implementation("com.nineoldandroids:library:2.4.0")

    //进度条合集
//    implementation("com.github.ForgetAll:LoadingDialog:v1.1.2")
    //exoPlayer
    implementation("com.google.android.exoplayer:exoplayer:2.18.5")
    //mmkv
//    implementation("com.tencent:mmkv:1.3.1")

    //相册选择器
    // PictureSelector basic (Necessary)
    implementation("io.github.lucksiege:pictureselector:v3.11.1")

    // image compress library (Not necessary)
    implementation("io.github.lucksiege:compress:v3.11.1")

    //uCrop library (Not necessary)
    implementation("io.github.lucksiege:ucrop:v3.11.1")

    // simple camerax library (Not necessary)
    implementation("io.github.lucksiege:camerax:v3.11.1")


    val room_version = "2.5.0"
    val work_version = "2.8.0"


    // (Java only)
    // Room数据库库
//    implementation("androidx.room:room-runtime:$room_version")
//    annotationProcessor("androidx.room:room-compiler:$room_version")
    // Banner
    implementation("com.github.bumptech.glide:glide:4.12.0")
    //glide框架依赖
    implementation("io.github.youth5201314:banner:2.2.2")
    //高斯模糊
    implementation("jp.wasabeef:glide-transformations:4.3.0")

    // 扫一扫
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.journeyapps:zxing-android-embedded:4.2.0")
    // BottomSheet

    // WorkManager库 (Java only)
    implementation("androidx.work:work-runtime:$work_version")
    // Retrofit网络请求库
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson库
    implementation("com.google.code.gson:gson:2.9.0")
    // Retrofit Gson转换库
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    // AppCompat库 (用于支持旧版Android设备)
    implementation("androidx.appcompat:appcompat:1.6.1")
    // Google Material Design库
    implementation("com.google.android.material:material:1.8.0")
    // ConstraintLayout库 (用于布局设计)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // JUnit测试库
    testImplementation("junit:junit:4.13.2")
    // Android测试库
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}