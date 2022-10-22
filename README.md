# Greek Covid Vaccination Program


This project is part of the final examination of the course "Medical IT"
of MSc Program "Informatics" currently organised by University of Piraeus.

The purpose of this project is to consume an external API which provides
the necessary data as JSON format and then expose these data with the necessary
view in a HTML Thymeleaf template.

#### Languages and Tools:
<div>
  <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="60" height="60"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" title="Spring" alt="Spring" width="60" height="60"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/intellij/intellij-original.svg" title="IntelliJ" alt="IntelliJ" width="60" height="60"/>&nbsp;
</div>

## Spring Security

The project has a very simple implementation of Spring Security, which handles the login
and logout pages. For that reason, a separate login.html was created for the necessary
checking of the user credentials. The latter are being created with a @Bean of the class
UserDetailsService via its builder method. For the creation of the password, the PasswordEncoder
Class was used.

## POJO Class

For the creation of the POJO Class the next JSON file was needed to be consumed. This file
contains fields specifically for the Covid-19 Vaccination Initiative which was called "Operation Liberty"
in Greece. The consumed URL fetches results for the dates between 2022-07-30 to 2022-07-31.
Of course, these dates could be modified according to the instructions of the API but for reasons
of demonstration, only these two dates were chosen.

<img width="812" alt="Consuming JSON" src="https://user-images.githubusercontent.com/77160233/197342597-8b8a8e64-065e-42f8-b608-101280cfcc80.png">
