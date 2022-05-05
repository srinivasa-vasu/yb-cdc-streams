package io.dsql.flightwatch;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table(value = "flight_watch")
public class FlightWatch {

	@PrimaryKey
	@JsonUnwrapped
	private FlightWatchKey flightWatchKey;

	private String origin;

	private String destination;

	private Instant sta;

	private Instant eta;

	private Instant ata;

	private Instant std;

	private Instant etd;

	private Instant atd;

	private String scheduledBayId;

	private String actualBayId;

	private List<String> notifyOps;

}
