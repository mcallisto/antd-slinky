/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.2"
name := "antd-slinky"
version := "0.2.0"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.42",
  "@types/react-dom" -> "16.9.8",
  "antd" -> "4.9.4"
)

Test / npmDependencies ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1",
)

libraryDependencies ++= Seq(
  "org.scalatest" %%% "scalatest" % "3.2.0" % Test
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

// say we want custom code for slinky
stFlavour := Flavour.Slinky

// focus only on these libraries
stMinimize := Selection.NoneExcept("std", "react", "csstype")

// shade into another package
stOutputPackage := "vision.id.antd4.facade"

ThisBuild / organization := "vision.id.antd-slinky"
ThisBuild / organizationName := "vision.id"
ThisBuild / organizationHomepage := Some(url("http://id.vision/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/mcallisto/antd-slinky"),
    "scm:git@github.com:mcallisto/antd-slinky.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "mcallisto",
    name  = "Mario Càllisto",
    email = "mario.callisto@gmail.com",
    url   = url("https://github.com/mcallisto")
  )
)

ThisBuild / description := "antd bindings for slinky (powered by ScalablyTyped)."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/mcallisto/antd-slinky"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

//publishMavenStyle := true
//homepage := Some(new URL("https://github.com/mcallisto/antd-slinky"))
//startYear := Some(2020)
//pomExtra := (
//  <scm>
//    <connection>scm:git:github.com:/mcallisto/antd-slinky</connection>
//    <developerConnection>scm:git:git@github.com:mcallisto/antd-slinky.git</developerConnection>
//    <url>github.com:mcallisto/antd-slinky.git</url>
//  </scm>
//    <developers>
//      <developer>
//        <id>mcallisto</id>
//        <name>Mario Càllisto</name>
//      </developer>
//    </developers>
//  )
//licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
//bintrayRepository := "libs"
