plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

group = "io.github.jan-tennert.supabase"
version = Versions.SUPABASEKT
description = "Extends supabase-kt with a Realtime Client"

repositories {
    mavenCentral()
}

kotlin {
    /** Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    jvm {
        jvmToolchain(8)
        compilations.all {
            kotlinOptions.freeCompilerArgs = listOf(
                "-Xjvm-default=all",  // use default methods in interfaces,
                "-Xlambdas=indy"      // use invokedynamic lambdas instead of synthetic classes
            )
        }
    }
    android {
        publishLibraryVariants("release", "debug")
    }
    js(IR) {
        browser {
            testTask {
                enabled = false
                /**useKarma {
                    useFirefox()
                }*/
            }
        }
    }
    //ios()
    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                api(project(":gotrue-kt"))
                api("io.ktor:ktor-client-websockets:${Versions.KTOR}")
            }
        }
        val jvmMain by getting  {
            /*dependencies {
                implementation("ch.qos.logback:logback-classic:1.3.0-beta0")
                api("io.ktor:ktor-client-cio:${Versions.KTOR}")
            }*/
        }
        val androidMain by getting
        val jsMain by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
