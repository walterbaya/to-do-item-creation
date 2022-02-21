#!/bin/bash

##
sudo mysql -e "DROP DATABASE IF EXISTS todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "CREATE DATABASE todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "USE todo;"
sudo mysql -e "CREATE USER IF NOT EXISTS 'creator'@'localhost' IDENTIFIED BY 'alfa1234';"
sudo mysql -e "GRANT ALL PRIVILEGES ON todo.* TO 'creator'@'localhost';"

mvn spring-boot:run

trap 'sudo pkill -9 -f tomcat;'  SIGINT
