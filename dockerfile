# Usamos una imagen base 
FROM maven AS build

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos los archivos del proyecto al directorio de trabajo
COPY . /app

# Ejecutamos maven para construir el proyecto
RUN maven clean install

# Creamos una nueva imagen basadaa en openJDK
FROM openjdk:17

EXPOSE 8080

COPY --from=build /app/target/marmoles-aleyanas-back-0.0.1-SNAPSHOT.jar /app/marmoles-aleyanas-back-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/marmoles-aleyanas-back-0.0.1-SNAPSHOT.jar"]