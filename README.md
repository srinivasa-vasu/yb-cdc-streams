# CDC in YugabyteDB using Spring Cloud Data Streams

CDC streams to consume, analyse and enrich data from (point) a to (point) b to (point) z.

It is based on [spring-cloud-stream] (https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/) integration framework to provide an easy-to-use, consistent developer experience to capture, analyze and enrich data processing pipelines across different systems.

## Sample business case

The flight schedule change information from the source system is captured in real-time and sent to a processing pipeline that applies specific 
business rules based on the delay in the arrival and departure time to send notifications to the appropriate internal aircraft and customer servicing units.

We use the following services to build the data streaming pipelines:
* YugabyteDB YSQL is the source database that generates the flight schedule
* [flightschedule](flightschedule) stream supplier captures the flight schedule change events using debezium source, and streams them through a Kafka binder topic (flight_ops)
* [flightops](flightops) gets the schedule change events from the flight_ops topic, runs the rule processing, populates the notification event, and streams them through a Kafka binder topic (flight_watch)
* [flightwatch](flightwatch) gets the notification events from the flight_watch topic and persists them in the target database
* YugabyteDB YCQL is the target database to keep the notification events.

![data-pipeline](assets/data-pipeline.png)
