inherit cmake

PN="daylite"
PR="24"

SRCREV = "b295460686aafc0cca39f827a7d8412f0ab53785"

SRC_URI="git://github.com/kipr/daylite.git;branch=fixes"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="libbson bsonbind"

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} = "/usr/bin /usr/lib/libdaylite.so"
FILES_${PN}-dev = "/usr/include/daylite"
