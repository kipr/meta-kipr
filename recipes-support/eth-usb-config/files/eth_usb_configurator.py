#
# Joshua Southerland
# jsoutherland@kipr.org
#
# This program is used to configure Ethernet over USB for the KIPR Wallaby Robot Controller
# It enables usb0 and sets up a DHCP server 
#

import os

# bring usb0 up
os.system('/sbin/ifconfig usb0 192.168.124.1 up')

#start DHCP
os.system('/usr/sbin/udhcpd /etc/udhcpd_usb.conf')

