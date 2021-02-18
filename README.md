## Merchant Service

Service offers Rest APIs to create New Merchants and Offers. 

Microservice is built using SpringBoot and H2 database

## Schema and Dummy Data
`schema-h2.sql` and `data-h2.sql` can be found under the `src/main/resource` folder

## Starting Project

Run `MerchantServiceApp.java` to start the application. Application runs on `8090` port which can be configured in `application.properties` file.
Once started, Swagger API documentation can be found from `http://localhost:8090/swagger-ui.html`

## Building Jar

Project uses `spring-boot-maven-plugin`, run `mvn clean -DskipTests package spring-boot:repackage` to build an executable jar
