name := "FizzBuzzKata"
scalaVersion := "2.12.7"
organization := "org.scuba.codingdojo.kata"
version := "0.0.1"
description := "Solving FizzBuzz Kata pursuing BDD with Cucumber"

val scalaLibrary = "org.scala-lang" % "scala-library" % "2.11.8"
val scalaCompiler = "org.scala-lang" % "scala-compiler" % "2.11.8"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val cucumberCore = "io.cucumber" % "cucumber-core" % "2.0.1"
val cucumberScala = "io.cucumber" %% "cucumber-scala" % "2.0.1"
val cucumberJunit = "io.cucumber" % "cucumber-junit" % "2.0.1"
val cucumberJvm = "io.cucumber" % "cucumber-jvm" % "2.0.1"
//val cucumberPicocontainer = "info.cukes" % "cucumber-picocontainer" % "1.2.5"
//val scalactic = "org.scalactic" %% "scalactic" % "3.0.5"

lazy val `fizz-buzz` = (project in file("."))
  .settings(
    libraryDependencies := Seq(
      scalaLibrary,
      scalaCompiler,
      cucumberCore,
      scalaTest % Test,
      cucumberJunit % Test,
      cucumberJvm % Test,
      cucumberScala % Test
      //cucumberPicocontainer % Test,
      //scalactic
    )
  )

enablePlugins(CucumberPlugin)

CucumberPlugin.glue := "fizzbuzzkata"
