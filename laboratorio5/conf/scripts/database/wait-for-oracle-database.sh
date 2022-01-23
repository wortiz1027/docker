#!/bin/bash

javac -cp '.;/u01/oracle/user_projects/scripts/database/ojdbc8.jar' -d . -sourcepath /u01/oracle/user_projects/scripts/database/OracleTestConnection.java

until [ `java -cp '.;ojdbc8.jar' OracleTestConnection` ! = "SHUTDOWN" ]; do
        echo -n '. '
        sleep 5;
done;

echo 'Database is RUNNING!'

echo 'Install socat...'
yum -y install socat &

echo 'Config socat...'
/usr/bin/socat TCP4-LISTEN:8001,fork TCP4:soa:8001" &