FROM api-itau
ADD target/api-itau.jar api-itau.jar
ENTRYPOINT ["java", "-jar", "api-itau.jar"]