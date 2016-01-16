S = "${WORKDIR}"

PN="chromium-service"
PR="1"

SRC_URI = "file://chromium.service \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/lib/systemd/system
  install -m 0644 ${S}/chromium.service ${D}/lib/systemd/system

  install -d ${D}/lib/systemd/system/graphical.target.wants/
  ln -sf ../chromium.service ${D}/lib/systemd/system/graphical.target.wants/
}

FILES_${PN} = "/lib"
