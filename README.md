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
UserDetailsService via its builder method.