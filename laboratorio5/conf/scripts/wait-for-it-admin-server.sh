#!/bin/bash

until $(curl --output /dev/null --silent --head --fail http://admin:7001/em); do
        echo -n '. '
        sleep 5;
done;

echo "Admin Server is RUNNING!"

echo "Starting Managed Server..."
sh /u01/oracle/dockertools/startMS.sh
echo "Managed Server is RUNNING!"