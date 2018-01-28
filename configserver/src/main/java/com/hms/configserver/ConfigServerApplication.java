package com.hms.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< Updated upstream
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by samii on 1/24/18.
 */
@EnableEurekaServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String args[]) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }

=======
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	public static void main(String args[]) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
>>>>>>> Stashed changes
}
