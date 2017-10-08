Java concurrency practice
=========================
This project contains the basic concepts and principles of working with multithreading in Java.

The basics will begin from working with threads from first versions of Java to current best practices in Java 8.

Environment
===========
This is the Maven based project, so you need to install:
1. Last version of [Maven](https://maven.apache.org/download.cgi) from official site or using command: `sudo apt-get install maven`

2. [MongoDB](https://www.mongodb.com/download-center?jmp=nav#atlas) from official site of using docker:
    
    `docker run --name mongo -v /opt/db/mongo:/data/db -e MONGODB_USER=root -e MONGODB_PASS=root -e MONGODB_DATABASE=concurrency -p 27017:27017 -d mongo:latest`
