inherit qt4x11 cmake

PN="libkar"
PR="3"

SRCREV = "c37b8e3abe1d85018b6614c6798334a765ffb4be" 

SRC_URI="git://github.com/kipr/libkar.git;branch=use_Qt4"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS= "qtdeclarative qtgraphicaleffects"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "/usr/lib/*.so"
FILES_${PN}-dev = "/usr/include"
