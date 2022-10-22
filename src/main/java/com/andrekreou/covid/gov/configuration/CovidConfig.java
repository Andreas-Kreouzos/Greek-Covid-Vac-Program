package com.andrekreou.covid.gov.configuration;

import com.andrekreou.covid.gov.model.Covid;
import com.andrekreou.covid.gov.repository.CovidRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class CovidConfig {

    @Bean
    CommandLineRunner commandLineRunner(CovidRepo covidRepo){
        return args -> {

            String url = "https://data.gov.gr/api/v1/query/mdg_emvolio?date_from=2022-07-30&date_to=2022-07-31";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set("Authorization","Token 8329eb4fa30e567d9e3f6bfed266c8cb4c9c94ad");

            HttpEntity<Object> request = new HttpEntity<>(headers);

            ResponseEntity<List<Covid>> postEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    request,
                    new ParameterizedTypeReference<>() {
                    });

            List<Covid> covidList = postEntity.getBody();
            assert covidList != null;
            covidRepo.saveAll(covidList);
            System.out.println(covidList);
        };
    }
}
