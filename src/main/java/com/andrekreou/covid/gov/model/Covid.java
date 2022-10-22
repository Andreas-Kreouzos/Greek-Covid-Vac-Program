package com.andrekreou.covid.gov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity()
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public Covid() {
    }

    public Covid(Integer id,
                 String area,
                 Integer areaid,
                 String referencedate,
                 Integer totaldose1,
                 Integer totaldose2,
                 Integer totaldose3,
                 Integer totalvaccinations) {
        this.id = id;
        this.area = area;
        this.areaid = areaid;
        this.referencedate = referencedate;
        this.totaldose1 = totaldose1;
        this.totaldose2 = totaldose2;
        this.totaldose3 = totaldose3;
        this.totalvaccinations = totalvaccinations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getReferencedate() {
        return referencedate;
    }

    public void setReferencedate(String referencedate) {
        this.referencedate = referencedate;
    }

    public Integer getTotaldose1() {
        return totaldose1;
    }

    public void setTotaldose1(Integer totaldose1) {
        this.totaldose1 = totaldose1;
    }

    public Integer getTotaldose2() {
        return totaldose2;
    }

    public void setTotaldose2(Integer totaldose2) {
        this.totaldose2 = totaldose2;
    }

    public Integer getTotaldose3() {
        return totaldose3;
    }

    public void setTotaldose3(Integer totaldose3) {
        this.totaldose3 = totaldose3;
    }

    public Integer getTotalvaccinations() {
        return totalvaccinations;
    }

    public void setTotalvaccinations(Integer totalvaccinations) {
        this.totalvaccinations = totalvaccinations;
    }

    @Override
    public String toString() {
        return "Covid{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", area_id=" + areaid +
                ", referencedate='" + referencedate + '\'' +
                ", totaldose1=" + totaldose1 +
                ", totaldose2=" + totaldose2 +
                ", totaldose3=" + totaldose3 +
                ", totalvaccinations=" + totalvaccinations +
                '}';
    }
}