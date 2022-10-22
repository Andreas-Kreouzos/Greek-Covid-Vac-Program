# Greek Covid Vaccination Program


This project is part of the final examination of the course "Medical IT"
of Master of Science Program "Informatics" currently organised by University of Piraeus - Greece.

The purpose of this project is to consume an external API which provides
the data as JSON format and then expose these data with the necessary
view in an HTML Thymeleaf template.

#### Languages and Tools:
<div>
  <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="100" height="100"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" title="Spring" alt="Spring" width="100" height="100"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/intellij/intellij-original.svg" title="IntelliJ" alt="IntelliJ" width="100" height="100"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/postgresql/postgresql-original-wordmark.svg" title="PostgreSQL" alt="PostgreSQL" width="100" height="100"/>&nbsp;
</div>

## Spring Security

The project has a very simple implementation of Spring Security, which handles the login
and logout pages. For that reason, a separate login.html was created for the necessary
checking of the user credentials. The latter are being created with a ```@Bean``` of the class
```UserDetailsService``` via its builder method. For the creation of the password, the ```PasswordEncoder```
class was used.

## POJO Class

For the creation of the POJO Class the next JSON file was needed to be consumed. This file
contains fields specifically for the Covid-19 Vaccination Initiative which was called "Operation Liberty"
in Greece. The consumed URL fetches results for the dates between 2022-07-30 to 2022-07-31.
Of course, those dates could be modified according to the instructions of the API but for reasons
of demonstration, only these two were chosen.

<br>

<img width="812" alt="Consuming JSON" src="https://user-images.githubusercontent.com/77160233/197342597-8b8a8e64-065e-42f8-b608-101280cfcc80.png">

In order to use this URL, it was necessary to provide additional authentication to the API. To be
specific, an API key was needed that was produced as soon as the subscription to the API was completed.
The final form of the POJO class was the following:

```java
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
```

## Display Data Based on Specific Date

By default, the data that's been stored in the PostgreSQL database refers to the aforementioned dates. But
for the controller class, it was necessary for the users to have access to the vaccination data for each date
independently. Thus, the creation of a new view for the setting of date was mandatory and a ```POST``` request to
grab it. The latter was then passed via a Model object to the service class and finally to the Repository Class,
all via dependency injection with ```@Autowired``` annotation.