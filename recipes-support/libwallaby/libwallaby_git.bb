inherit cmake

PN="libwallaby"
PR="11"

SRCREV = "cac3e231bd09e898e037584605c02ad9afe94140"

SRC_URI="git://github.com/kipr/libwallaby.git;branch=use-daylite"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS="libbattlecreek bsonbind daylite"

do_install() {
  make install DESTDIR=${D}
}

