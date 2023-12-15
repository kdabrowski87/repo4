# Stage 1: Build stage
FROM amazoncorretto:17-alpine3.18-jdk AS build
RUN apk update
RUN apk add maven

WORKDIR /app
COPY . .
RUN mvn package

# Stage 2: Run stage
FROM amazoncorretto:17-alpine3.18

#RUN adduser -D -s /sbin/nologin javauser
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
#USER javauser

CMD ["java", "-jar", "app.jar"]
#CMD ["/bin/sh"]