ARG BUILD_IMAGE=maven:3.5.3-jdk-8
ARG RUNTIME_IMAGE=openjdk:8-alpine

#############################################################################################
###                Stage where Docker is pulling all maven dependencies                   ###
#############################################################################################
FROM ${BUILD_IMAGE} as dependencies

WORKDIR /app

COPY pom.xml ./

RUN mvn -B dependency:go-offline
#############################################################################################

#############################################################################################
###              Stage where Docker is building spring boot app using maven               ###
#############################################################################################
FROM dependencies as build

COPY src ./src

RUN mkdir ./target

RUN mvn -B clean package

#############################################################################################

#############################################################################################
###                                       Main stage                                      ###
#############################################################################################

FROM ${RUNTIME_IMAGE} as main

ARG PROJECT_NAME

EXPOSE 8080

COPY --from=build /app/target/*.jar /app/service.jar

RUN apk update && apk upgrade

CMD ["/usr/bin/java", "-jar", "/app/service.jar"]
#############################################################################################