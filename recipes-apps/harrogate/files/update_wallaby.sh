#!/bin/bash

# check arguments
if [ $# -lt 1 ];
then
	echo "Expected 1 argument"
	UPDATE_PATH=/mnt/wallaby_update.sh
else
	UPDATE_PATH=$1
fi

# check that the path is good
if [ ! -f $UPDATE_PATH ];
then
	echo "Expected update script file at $UPDATE_PATH"
	exit
else
	echo "Found $UPDATE_PATH"
fi


# split path into directory and script name
UPDATE_DIR=$(dirname "${1}")
UPDATE_SCRIPT=$(basename "${1}")

echo "Passed an update path of ${1}"
echo "update dir = ${UPDATE_DIR}"
echo "update script = ${UPDATE_SCRIPT}"

# change directory and run the script
cd $UPDATE_DIR
./$UPDATE_SCRIPT
