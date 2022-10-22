package com.andrekreou.covid.gov.service;

import com.andrekreou.covid.gov.model.Covid;
import com.andrekreou.covid.gov.repository.CovidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceProvider {

    private final CovidRepo covidRepo;

    @Autowired
    public ServiceProvider(CovidRepo covidRepo) {
        this.covidRepo = covidRepo;
    }

    public List<Covid> showAllCases(){
        return new ArrayList<>(covidRepo.findAll());
    }

    public List<Covid> showCases(String referencedate){
        return new ArrayList<>(covidRepo.findByReferenceDate(referencedate));
    }
}
