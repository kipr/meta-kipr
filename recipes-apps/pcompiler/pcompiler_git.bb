# TODO: not finished -  I went to work on libkar
inherit qt4x11 cmake

PN="pcompiler"
PR="3"

SRCREV = "9b490910102f5207b9e9adfa55a4af16cf2dec3f"

SRC_URI="git://github.com/kipr/pcompiler.git;branch=use_Qt4"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="libkar"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "/usr/lib/*.so /usr/local/lib/*.so"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/pcompiler/.debug"
