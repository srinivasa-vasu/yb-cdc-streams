package io.dsql.flightops;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class FlightWatch {

	private String flightNo;

	private LocalDate scheduledDate;

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
