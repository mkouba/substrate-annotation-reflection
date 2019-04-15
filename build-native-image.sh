#!/bin/bash

if [ -z $GRAALVM_HOME ]
then
     echo "Error: please point the $GRAALVM_HOME environment variable to your GraalVM installation."
     exit 1
fi

# Build application
mvn clean package

# Build the native image
$GRAALVM_HOME/bin/native-image --no-server \
             --class-path target/substrate-annotation-reflection-0.0.1-SNAPSHOT.jar \
             -H:Name=substrate-annotation-reflection \
             -H:Class=com.github.mkouba.Main \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+PrintAnalysisCallTree
