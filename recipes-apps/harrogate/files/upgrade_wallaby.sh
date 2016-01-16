#!/bin/bash

# check arguments
DEFAULT_PATH=/mnt/kipr-console-image-pepper.tar.bz2
if [ $# -lt 1 ];
then
	echo "Expected 1 argument... using default path $DEFAULT_PATH"
	IMG_PATH=$DEFAULT_PATH
else
	IMG_PATH=$1
fi

# check that the path is good
if [ ! -f $IMG_PATH ];
then
	echo "Expected upgrade image file at $IMG_PATH"
	exit
else
	echo "Found $IMG_PATH"
fi

# run the upgrade
/usr/bin/wallaby_upgrade $IMG_PATH
