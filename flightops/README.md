[![Flight Ops CI](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightops.yml/badge.svg)](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightops.yml)

## Cloud Stream Service :: Processor

[flightops](./) is a spring cloud stream based processor function that does the following: 

* consumes the flight schedule change events from the Kafka topic (flight_ops) 
* runs the rule processing logic 
* populates the notification event 
* streams them through a Kafka binder topic (flight_watch).
