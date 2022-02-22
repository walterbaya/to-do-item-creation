#!/bin/bash

##
sudo mysql -e "DROP DATABASE IF EXISTS todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "CREATE DATABASE todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "USE todo;"
sudo mysql -e "CREATE USER IF NOT EXISTS 'creator'@'localhost' IDENTIFIED BY 'alfa1234';"
sudo mysql -e "GRANT ALL PRIVILEGES ON todo.* TO 'creator'@'localhost';"

cd frontend/todo

sudo wget https://cdn.rawgit.com/abdennour/miscs.sh/e0aac343/killport

sudo sh killport 8080

sudo npm run serve -- --port 8080

cd ../../backend

#mvn spring-boot:run

trap 'sudo pkill -9 -f tomcat;'  SIGINT
