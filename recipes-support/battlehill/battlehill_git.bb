inherit cmake

PN="battlehill"
PR="14"

SRCREV = "fc8116d61cda6d89d2f1f4c283815b3c8d26b889"

SRC_URI="git://github.com/kipr/battlehill.git;branch=robot-states"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="libbattlecreek daylite libbson"

do_install() {
  make install DESTDIR=${D}
}
