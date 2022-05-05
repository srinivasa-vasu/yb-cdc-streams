package io.dsql.flightwatch;

import java.time.LocalDate;

import lombok.Data;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import static org.springframework.data.cassandra.core.cql.Ordering.ASCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@PrimaryKeyClass
@Data
public class FlightWatchKey {

	@PrimaryKeyColumn(type = PARTITIONED, ordinal = 0)
	private String flightNo;

	@PrimaryKeyColumn(type = CLUSTERED, ordering = ASCENDING)
	private LocalDate scheduledDate;

}
