FROM openjdk:8
EXPOSE 8080
ADD target/bank_atm.jar bank_atm.jar
ENTRYPOINT [ "java", "-jar", "/bank_atm.jar" ]