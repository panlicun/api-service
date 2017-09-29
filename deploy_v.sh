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
deploy_dir=/home/work/bin/hmbl-service
prod=$1
version=$2
cur_dir=`pwd`

if [ "x$prod" != "xonline" ] && [ "x$prod" != "xstaging" ]; then
  echo -e "usage: sh deploy.sh \e[4m[staging|online]\e[0m"
  exit
fi

git reset --hard
git pull
git checkout $version

[[ -d hmbl-service ]]     && rm -rf hmbl-service
[[ -f hmbl-service.tgz ]] && rm -f hmbl-service.tgz
sh build.sh $prod && \
  mv release hmbl-service && \
  tar zcf hmbl-service.tgz hmbl-service

[[ $? = 0 ]] || exit

if [ "x$prod" = "xonline" ];then
  for i in `seq 1 2`
  do
    host=hmbl-web0$i.hb1
    scp hmbl-service.tgz $host:/home/work/bin/
    supervisorctl -s http://$host:9001 -uhemabuluo -phemabuluo stop  hmbl-service
    ssh $host "cd /home/work/bin/ && mv ${deploy_dir} ${deploy_dir}-${timestamp} && tar xf hmbl-service.tgz && rm -f hmbl-service.tgz"
    supervisorctl -s http://$host:9001 -uhemabuluo -phemabuluo start hmbl-service
  done
elif [ "x$prod" = "xstaging" ]; then
  supervisorctl -s http://10.174.240.136:9001 -uhemabuluo -phemabuluo stop  hmbl-service
  mv ${deploy_dir} ${deploy_dir}-${timestamp}
  /bin/cp -R hmbl-service /home/work/bin/
  supervisorctl -s http://10.174.240.136:9001 -uhemabuluo -phemabuluo start hmbl-service
fi

cd $cur_dir && rm -f hmbl-service.tgz && rm -rf hmbl-service
