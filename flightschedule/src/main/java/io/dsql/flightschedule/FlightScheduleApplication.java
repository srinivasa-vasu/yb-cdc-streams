package io.dsql.flightschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.fn.supplier.cdc.CdcSupplierConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CdcSupplierConfiguration.class)
public class FlightScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightScheduleApplication.class, args);
	}

}
