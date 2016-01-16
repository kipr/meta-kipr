S = "${WORKDIR}"

PR="2"

SRC_URI = "file://wifi.service \
           file://udhcpd.conf \
           file://wifi_configurator.py \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/lib/systemd/system
  install -m 0644 ${S}/wifi.service ${D}/lib/systemd/system

  install -d ${D}/usr/bin
  install -m 0755 ${S}/wifi_configurator.py ${D}/usr/bin

  install -d ${D}/etc
  install -m 0644 ${S}/udhcpd.conf ${D}/etc

  install -d ${D}/lib/systemd/system/graphical.target.wants/
  ln -sf ../wifi.service ${D}/lib/systemd/system/graphical.target.wants/
}

FILES_${PN} = "/lib"
FILES_${PN} += "/usr"
FILES_${PN} += "/etc"
