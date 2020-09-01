/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.2"
name := "antd-slinky"
version := "0.1.8"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.42",
  "@types/react-dom" -> "16.9.8",
  "antd" -> "4.5.4"
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

publishMavenStyle := true
homepage := Some(new URL("https://github.com/mcallisto/antd-slinky"))
startYear := Some(2020)
pomExtra := (
  <scm>
    <connection>scm:git:github.com:/mcallisto/antd-slinky</connection>
    <developerConnection>scm:git:git@github.com:mcallisto/antd-slinky.git</developerConnection>
    <url>github.com:mcallisto/antd-slinky.git</url>
  </scm>
    <developers>
      <developer>
        <id>mcallisto</id>
        <name>Mario Càllisto</name>
      </developer>
    </developers>
  )
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "libs"
