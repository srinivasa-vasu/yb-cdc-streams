package io.dsql.flightwatch;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightWatchRepository extends CassandraRepository<FlightWatch, FlightWatchKey> {
}
