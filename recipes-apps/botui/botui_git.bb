# TODO: not finished -  I went to work on libkar
inherit qt4x11 cmake

PN="botui"
PR="0"

SRCREV = "422fe352a1521263f0d0ce168b8e23ea6491dcba"

SRC_URI="git://github.com/kipr/botui.git;branch=libwallaby"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="pcompiler libwallaby"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "/usr/lib/*.so /usr/local/lib/*.so"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/botui/.debug"
