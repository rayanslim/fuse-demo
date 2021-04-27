# Camel Route Metrics


### Pre-requisite

Set up an instance of artemis MQ in your local machine and run it on the default port 61616

### Packaging

Package the application into a jar with

    mvn clean install

### Run JMX exporter with application

    java -javaagent:./jmx_prometheus_javaagent-0.15.0.jar=8080:my-prometheus-config.yaml
-jar .\target\camel-ose-springboot-xml-1.0.0-SNAPSHOT.jar 


If your code doesn't compile due to HTTP blockers, use maven 3.6.3.