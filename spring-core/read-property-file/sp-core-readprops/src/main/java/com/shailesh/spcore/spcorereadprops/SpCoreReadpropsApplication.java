package com.shailesh.spcore.spcorereadprops;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
@Configuration
@PropertySource({
        "classpath:my.property.properties",
        "classpath:my.property.two.properties"
})
/**
 * Spring boot application
 */
public class SpCoreReadpropsApplication {

    /**
     * Spring boot loader.
     *
     * @param args
     */
	public static void main(final String[] args) {
		SpringApplication.run(SpCoreReadpropsApplication.class, args);
	}
}
