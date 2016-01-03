inherit cmake

PN="bsonbind"
PR="16"

SRCREV = "849e83e0cc4ad516b7808e6457259318ee9e7b02"
SRC_URI="git://github.com/kipr/bsonbind.git"
EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS = "libbson"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "${bindir}"
FILES_${PN} += "${includedir}"
