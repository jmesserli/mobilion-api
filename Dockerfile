FROM openjdk:8-jre-alpine

VOLUME /tmp

RUN apk add --no-cache tzdata \
    && cp /usr/share/zoneinfo/Europe/Zurich /etc/localtime \
    && apk del --no-cache tzdata

ADD build/libs/mobilion-api-*.jar springApp.jar
RUN sh -c 'touch /springApp.jar'
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /springApp.jar"]