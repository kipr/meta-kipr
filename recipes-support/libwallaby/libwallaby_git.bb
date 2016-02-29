inherit cmake

PN="libwallaby"
PR="108"

SRCREV = "2dc68ea7985c858f8d9e9a37a062eae82f4e6e8e"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=update-15"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="opencv zbar"

do_install() {
  make install DESTDIR=${D}
  chmod u+x ${D}/usr/bin/wallaby/*
}

FILES_${PN} += "/usr/lib/*.so /usr/bin/wallaby/*_c"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/wallaby/.debug"
