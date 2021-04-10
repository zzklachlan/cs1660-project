FROM ubuntu:20.04

COPY . /Users/kai/toolbox
WORKDIR /Users/kai/toolbox

ENV DEBIAN_FRONTEND=noninteractive
RUN apt update && apt install -y openjdk-8-jre openjdk-8-jdk firefox python3.8 git xterm
# RUN curl -s -O https://raw.githubusercontent.com/compdatasci/spyder-desktop/master/spyder_desktop.py
# RUN echo "python3 spyder_desktop.py -p" > spyder
# RUN chmod +x spyder
RUN javac Toolbox.java
CMD ["java", "Toolbox"]