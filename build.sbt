// https://typelevel.org/sbt-typelevel/faq.html#what-is-a-base-version-anyway
ThisBuild / tlBaseVersion := "0.0" // your current series x.y

ThisBuild / organization := "com.rossabaker"
ThisBuild / organizationName := "Ross A. Baker"
ThisBuild / startYear := Some(2025)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(
  // your GitHub handle and name
  tlGitHubDev("rossabaker", "Ross A. Baker")
)

ThisBuild / sonatypeCredentialHost := xerial.sbt.Sonatype.sonatypeCentralHost

val Scala3 = "3.3.5"
ThisBuild / crossScalaVersions := Seq(Scala3)
ThisBuild / scalaVersion := Scala3 // the default Scala
ThisBuild / githubWorkflowJavaVersions := Seq(
  JavaSpec.temurin("11"),
  JavaSpec.temurin("8")
)
ThisBuild / tlCiDependencyGraphJob := false
ThisBuild / tlCiReleaseBranches := Seq("main")

lazy val root = project.aggregate(core)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "no",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.13.0",
      "org.typelevel" %%% "cats-effect" % "3.6.1"
    )
  )
