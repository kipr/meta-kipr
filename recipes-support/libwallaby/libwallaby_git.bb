inherit cmake

PN="libwallaby"
PR="133"

SRCREV = "ce63e04292b0c8b8a9a77d2e51fb083f107f0672"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=master"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D} -DBUILD_DOCUMENTATION=OFF"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="opencv zbar"

do_install() {
  make install DESTDIR=${D}
  chmod u+x ${D}/usr/bin/wallaby/*
}

FILES_${PN} += "/usr/lib/*.so /usr/lib/wallaby.py /usr/bin/wallaby/*_c"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/wallaby/.debug"
