[![Flight Watch CI](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightwatch.yml/badge.svg)](https://github.com/srinivasa-vasu/yb-cdc-streams/actions/workflows/flightwatch.yml)

## Cloud Stream Service :: Consumer

[flightwatch](./) is a spring cloud stream based consumer function that does the following: 

* consumes the notification events from the Kafka topic (flight_watch)
* persists the events in the target YugabyteDB YCQL database to notify the appropriate servicing units.
