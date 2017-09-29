#!/bin/bash

##########################################
# File Name : deploy.sh
# Purpose : deploy hmbl-service
# Creation Date : 19-11-2016
# Last Modified : Sun Jan 15 15:15:53 2017
# Created By : Xiaobo Hu
#########################################
set -x

timestamp=`date +%Y%m%d-%H%M%S`
deploy_dir=/usr/local/tomcat/webapps
prod=$1

if [ "x$prod" != "xonline" ] && [ "x$prod" != "xstaging" ]; then
  echo -e "usage: sh deploy.sh \e[4m[staging|online]\e[0m"
  exit
fi

git reset --hard
git pull

mvn clean package  -Dmaven.test.skip=true

[[ $? = 0 ]] || exit

cp -rf target/*.war $deploy_dir/ROOT.war


