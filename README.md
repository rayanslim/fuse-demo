# Camel Route Metrics


### Pre-requisite

Set up an instance of artemis MQ in your local machine and run it on the default port 61616

### Packaging

Package the application into a jar with

    mvn clean package

### Run JMX exporter with application

    java -javaagent:./jmx_prometheus_javaagent-0.15.0.jar=8080:my-prometheus-config.yaml -jar .\target\camel-ose-springboot-xml-1.0.0-SNAPSHOT.jar 

The command runs the application and configures the jmx exporter to expose camel metrics on port 8080 (configurable). 

If your code doesn't compile due to HTTP blockers, the easiest solution is to use maven 3.6.3.
Or, see: https://stackoverflow.com/questions/66980047/maven-build-failure-dependencyresolutionexception 