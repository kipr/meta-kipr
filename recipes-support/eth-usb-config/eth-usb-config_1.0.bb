S = "${WORKDIR}"

PR="0"

SRC_URI = "file://eth_usb_config.service \
           file://udhcpd_usb.conf \
           file://eth_usb_configurator.py \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/lib/systemd/system
  install -m 0644 ${S}/eth_usb_config.service ${D}/lib/systemd/system

  install -d ${D}/usr/bin
  install -m 0755 ${S}/eth_usb_configurator.py ${D}/usr/bin

  install -d ${D}/etc
  install -m 0644 ${S}/udhcpd_usb.conf ${D}/etc

  install -d ${D}/lib/systemd/system/graphical.target.wants/
  ln -sf ../eth_usb_config.service ${D}/lib/systemd/system/graphical.target.wants/
}

FILES_${PN} = "/lib"
FILES_${PN} += "/usr"
FILES_${PN} += "/etc"
