FROM openjdk:17
LABEL authors="fox"
WORKDIR usr/src/app
COPY ./src/main/java .
RUN javac -sourcepath . -d out ./Pegas/Lection1/GameStart.java
WORKDIR /usr/src/app/out
CMD ["java","-classpath",".","Pegas.Lection1.GameStart"]