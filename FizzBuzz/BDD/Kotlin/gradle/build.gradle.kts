/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    id("org.jetbrains.kotlin.jvm").version("1.3.10")

    id("com.commercehub.cucumber-jvm") version "0.14"

    // Apply the application to add support for building a CLI application
    application
}

buildscript {
  repositories {
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("com.commercehub:gradle-cucumber-jvm-plugin:0.14")
  }
}

apply(plugin = "com.commercehub.cucumber-jvm")


repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    implementation("io.cucumber:cucumber-java8:4.2.0")
    testImplementation("io.cucumber:cucumber-junit:4.2.0")
}

application {
    // Define the main class for the application
    mainClassName = "org.scuba.codingdojo.kata.AppKt"
}

/*
configurations {
    cucumberRuntime {
        extendsFrom testRuntime
    }
}
*/

tasks.create<JavaExec>("bdd") {
    main = "cucumber.api.cli.Main"
    //classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
    args = listOf("--plugin", "pretty", "--glue", "com.knoldus", "src/test/resources")

}