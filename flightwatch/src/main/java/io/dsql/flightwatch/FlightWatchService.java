package io.dsql.flightwatch;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FlightWatchService {

	private final FlightWatchRepository flightWatchRepository;

	FlightWatchService(FlightWatchRepository flightWatchRepository) {
		this.flightWatchRepository = flightWatchRepository;
	}

	@Bean
	public Consumer<FlightWatch> flightNotifications() {
		return entity -> {
			log.info("Notification event: " + entity);
			var notify = entity.getNotifyOps();
			if (notify != null && !notify.isEmpty()) {
				log.info("Triggering the notification: " + notify);
				flightWatchRepository.save(entity);
			}
			else {
				log.info("Ignored the notification list as it is empty");
			}
		};
	}

}
