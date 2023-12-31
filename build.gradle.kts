val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koinVersion: String by project
val kmongo_version: String by project

plugins {
    kotlin("jvm") version "1.8.22"
    id("io.ktor.plugin") version "2.3.1"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.8.22"
}

group = "com.masdiq"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-http-redirect-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Content Negotiation
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")

    // Kmonggo
    implementation("org.litote.kmongo:kmongo:$kmongo_version")
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongo_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor:$koinVersion")

    // SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")

    // Session
    implementation("io.ktor:ktor-server-sessions-jvm:$ktor_version")

    // Auth
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")

    // Google Client API Library
    implementation("com.google.api-client:google-api-client:1.33.2")
}