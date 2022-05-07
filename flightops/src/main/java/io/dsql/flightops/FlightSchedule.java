package io.dsql.flightops;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class FlightSchedule {

	private final static String NODE_VAL = "value";
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

	@JsonProperty("flight_no")
	void unWrapFlightNo(Map<String, String> record) {
		flightNo = text(record);
	}

	@JsonProperty("scheduled_date")
	void unWrapScheduledDate(Map<String, String> record) {
		scheduledDate = date(record);
	}

	@JsonProperty("origin")
	void unWrapSource(Map<String, String> record) {
		origin = text(record);
	}

	@JsonProperty("destination")
	void unWrapDestination(Map<String, String> record) {
		destination = text(record);
	}

	@JsonProperty("sta")
	void unWrapSta(Map<String, String> record) {
		sta = instant(record);
	}

	@JsonProperty("eta")
	void unWrapEta(Map<String, String> record) {
		eta = instant(record);
	}

	@JsonProperty("ata")
	void unWrapAta(Map<String, String> record) {
		ata = instant(record);
	}

	@JsonProperty("std")
	void unWrapStd(Map<String, String> record) {
		std = instant(record);
	}

	@JsonProperty("etd")
	void unWrapEtd(Map<String, String> record) {
		etd = instant(record);
	}

	@JsonProperty("atd")
	void unWrapAtd(Map<String, String> record) {
		atd = instant(record);
	}

	@JsonProperty("scheduled_bay_id")
	void unWrapScheduledBayId(Map<String, String> record) {
		scheduledBayId = text(record);
	}

	@JsonProperty("actual_bay_id")
	void unWrapActualBayId(Map<String, String> record) {
		actualBayId = text(record);
	}

	private String text(Map<String, String> record) {
		return record.get(NODE_VAL);
	}

	private LocalDate date(Map<String, String> record) {
		return LocalDate.ofEpochDay(Long.parseLong(record.get(NODE_VAL)));
	}

	private Instant instant(Map<String, String> record) {
		return Instant.ofEpochMilli(Long.parseLong(record.get(NODE_VAL)));
	}

}
