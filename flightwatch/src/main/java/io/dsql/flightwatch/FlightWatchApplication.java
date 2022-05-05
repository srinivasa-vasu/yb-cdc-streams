package io.dsql.flightwatch;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

import static org.springframework.data.cassandra.core.mapping.NamingStrategy.SNAKE_CASE;

@SpringBootApplication
public class FlightWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightWatchApplication.class, args);
	}

	@Bean
	public CassandraMappingContext cassandraMapping(BeanFactory beanFactory, CassandraCustomConversions conversions)
			throws ClassNotFoundException {
		var context = new CassandraMappingContext();
		var packages = EntityScanPackages.get(beanFactory).getPackageNames();
		if (packages.isEmpty() && AutoConfigurationPackages.has(beanFactory)) {
			packages = AutoConfigurationPackages.get(beanFactory);
		}
		if (!packages.isEmpty()) {
			context.setInitialEntitySet(CassandraEntityClassScanner.scan(packages));
		}
		context.setSimpleTypeHolder(conversions.getSimpleTypeHolder());
		context.setNamingStrategy(SNAKE_CASE);
		return context;
	}

}
