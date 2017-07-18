package za.co.deltaceti.samples.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DriversApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriversApplication.class, args);
    }
}
