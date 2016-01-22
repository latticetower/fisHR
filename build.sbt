// Application Name
name := """fisHR"""

// Application Version
version := "1.0.0"

// Scala version
scalaVersion := "2.11.4"

resolvers += "jcenter" at "http://jcenter.bintray.com"

libraryDependencies ++= Seq(
  aar("org.macroid" %% "macroid" % "2.0.0-M3"),
  "com.android.support" % "support-v4" % "20.0.0"
)

addCompilerPlugin("org.brianmckenna" %% "wartremover" % "0.10")

scalacOptions in (Compile, compile) ++=
  (dependencyClasspath in Compile).value.files.map("-P:wartremover:cp:" + _.toURI.toURL)

scalacOptions in (Compile, compile) ++= Seq(
  "-P:wartremover:traverser:macroid.warts.CheckUi"
)


// Override the run task with the android:run
run <<= run in Android

// Activate proguard for Scala
proguardScala in Android := true

// Activate proguard for Android
useProguard in Android := true

// Set proguard options
proguardOptions in Android ++= Seq(
  "-ignorewarnings",
  "-keep class scala.Dynamic")
