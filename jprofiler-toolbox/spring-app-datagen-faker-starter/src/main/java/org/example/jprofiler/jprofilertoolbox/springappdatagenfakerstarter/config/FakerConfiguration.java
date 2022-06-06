package org.example.jprofiler.jprofilertoolbox.springappdatagenfakerstarter.config;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ConfigurationProperties(prefix = "spring.faker")
@ConditionalOnMissingBean({Faker.class, FakeValuesService.class})
public class FakerConfiguration {

    private String defaultLang = Locale.FRANCE.getLanguage();

    @Bean
    public FakeValuesService fakeValuesService() {
        return new FakeValuesService(new Locale(defaultLang), new RandomService());
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
