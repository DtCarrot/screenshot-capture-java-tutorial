# Configure OS
FROM ubuntu:18.04
RUN apt-get -y update
RUN apt-get install openjdk-8-jdk -y  
RUN apt-get install curl -y
RUN apt-get install gnupg -y
# Install chrome dependencies 
RUN curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
RUN echo "deb [arch=amd64]  http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
RUN apt-get -y update
RUN apt-get install google-chrome-stable -y
RUN apt-get install wget -y
RUN apt-get install unzip -y
RUN wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip
RUN mv chromedriver /usr/bin/chromedriver
# Add environment variables
RUN export AWS_ACCESS_KEY={YOUR_AWS_ACCESS_KEY}
RUN export AWS_SECRET_ACCESS_KEY={YOUR_AWS_SECRET_ACCESS_KEY}
RUN export AWS_REGION={YOUR_AWS_REGION}
COPY target/*.jar app.jar 
ENTRYPOINT ["java", "-jar", "/app.jar"]