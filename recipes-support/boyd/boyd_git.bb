inherit cmake

PN="boyd"
PR="1"

SRCREV = "783e8899ded594c30e5085075c144071d3c26da8"

SRC_URI="git://github.com/kipr/boyd.git"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="daylite libbson opencv bsonbind-native"
RDEPENDS_${PN} = "bsonbind"

do_install() {
  make install DESTDIR=${D}
}

