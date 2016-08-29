S = "${WORKDIR}"

PR="17"

SRC_URI = "file://board_fw_version.txt \
           file://LICENSE \
"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d32239bcb673463ab874e80d47fae504"

do_install() {
  install -d ${D}/usr/share/kipr
  install -m 0644 ${S}/board_fw_version.txt ${D}/usr/share/kipr
}

FILES_${PN} = "/usr"
