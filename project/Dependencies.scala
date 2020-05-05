/*
 * Copyright (C) 2009-2018 Lightbend Inc. <https://www.lightbend.com>
 */

import sbt._

object Dependencies {
  val Scala211 = "2.11.12"
  val Scala212 = "2.12.11"
  val Scala213 = "2.13.1"

  val AkkaVersion = "2.5.25"
  val AkkaBinaryVersion = "2.5"
  val AlpakkaCouchbaseVersion = "2.0.0"
  val LagomVersion = "1.5.4"

  val ScalaCollectionCompat = "2.1.4"

  object Compile {
    val scalaCollectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % ScalaCollectionCompat

    // used to easily convert rxjava into reactive streams and then into akka streams
    val rxJavaReactiveStreams = "io.reactivex" % "rxjava-reactive-streams" % "1.2.1" // Apache V2

    val akkaActor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion
    val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % AkkaVersion
    val akkaStream = "com.typesafe.akka" %% "akka-stream" % AkkaVersion
    val akkaPersistence = "com.typesafe.akka" %% "akka-persistence" % AkkaVersion
    val akkaPersistenceQuery = "com.typesafe.akka" %% "akka-persistence-query" % AkkaVersion

    val alpakkaCouchbase = "com.lightbend.akka" %% "akka-stream-alpakka-couchbase" % AlpakkaCouchbaseVersion

    val lagomScalaDslApi = "com.lightbend.lagom" %% "lagom-scaladsl-api" % LagomVersion
    val lagomPersistenceCore = "com.lightbend.lagom" %% "lagom-persistence-core" % LagomVersion
    val lagomPersistenceScalaDsl = "com.lightbend.lagom" %% "lagom-scaladsl-persistence" % LagomVersion
    val lagomPersistenceJavaDsl = "com.lightbend.lagom" %% "lagom-javadsl-persistence" % LagomVersion
  }

  object TestDeps {
    val akkaPersistenceTck = "com.typesafe.akka" %% "akka-persistence-tck" % AkkaVersion % Test
    val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % Test
    val akkaStreamTestkit = "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test
    val akkaMultiNodeTestkit = "com.typesafe.akka" %% "akka-multi-node-testkit" % AkkaVersion % Test

    val logback = "ch.qos.logback" % "logback-classic" % "1.2.3" % Test // EPL 1.0 / LGPL 2.1
    val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8" % Test // ApacheV2
    val junit = "junit" % "junit" % "4.12" % Test
    val junitInterface = "com.novocode" % "junit-interface" % "0.11" % Test

    val lagomTestKitScalaDsl = "com.lightbend.lagom" %% "lagom-scaladsl-testkit" % LagomVersion % Test
    val lagomTestKitJavaDsl = "com.lightbend.lagom" %% "lagom-javadsl-testkit" % LagomVersion % Test
    val lagomPersistenceTestKit = "com.lightbend.lagom" %% "lagom-persistence-testkit" % LagomVersion % Test

    val slf4jApi = "org.slf4j" % "slf4j-api" % "1.7.28" % Test
  }

  import Compile._
  import TestDeps._

  val core = Seq(
    scalaCollectionCompat,
    akkaActor,
    akkaPersistence,
    akkaPersistenceQuery,
    akkaPersistenceTck,
    alpakkaCouchbase,
    akkaStreamTestkit,
    akkaTestkit,
    logback,
    slf4jApi,
    scalaTest
  )

  val `copy-of-lagom-persistence-test` = Seq(
    akkaActor,
    akkaCluster,
    lagomPersistenceScalaDsl,
    lagomPersistenceJavaDsl,
    akkaTestkit,
    scalaTest,
    akkaMultiNodeTestkit
  )

  val `lagom-persistence-couchbase-core` = Seq(
    lagomPersistenceCore,
    alpakkaCouchbase,
    slf4jApi,
    scalaTest
  )

  val `lagom-persistence-couchbase-scaladsl` = Seq(
    lagomPersistenceScalaDsl,
    lagomScalaDslApi,
    scalaTest
  )

  val `lagom-persistence-couchbase-javadsl` = Seq(
    lagomPersistenceJavaDsl,
    junit,
    junitInterface
  )
}
