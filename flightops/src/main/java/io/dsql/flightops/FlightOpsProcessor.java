package io.dsql.flightops;

import java.util.function.Function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@Configuration
@Slf4j
public class FlightOpsProcessor {

	private final ObjectMapper mapper;

	FlightOpsProcessor(ObjectMapper mapper) {
		this.mapper = mapper;
		this.mapper.registerModule(new JavaTimeModule());
		this.mapper.setVisibility(FIELD, ANY);
	}

	@Bean
	public Function<FlightSchedule, FlightWatch> flightSchedule() {
		return schedule -> {
			log.info("Schedule Change Event: " + schedule);
			var watch = mapper.convertValue(schedule, FlightWatch.class);
			watch.setNotifyOps(FlightDelayRule.notifyList(schedule));
			return watch;
		};
	}

}
