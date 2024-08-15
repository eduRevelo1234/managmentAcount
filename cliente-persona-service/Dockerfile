# Etapa 1: Construcción con Maven
FROM maven:3.8.1-openjdk-17 AS build

# Configura el directorio de trabajo para Maven
WORKDIR /app

# Copia solo el archivo pom.xml y descarga las dependencias.
# Esto aprovecha la caché de Docker si no ha cambiado nada en el pom.xml.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente del proyecto
COPY src /app/src

# Construye el proyecto y genera el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Creación de la imagen final con OpenJDK
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo en la imagen final
WORKDIR /app

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/cliente-persona-service-0.0.1-SNAPSHOT.jar /app/cliente-persona-service.jar

# Expone el puerto 8081 para que la aplicación sea accesible
EXPOSE 8081

# Define el comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/cliente-persona-service.jar"]
