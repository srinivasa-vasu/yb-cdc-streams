[![Flight Schedule CI](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightschedule.yml/badge.svg?branch=main)](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightschedule.yml)

## Cloud Stream Service :: Supplier

[flightschedule](./) is based on the [Debezium CDC Source](https://github.com/spring-cloud/stream-applications/blob/master/applications/source/cdc-debezium-source/README.adoc) cloud-stream app that does the following:

* captures the flight schedule changes from the YugabyteDB YSQL source through the CDC API
* streams the schedule change events to a Kafka binder topic (flight_ops). 

Look at the [resources](src/main/resources/application.yml) file for the connectivity details to the source database.

