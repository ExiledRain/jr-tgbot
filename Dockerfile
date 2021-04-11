FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrc_bot
ENV BOT_TOKEN=1743821223:AAFnZOxAlxyz4UC4P_WfwVulJFP1_8rk4sA
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}","-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]