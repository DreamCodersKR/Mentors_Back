package com.dream.Mentors;

import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;

@EntityScan("com/dream/entity")
@SpringBootApplication
public class MentorsProjectApplication extends SpringBootServletInitializer implements ApplicationRunner{

	private static final Logger log = LoggerFactory.getLogger(MentorsProjectApplication.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void init() {
	    System.out.println("DataSource is: " + dataSource);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MentorsProjectApplication.class, args);
	}
	
	public void run (ApplicationArguments args) throws Exception {
		
		String [] activeProfiles = env.getActiveProfiles();
		
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		log.info("server port .......... " + env.getProperty("server.port"));
		log.info("logging file path .... " + env.getProperty("logging.file.path"));
		
		for (String profile : activeProfiles) {
			log.info("spring profiles ...... " + profile);
		}
		
		DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
		log.info("datasource driver  ... " + metaData.getDriverName());
		log.info("datasource url  ...... " + metaData.getURL());
		log.info("datasource user  ..... " + metaData.getUserName());

		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~hikari~~~~~~~~~~~~~~~~~~~~~~~~~~");
		log.info("maximum-pool-size .... " + env.getProperty("spring.datasource.hikari.maximum-pool-size"));
		log.info("minimum-idle ......... " + env.getProperty("spring.datasource.hikari.minimum-idle"));
		log.info("max-lifetime ......... " + env.getProperty("spring.datasource.hikari.max-lifetime"));
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MentorsProjectApplication.class);
	}

}
