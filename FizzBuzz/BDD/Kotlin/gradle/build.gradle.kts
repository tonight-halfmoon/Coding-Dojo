plugins {
    id("java")

    id("com.commercehub.cucumber-jvm").version("0.14")

    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    id("org.jetbrains.kotlin.jvm").version("1.3.10")
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
	jcenter()
	mavenCentral()
}

/*
Reference> https://github/cp,commerncehub-oss/gradle-cucumber-jvm-plugin
*/
cucumber {
	suite("bddTest")
}

dependencies {

    add("bddTestCompile", "io.cucumber:cucumber-java:4.2.0")
    add("bddTestCompile", "junit:junit:4.12")
/*
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("io.cucumber:cucumber-java:4.2.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.cucumber:cucumber-junit:4.2.0")
*/
}

/*
tasks.create<JavaExec>("bdd") {
    main = "cucumber.api.cli.Main"
  //  classpath = cucumberRuntime + sourceSets.main.output + sourceSets.test.output
    args = listOf("--plugin", "pretty", "--glue", "com.knoldus", "src/test/resources")

}
*/
