#!/bin/bash

gcc -o user_program $1 -I/home/root/libwallaby/libwallaby/include -L/home/root/libwallaby/build -l wallaby -lstdc++
