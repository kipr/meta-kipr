inherit cmake

PN="libwallaby"
PR="51"

SRCREV = "e7c1af41640cd925b87bb999b4a8f28b2f3f612e"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=master"

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
