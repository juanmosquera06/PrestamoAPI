# Backend Developer Challenge
##  Introducción

El API Rest permite realizar la gestión de los préstamos que se les otorga a los clientes según ciertas condiciones dadas. Adicionalmente, permite aplicar pagos a la deuda del préstamos y consultar la deuda de los diferentes préstamos.

Para el desarrollo de la API se hizo uso de [Spring Boot](https://spring.io/projects/spring-boot "Spring Boot") añadiendo las siguientes dependencias al proyecto:

- Web (spring-boot-starter-web) para el desarrollo de la API usando el modelo MVC.
- Test (spring-boot-starter-test) para la creación de los test unitarios con JUnit y Mockito.
- JPA (spring-boot-starter-data-jpa) para el manejo de la persistencia de la data en memoria (H2)
- OpenAPI (springdoc-openapi-ui) para el manejo de la documentación de la API con Swagger.
- Lombok (lombok) para la generación automática de getters, setters, constructores, etc.
- Mapper (mapstruct) para generar mapeadores de tipos entre DTO's y entidades de negocio para evitar exponerlas.

Se generaron los diferentes DTO's, entidades de negocio (persistencia), controladores, excepciones, lógica de negocio y utilidades para el proyecto. Se separaron responsabilidades en los diferentes paquetes de la aplicación:

    co.com.meli.microservice.controller
	co.com.meli.microservice.dto
	co.com.meli.microservice.enums
	co.com.meli.microservice.exception
	co.com.meli.microservice.persistence.data
	co.com.meli.microservice.repository
	co.com.meli.microservice.service
	co.com.meli.microservice.util

Se creó una clase de constantes para manejar los diferentes mensajes de error, documentación, etc.

En el archivo de properties se encuentra las diferentes configuraciones de contexto, documentación y capa de persistencia de datos.  Toda la seed de base de datos con la información precargada se encuentra en el archivo [script_insert_records.sql](https://github.com/juanmosquera06/PrestamoAPI/blob/main/prestamo-api/src/main/resources/script_insert_records.sql "script_insert_records.sql"). 

Se generaron los diferentes test unitarios de lógica de negocio con una cobertura por encima del 70%.

## Documentación
La API fue dockerizada y se encuentra desplegada en la nube, por lo tanto se puede acceder a la documentación de la misma a través de la siguiente URL:

OpenAPI definition: http://ec2-54-210-101-17.compute-1.amazonaws.com:8080/credit/swagger-ui/index.html

![](https://i.ibb.co/JsVKjqG/Swagger.png)

## Instalación

1. Clonar el repositorio donde se encuentra la API desde una terminal.
```shell
git clone git@github.com:juanmosquera06/PrestamoAPI.git
```
2. Entrar a la carpeta del proyecto PrestamoAPI.
```shell
cd PrestamoAPI
```
3. Realizar la instalación del proyecto con el arquetipo de maven
```shell
mvn clean install
```
4. Una vez realizado el paso anterior, se procede a lanzar la aplicación con spring boot.
```shell
mvn spring-boot:run
```
5. Se empezará a realizar el despliegue de la aplicación. Una vez se haya iniciado correctamente se puede proceder a realizar test de los diferentes endpoint que se mencionan en la documentación.

    Started CreditApiApplication in 8.93 seconds (JVM running for 11.002))

## Testear la aplicación
Si desea testear la aplicación, puede hacerlo a través de Postman (los endpoint se encuentran en la documentación) importando la siguiente colección:

https://www.getpostman.com/collections/dc053e660c475eeb6da0

A través de la [OpenAPI definition](ec2-54-210-101-17.compute-1.amazonaws.com:8080/credit/swagger-ui/index.html "OpenAPI definition") también se puede realizar los diferentes test a la API Rest.