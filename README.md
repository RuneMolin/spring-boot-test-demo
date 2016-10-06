Experiments with Spring Boot, Maven verify plugin, Integration tests and Spock

## Hard learned lessons

### failsafe plugin
Using the plugin dependency management of spring-boot-maven-plugin is advisable.

Otherwise, you may end up with a newer version of the failsafe plugin and run into:

https://github.com/spring-projects/spring-boot/issues/6254

This is also mentioned in the Spring Boot 1.4.1 release notes:

https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-1.4-Release-Notes#integration-tests-with-the-maven-failsafe-plugin
