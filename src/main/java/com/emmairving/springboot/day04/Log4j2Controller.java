package com.emmairving.springboot.day04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by irving on 17/1/11.
 */
@RestController
@RequestMapping("log4j2")
public class Log4j2Controller {
    private static Logger logger = LogManager.getLogger(Log4j2Controller.class.getName());

    @RequestMapping("error")
    public String error() {
        logger.error("Log4j2Controller error method: error");
        return "error";
    }

    @RequestMapping("debug")
    public String debug() {
        logger.debug("Log4j2Controller debug method: debug");
        logger.error("Log4j2Controller debug method: error");
        return "debug";
    }
}
