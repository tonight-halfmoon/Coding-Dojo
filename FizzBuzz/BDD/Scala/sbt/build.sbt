name := "FizzBuzzKata"

scalaVersion := "2.11.8"

organization := "org.scuba.codingdojo.kata"

version := "0.0.1"

description := "Solving FizzBuzz Kata pursuing BDD with Cucumber"

val cucumberVersion = "4.2.0"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val cucumberCore = "io.cucumber" % "cucumber-core" % cucumberVersion
val cucumberScala = "io.cucumber" %% "cucumber-scala" % cucumberVersion
val cucumberJunit = "io.cucumber" % "cucumber-junit" % cucumberVersion
val cucumberJvm = "io.cucumber" % "cucumber-jvm" % cucumberVersion
//val scalactic = "org.scalactic" %% "scalactic" % "3.0.5"

lazy val `fizz-buzz` = (project in file("."))
  .settings(
    libraryDependencies := Seq(
      cucumberCore,
      scalaTest % Test,
      cucumberJunit % Test,
      cucumberJvm % Test,
      cucumberScala % Test
      //scalactic
    )
  )

enablePlugins(CucumberPlugin)

CucumberPlugin.glue := "fizzbuzzkata"
