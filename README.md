# graphql-demo

GraphQL Demo

## Requirements

For building and running the application you need:

- [JDK 11](https://jdk.java.net/11/)
- [Maven 3](https://maven.apache.org)

## Running the application locally

The project consists of two modules: `config-server` and `investment-service`, to run `investment-service` where the entire API is available, first `config-server` must be up and running.

`config-server` use {cipher} encrypt method to store password to config github repository, so `config-server` must be run with '-Dencrypt.key=salting' VM option

To run `investment-service` as Spring Boot application on your local machine - execute the `main` method in the `com.graphql.investment.service.InvestmentServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

To use other database than embedded RAM overwrite following properties in IDE/mvn settings:
```shell
-Dspring.datasource.url=jdbc:h2:file:./data/demo   // jdbc url
-Dspring.sql.init.mode=never                       // control whether to run initial script
```
