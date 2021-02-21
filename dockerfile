FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=build/libs/audit-log-presenter-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} auditLogPresenter.jar
ENTRYPOINT ["java","-jar","/auditLogPresenter.jar"]