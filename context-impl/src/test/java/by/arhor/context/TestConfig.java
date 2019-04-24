package by.arhor.context;

import by.arhor.context.annotation.Bean;
import by.arhor.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public String stringBean() {
        return "I'm a very first bean!";
    }

}
