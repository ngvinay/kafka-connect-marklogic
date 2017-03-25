# Overview

Kafka Connect MarkLogic is a sink only connector (move message from Kafka to MarkLogic). 

![Kafka Connect MarkLogic](kafka-connect-ml-1.png)

## Implementation details 

To send data to MarkLogic, this connector make use of MarkLogic REST api. By default the /v1/documents endpoint at port 8000 is used. You may change that in the marklogic-sink.properties file. You may use a REST extension instead of the out of the box document API to do any transformation on the way in.

## How to deploy the connector in Kafka?

This is a maven project. Do a mvn clean install, and it will produce an artifact "marklogic-kafka-connector-0.0.1-SNAPSHOT.jar". Create a folder inside the kafka_home/lib and drop the above said jar and it's dependencies. 

Copy the marklogic-sink.properties file into kafka_home/conf folder. Update the content of the property file as per your environment.

Alternatively, you may choose to keep the jar files in a directory of your choice and export that directory into class path before starting the connector.

## How to start connector in standalone mode?

Open a shell prompt and move to kafka_home and execute the following.

bin/connect-standalone.sh config/connect-standalone.properties config/marklogic-sink.properties

## How to produce some message?

To create some test message use the MessageFactory class in the test source. Update the environment details like host, port and topic in the MessageFactory as per your environment.

## Looking for source connector?

Please create an issue. I shall write that for you.

## How to contact the author?

Create an issue in the GitHub or send an email to ml@sanju.org
 


