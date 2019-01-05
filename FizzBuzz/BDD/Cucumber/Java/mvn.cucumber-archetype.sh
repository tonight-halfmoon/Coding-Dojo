#! /bin/sh
mvn archetype:generate                      \
   -DarchetypeGroupId=io.cucumber           \
   -DarchetypeArtifactId=cucumber-archetype \
   -DarchetypeVersion=2.3.1.2               \
   -DgroupId=fizzbuzzkata                   \
   -DartifactId=hellocucumber               \
   -Dpackage=fizzbuzz                       \
   -Dversion=1.0.0-SNAPSHOT                 \
   -DinteractiveMode=false                  \
