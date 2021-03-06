name := "breeze"

Common.commonSettings

libraryDependencies ++= Seq(
  "com.github.fommil.netlib" % "core" % "1.1.2",
  "net.sourceforge.f2j" % "arpack_combined_all" % "0.1",
  "net.sf.opencsv" % "opencsv" % "2.3",
  "com.github.wendykierp" % "JTransforms" % "3.1",
  "org.apache.commons" % "commons-math3" % "3.2",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.0-beta9" % "test",
  "org.apache.logging.log4j" % "log4j-core" % "2.0-beta9" % "test",
  "org.apache.logging.log4j" % "log4j-api" % "2.0-beta9" % "test"
)

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 13)) =>
      Seq(
        "org.typelevel" % "spire_2.13.0-M5" % "0.16.1",
        "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test"
      )
    case Some((2, 12)) =>
      Seq(
        "org.typelevel" %% "spire" % "0.16.1",
        "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test"
      )
    case Some((2, 11)) =>
      Seq(
        "org.typelevel" %% "spire" % "0.16.1",
        "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test"
      )
    case _ =>
      Seq(
        "org.typelevel" %% "spire" % "0.16.1",
      )
  }
}

// see https://github.com/typesafehub/scalalogging/issues/23
testOptions in Test += Tests.Setup(classLoader =>
  try {
    classLoader
      .loadClass("org.slf4j.LoggerFactory")
      .getMethod("getLogger", classLoader.loadClass("java.lang.String"))
      .invoke(null, "ROOT")
  } catch {
    case _: Exception =>
})

fork := true

javaOptions := Seq("-Xmx4g")
