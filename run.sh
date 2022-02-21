#!/bin/bash

sudo mysql -e "CREATE DATABASE todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "USE todo;"
sudo mysql -e "CREATE USER IF NOT EXISTS 'walter' @localhost IDENTIFIED BY '1234';"
sudo mysql -e "GRANT ALL PRIVILEGES ON *todo* TO 'walter'@'localhost';"

mvn spring-boot:run