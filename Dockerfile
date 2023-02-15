
FROM maven:3.6.3-jdk-8 as maven_builder
# copy the source tree and the pom.xml to our new container
COPY ./ ./
# package our application code
RUN mvn clean package
FROM tomcat:8.5.43-jdk8
COPY --from=maven_builder /target/**.war /usr/local/tomcat/webapps/beautoiioticonxx.war



EXPOSE 8080
