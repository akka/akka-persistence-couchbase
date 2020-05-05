# Getting Started

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

The plugin is published for Scala 2.11 and 2.12. 


## Bucket

You will need to create a bucket, called `akka` (configurable through `couchbase-journal.write.bucket`) and 
the indexes below.  

## Required indexes

The following global secondary indexes needs to be created for the plugins to function:

The journal requires the indexes

```
CREATE INDEX `persistence-ids` on `akka` (`persistence_id`) 
  WHERE `type` = "journal_message"
  
CREATE INDEX `sequence-nrs` on `akka` 
  (DISTINCT ARRAY m.sequence_nr FOR m in messages END) 
  WHERE `type` = "journal_message"
```

If you will be using the query side with event-for-tags the following two indexes will also be required:

```
CREATE INDEX `tags` ON 
`akka`((ALL (ARRAY (ALL (ARRAY [`t`.`tag`, `m`.`ordering`] FOR `t` IN (`m`.`tags`) END)) FOR `m` IN `messages` END))) 
WHERE (`type` = "journal_message")

CREATE INDEX `tag-seq-nrs` ON 
`akka`((ALL (ARRAY (ALL (ARRAY [`persistence_id`, `t`.`tag`, `t`.`seq_nr`] FOR `t` IN `m`.`tags` END)) FOR `m` IN `messages` END))) 
WHERE (`type` = "journal_message")
```

The snapshot plugin requires an additional index:

```
CREATE INDEX `snapshots` ON `akka` (persistence_id, sequence_nr) 
  WHERE akka.type = "snapshot"
```

Note that the specific aliases used (`m`) for the arrays must not be changed or the indexes will not actually be used.
