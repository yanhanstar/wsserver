package org.learnhow.ws.server;

import org.learnhow.ws.schema.Country;
import org.learnhow.ws.schema.Currency;
import org.learnhow.ws.schema.Language;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanh
 * @create 2019/11/26 18:23
 * @description 业务逻辑
 */
@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        Language spanish = new Language();
        spanish.setName("spanish");
        spain.setLanguage(spanish);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        Language polish = new Language();
        polish.setName("polish");
        poland.setLanguage(polish);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);
        Language english = new Language();
        english.setName("english");
        uk.setLanguage(english);

        countries.put(spain.getName(), spain);
        countries.put(poland.getName(), poland);
        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
