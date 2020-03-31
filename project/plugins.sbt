addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.1.0") // for maintenance of copyright file header
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.4.0") // sources autoformat

// whitesource for tracking licenses and vulnerabilities in dependencies
addSbtPlugin("com.lightbend" % "sbt-whitesource" % "0.1.14")

// for releasing
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "3.3.0")
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.4.0")

// docs
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-dependencies" % "0.2.1")
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-project-info" % "1.1.3")
addSbtPlugin("com.lightbend.akka" % "sbt-paradox-akka" % "0.31")
addSbtPlugin("com.lightbend.sbt" % "sbt-publish-rsync" % "0.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.4.0")
