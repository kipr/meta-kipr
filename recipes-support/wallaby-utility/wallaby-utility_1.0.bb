SRC_URI = "file://wallaby_upgrade \
           file://wallaby_reset_coproc \
           file://wallaby_init_gpio \
           file://wallaby_flash \
           file://wallaby_compile.sh \
           file://home_folder \
           file://LICENSE \
"

PR = "1.2"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM="file://${WORKDIR}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

do_install() {
  install -d ${D}/usr/bin
  install -m 0755 ${WORKDIR}/wallaby_upgrade ${D}/usr/bin
  install -m 0755 ${WORKDIR}/wallaby_reset_coproc ${D}/usr/bin
  install -m 0755 ${WORKDIR}/wallaby_init_gpio ${D}/usr/bin
  install -m 0755 ${WORKDIR}/wallaby_flash ${D}/usr/bin
  install -m 0755 ${WORKDIR}/wallaby_compile.sh ${D}/usr/bin

  install -d ${D}/home/root
  cp ${WORKDIR}/home_folder ${D}/home/root/home_folder.tar.gz
}

PACKAGES = "${PN}"
FILES_${PN} = "/usr/bin /home/root"

