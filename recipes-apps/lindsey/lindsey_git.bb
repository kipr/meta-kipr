inherit cmake_qt5

PN="lindsey"
PR="5"

SRCREV = "d041552006db88c26416df73d2e083cf5ebc9465"

SRC_URI="git://github.com/kipr/lindsey.git"

EXTRA_OECMAKE += "-DBITBAKE_BS=1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="qtbase qtwebengine qtdeclarative"

do_install() {
  install -d ${D}${bindir}/
  install -m 0755 ${S}/../build/lindsey ${D}${bindir}/
}

FILES_${PN} += "${bindir}"
