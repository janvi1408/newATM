FROM openjdk:17
EXPOSE 7777
ADD target/bank_atm.jar bank_atm.jar
ENTRYPOINT [ "java", "-jar", "/bank_atm.jar" ]