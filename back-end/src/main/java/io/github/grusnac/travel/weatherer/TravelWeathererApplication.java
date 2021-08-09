package io.github.grusnac.travel.weatherer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Configuration
@SpringBootApplication
public class TravelWeathererApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelWeathererApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ConversionService conversionService(Collection<Converter<?,?>> converters) {
        final DefaultConversionService defaultConversionService = new DefaultConversionService();
        converters.forEach(defaultConversionService::addConverter);
        return defaultConversionService;
    }

}
