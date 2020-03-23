//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
//    kotlin("jvm") version "1.3.71"
    `java-library`
    java
    id("com.github.johnrengelman.shadow") version "5.2.0"
    id( "com.github.ben-manes.versions") version "0.28.0"
}

group = "com.github.md"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.withType<ShadowJar> {
    manifest {
//        attributes(mapOf("Main-Class" to "trie.TrieKt"))
        attributes(mapOf("Main-Class" to "trie.JawaTrie"))
    }
}
dependencies {

//    implementation(kotlin("stdlib-jdk8"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "11"
//}