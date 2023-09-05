package com.gms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is @GrievanceManagementApplicaton class.
 */
@SpringBootApplication
public class GrievanceManagementApplication {
    /**
     * This is @main method.
     * @param args
     */
     public static void main(final String[] args) {
       SpringApplication.run(GrievanceManagementApplication.class, args);
     }
     /**
     * This is constructor.
     */
     protected GrievanceManagementApplication() {
     }
}
