# Overview

The Akka Persistence Couchbase plugin allows for using [Couchbase](https://www.couchbase.com) 5.1 and newer as a backend for [Akka Persistence](https://doc.akka.io/docs/akka/current/persistence.html) and [Akka Persistence Query](https://doc.akka.io/docs/akka/current/persistence-query.html). It uses [Alpakka Couchbase](https://doc.akka.io/docs/alpakka/current/couchbase.html) @var[alpakkaCouchbase.version] to connect to Couchbase.

## Project Info

@@project-info{ projectId="core" }

## Dependencies

@@dependency [sbt,Maven,Gradle] {
  group=com.lightbend.akka
  artifact=akka-persistence-couchbase_$scala.binary.version$
  version=$project.version$
  group2=com.lightbend.akka artifact2=akka-stream-alpakka-couchbase_$scala.binary.version$ version2=$alpakkaCouchbase.version$
  symbol1=AkkaVersion value1=$akka.version$
  group3=com.typesafe.akka artifact3=akka-persistence-query_$scala.binary.version$ version3=AkkaVersion
}

This plugin can be used with Akka 2.5.x and Akka 2.6.x. Note that it is important that all `akka-*` 
dependencies are in the same version, so it is recommended to depend on them explicitly to avoid problems 
with transient dependencies causing an unlucky mix of versions.

The table below shows Akka Persistence Couchbase’s direct dependencies and the second tab shows all libraries it depends on transitively.

@@dependencies{ projectId="core" }


## Contributing

Please feel free to contribute to Akka and Akka Persistence Couchbase Documentation by reporting issues you identify, or by suggesting changes to the code. Please refer to our [contributing instructions](https://github.com/akka/akka/blob/master/CONTRIBUTING.md) to learn how it can be done.

We want Akka to strive in a welcoming and open atmosphere and expect all contributors to respect our [code of conduct](https://www.lightbend.com/conduct).
