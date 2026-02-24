# Usamos una imagen ligera de Java 21 (solo el entorno de ejecución)
FROM eclipse-temurin:21-jre-alpine

# Creamos un directorio de trabajo
WORKDIR /app

# Copiamos el JAR generado por el pipeline en el paso anterior
COPY target/*.jar app.jar

# Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]