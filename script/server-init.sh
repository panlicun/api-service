#!/bin/bash

##########################################
# File Name : server-init.sh
# Purpose : initialize basic server environment
# Creation Date : 19-11-2016
# Last Modified : Sun Jan 15 15:55:59 2017
# Created By : Xiaobo Hu
#########################################

function install_jdk {
	cur_dir=`pwd`
	jdk_file_name=jdk1.8.0_31.tgz
	cd /tmp/ || exit

	[ -f ${jdk_file_name} ] && rm -f ${jdk_file_name}
	[ -f jdk.sh ] && rm -f jdk.sh
	wget http://121.42.206.114/download/jdk/${jdk_file_name} || exit
	wget http://121.42.206.114/download/jdk/jdk.sh || exit

	[ -d /home/work/soft/jdk ] || mkdir /home/work/soft/jdk
	tar xf ${jdk_file_name} -C /home/work/soft/jdk && chown -R work.work /home/work/soft/jdk
	sed -i "s/JDK_DEPLOY_PATH/\/home\/work\/soft\/jdk\//g" jdk.sh
	cp jdk.sh /etc/profile.d/

	rm -f ${jdk_file_name} jdk.sh
	cd ${cur_dir}
}

function install_nginx {
	cur_dir=`pwd`
	nginx_file_name=nginx.tgz
	cd /tmp/ || exit

	[ -f nginx.tgz ] && rm -f nginx.tgz
	wget http://121.42.206.114/download/nginx/nginx.tgz || exit

	[ -d /home/work/bin ] || mkdir -p /home/work/bin
	tar xf nginx.tgz -C /home/work/bin && chown -R work.work /home/work/bin/nginx

	rm -f nginx.tgz
	cd $cur_dir
}

function install_supervisor {
	easy_install supervisor
	rm -rf /home/work/bin/supervisor
	mkdir -p /home/work/bin/
	wget http://121.42.206.114/download/supervisor/supervisor.tgz || exit
	tar xf supervisor.tgz -C /home/work/bin/
	local_ip=`cat /etc/sysconfig/network-scripts/ifcfg-eth0 |grep IPADDR |awk -F= '{print $2}'`
	cd /home/work/bin/supervisor/ && \
	  sed -i "s/LOCAL_IP_ADDR/$local_ip/g" supervisord.conf

	#supervisord -c supervisord.conf
	#echo 'cd /home/work/bin/supervisor/ && supervisord -c supervisord.conf' >> /etc/rc.local
}

#install_jdk
#install_nginx
#install_supervisor
