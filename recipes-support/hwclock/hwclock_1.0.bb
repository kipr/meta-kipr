S = "${WORKDIR}"

SRC_URI = "file://hwclock.service \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/lib/systemd/system
  install -m 0755 ${S}/hwclock.service ${D}/lib/systemd/system

  install -d ${D}/lib/systemd/system/basic.target.wants/
  ln -sf ../hwclock.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} = "/lib"
