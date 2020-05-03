import Dependencies.scalaTest

//name := "ninety-nine-problems"
//
//version := "0.1"
//
//scalaVersion := "2.12.7"

lazy val root = (project in file("."))
  .settings(
    name := "ninety-nine-problems",
    libraryDependencies += scalaTest % Test
  )