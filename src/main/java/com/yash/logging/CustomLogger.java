package com.yash.logging;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class CustomLogger {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomLogger.class);

    public static void sqlLog(String query) {
        logger.info("Query: " + query);
    }
}
