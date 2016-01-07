inherit cmake

PN="libaurora"
PR="13"

SRCREV = "674e5916f8e20281556f96ff6364ea84732f9995"

SRC_URI="git://github.com/kipr/libaurora.git"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="daylite libbson libpng bsonbind-native"
RDEPENDS_${PN} = "bsonbind"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "${libdir}/lib*.so"
FILES_${PN}-dev = "/usr/include"
