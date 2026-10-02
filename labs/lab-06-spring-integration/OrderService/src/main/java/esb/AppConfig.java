package esb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The RestTemplate lives here rather than on OrderApplication.
 *
 * Declaring the bean inside the same class that injects it makes Spring depend
 * on OrderApplication to build the RestTemplate while OrderApplication is
 * waiting for that same RestTemplate - a circular reference, which Spring Boot
 * rejects by default since 2.6.
 */
@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}