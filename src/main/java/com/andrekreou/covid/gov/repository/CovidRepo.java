package com.andrekreou.covid.gov.repository;

import com.andrekreou.covid.gov.model.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepo
        extends JpaRepository<Covid,Integer> {

    @Query(value = "SELECT * FROM covid WHERE referencedate = :referencedate", nativeQuery = true)
    List<Covid> findByReferenceDate(@Param("referencedate") String referencedate);
}
