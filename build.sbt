lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.6"
    )),
    name := "scala-calculator"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "20.0.0-R31"
