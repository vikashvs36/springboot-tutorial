package com.springBootTutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(name = "/logger", method = RequestMethod.GET)
    public void printLog() {
        LOGGER.error("{} logged at ERROR level", "LoggerController");
        LOGGER.warn("{} logged at WARN level", "LoggerController");
        LOGGER.info("{} logged at INFO level", "LoggerController");
        LOGGER.debug("{} logged at DEBUG level", "LoggerController");
    }

}
