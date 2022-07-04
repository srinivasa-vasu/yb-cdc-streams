package io.dsql.flightops;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import static io.dsql.flightops.FlightDelayRule.Mode.A;
import static io.dsql.flightops.FlightDelayRule.Mode.D;
import static java.time.Duration.between;

@Getter
public enum FlightDelayRule {

	GROUND_OPS(15, A), CREW_OPS(10, D), MRO_OPS(30, A);

	private int delay;

	private Mode mode;

	FlightDelayRule(int delay, Mode mode) {
		this.delay = delay;
		this.mode = mode;
	}

	static List<String> notifyList(FlightSchedule schedule) {
		var list = new ArrayList<String>();
		for (FlightDelayRule record : FlightDelayRule.values()) {
			switch (record.getMode()) {
			case A -> {
				if (schedule.sta() != null && schedule.eta() != null) {
					if (between(schedule.sta(), schedule.eta()).toMinutes() >= record.getDelay()) {
						list.add(record.name());
					}
				}
			}
			case D -> {
				if (schedule.std() != null && schedule.etd() != null) {
					if (between(schedule.std(), schedule.etd()).toMinutes() >= record.getDelay()) {
						list.add(record.name());
					}
				}
			}
			}
		}
		return list;
	}

	enum Mode {

		A, D;

	}

}
