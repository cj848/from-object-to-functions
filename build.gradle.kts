plugins {
    kotlin("jvm") version "2.1.20"
}

group = "from.object.to.functions"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
    mavenCentral()
}

val http4kVersion: String by project
val junitBomVersion: String by project
val pesticideVersion: String by project
val striktVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation("org.http4k:http4k-core:${http4kVersion}")
    implementation("org.http4k:http4k-server-jetty:${http4kVersion}")

    testImplementation(platform("org.junit:junit-bom:${junitBomVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.http4k:http4k-client-jetty:${http4kVersion}")
    testImplementation("com.ubertob.pesticide:pesticide-core:${pesticideVersion}")
    testImplementation("io.strikt:strikt-core:${striktVersion}")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
