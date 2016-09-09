S = "${WORKDIR}"

PN="botball-inc"
PR="1"

SRC_URI = "file://botball.h \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/usr/include/kipr
  install -m 0644 ${S}/botball.h ${D}/usr/include/kipr
}

FILES_${PN} = "/usr"
