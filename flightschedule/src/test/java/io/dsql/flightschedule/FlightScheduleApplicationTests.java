package io.dsql.flightschedule;

import org.junit.jupiter.api.Test;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlightScheduleApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCDCEventSource() {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration.getCompleteConfiguration(FlightScheduleApplication.class))
				.web(WebApplicationType.NONE).run()) {
			OutputDestination target = context.getBean(OutputDestination.class);
			Message<byte[]> sourceMessage = target.receive(10000);
			assertThat(sourceMessage).isNotNull();
		}
	}

}
