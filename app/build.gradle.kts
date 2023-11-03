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
}


dependencies {
    //ijkplayer
//    # required, enough for most devices.
    implementation("tv.danmaku.ijk.media:ijkplayer-java:0.8.8")
    implementation("tv.danmaku.ijk.media:ijkplayer-armv7a:0.8.8")

//    # Other ABIs: optional
    implementation("tv.danmaku.ijk.media:ijkplayer-armv5:0.8.8")
    implementation("tv.danmaku.ijk.media:ijkplayer-arm64:0.8.8")
    implementation("tv.danmaku.ijk.media:ijkplayer-x86:0.8.8")
    implementation("tv.danmaku.ijk.media:ijkplayer-x86_64:0.8.8")

//    # ExoPlayer as IMediaPlayer: optional, experimental
    implementation("tv.danmaku.ijk.media:ijkplayer-exo:0.8.8")

    //相册选择器
    // PictureSelector basic (Necessary)
    implementation("io.github.lucksiege:pictureselector:v3.11.1")

    // image compress library (Not necessary)
    implementation("io.github.lucksiege:compress:v3.11.1")

    // uCrop library (Not necessary)
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