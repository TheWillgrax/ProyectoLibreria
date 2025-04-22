# Imagen base de Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el .jar generado por Maven al contenedor
COPY target/*.jar app.jar

# Expone el puerto 10000 (Render lo necesita)
EXPOSE 10000

# Comando para correr Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=10000"]
