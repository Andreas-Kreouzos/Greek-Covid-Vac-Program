package com.andrekreou.covid.gov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity()
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Covid {
    @Id
    @SequenceGenerator(
            name = "covid_sequence",
            sequenceName = "covid_sequence",
            allocationSize = 1
            )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "covid_sequence"
    )
    private Integer id;
    private String area;
    private Integer areaid;
    private String referencedate;
    private Integer totaldose1;
    private Integer totaldose2;
    private Integer totaldose3;
    private Integer totalvaccinations;
}