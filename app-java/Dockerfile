FROM openjdk:17
RUN mkdir -p /usr/src/myapp
COPY /target/*.jar /usr/src/myapp
WORKDIR /usr/src/myapp
ENV JAVA_TOOL_OPTIONS=-Xmx3489m
CMD ["java", "-jar","app-0.0.1-SNAPSHOT.jar"]