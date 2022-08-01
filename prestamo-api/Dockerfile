# Start with JDK.
# tag::from[]
FROM openjdk:8
# end::from[]

# Add resource.
# tag::add[]
ADD /target/prestamo-api-0.0.1-SNAPSHOT.jar credit-microservice.jar
# end::add[]

# Mapping ports.
# tag::expose[]
EXPOSE 8080
# end::expose[]

# tag::entrypoint[]
ENTRYPOINT ["java","-jar","/credit-microservice.jar"]
# end::entrypoint[]