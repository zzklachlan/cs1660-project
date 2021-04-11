FROM ubuntu:20.04

COPY . /Users/kai/toolbox
WORKDIR /Users/kai/toolbox

ENV DEBIAN_FRONTEND=noninteractive
RUN apt update && apt install -y openjdk-8-jre openjdk-8-jdk firefox python3.8 git xterm spyder3
RUN javac Toolbox.java
CMD ["java", "Toolbox"]