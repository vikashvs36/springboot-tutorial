package com.springBootTutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootTutorialApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTutorialApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

	@RequestMapping("/main")
	public void logPrint() {
		LOGGER.error("{} logged at ERROR level", "SpringBootTutorialApplication");
		LOGGER.warn("{} logged at WARN level", "SpringBootTutorialApplication");
		LOGGER.info("{} logged at INFO level", "SpringBootTutorialApplication");
		LOGGER.debug("{} logged at DEBUG level", "SpringBootTutorialApplication");
	}

}
