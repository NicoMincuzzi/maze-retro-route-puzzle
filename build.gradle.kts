import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.8.10"
}

group = "com.github.nicomincuzzi"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-junit-jupiter:3.10.0")
    testImplementation ("org.mockito:mockito-inline:3.10.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}