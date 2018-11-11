#!/bin/sh

PRJ_NAME=$1

mvn archetype:generate -DgroupId=com.henry.hello -DartifactId=${PRJ_NAME} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
