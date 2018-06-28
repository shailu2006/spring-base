package com.shailesh.spcore.spcorereadprops;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
public class SpCoreReadpropsApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(SpCoreReadpropsApplication.class, args);
	}*/

	@Bean
	public CsvMapper getCsvMapper(){
		return new CsvMapper();
	}
}
