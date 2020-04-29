package com.example.appointment;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppointmentApplication {

    private final static Logger logger = LoggerFactory.getLogger(AppointmentApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(AppointmentApplication.class, args);

        logger.info("application is running ...");

    }

}
