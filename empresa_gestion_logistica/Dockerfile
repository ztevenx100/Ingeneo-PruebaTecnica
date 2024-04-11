# Utiliza una imagen base que contenga Java
FROM openjdk:17-jdk-alpine

# Copia el archivo JAR generado de tu proyecto al contenedor
COPY target/empresa_gestion_logistica-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]