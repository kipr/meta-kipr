FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

UBOOT_ENV = "uEnv"

SRC_URI += " \ 
	file://kipr-ddr3-enable-support.patch \
	file://uEnv.txt \
"
