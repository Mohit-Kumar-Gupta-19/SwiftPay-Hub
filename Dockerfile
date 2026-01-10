FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY lib ./lib
COPY src ./src

RUN javac -cp "lib/*" src/db/*.java src/util/*.java src/service/*.java src/Main.java

CMD ["java", "-cp", "lib/*:src", "Main"]
