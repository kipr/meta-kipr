inherit cmake
inherit native

PN="bsonbind-native"
PR="17"

SRCREV = "240fc7b9a1467240ff97d51166a96724acd6d9c0"
SRC_URI="git://github.com/kipr/bsonbind.git"
EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

RDEPENDS = "libbson"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "${bindir}"
FILES_${PN} += "${includedir}"
