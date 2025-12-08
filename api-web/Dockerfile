
FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /app
COPY .. /app
RUN mvn -q -DskipTests package -pl api-web -am

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/api-web/target/api-web-1.0.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-Xmx512m"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"] 
