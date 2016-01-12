inherit cmake

PN="libwallaby"
PR="49"

SRCREV = "b5bcdbe1b4f75d17c85722c5fd005af6c660251a"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=start-end-conditions"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="opencv libbattlecreek bsonbind daylite"

do_install() {
  make install DESTDIR=${D}
  chmod u+x ${D}/usr/bin/wallaby/*
}

FILES_${PN} += "/usr/lib/*.so /usr/bin/wallaby/*_c"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/wallaby/.debug"
