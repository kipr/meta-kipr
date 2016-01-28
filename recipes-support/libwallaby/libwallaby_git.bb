inherit cmake

PN="libwallaby"
PR="91"

SRCREV = "f616f7c8dd48504b482e2a5c9a8e4a9183a4c7ec"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=libwallaby-v10"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="opencv"

do_install() {
  make install DESTDIR=${D}
  chmod u+x ${D}/usr/bin/wallaby/*
}

FILES_${PN} += "/usr/lib/*.so /usr/bin/wallaby/*_c"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/wallaby/.debug"
