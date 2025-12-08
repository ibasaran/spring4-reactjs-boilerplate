
FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /app
COPY .. /app
RUN mvn -q -DskipTests package -pl security -am

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/security/target/security-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh","-c","java -jar /app/app.jar"]
