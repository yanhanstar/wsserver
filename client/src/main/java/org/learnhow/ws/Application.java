package org.learnhow.ws;

import org.learnhow.ws.client.CountryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ws.wsdl.GetCountryResponse;

/**
 * @author yanh
 * @create 2019/11/28 14:07
 * @description
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient client) {
        return args -> {
            String countryName = "Spain";

            if (args.length > 0) {
                countryName = args[0];
            }
            GetCountryResponse response = client.getCountry(countryName);
            System.out.println("response-country-name: " + response.getCountry().getName());
            System.out.println("response-country-capital: " + response.getCountry().getCapital());
        };
    }
}
