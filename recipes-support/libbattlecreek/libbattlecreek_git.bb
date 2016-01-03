inherit cmake

PN="libbattlecreek"
PR="11"

SRCREV = "20a3f3a98851aab0d910b54ace56840e712fe014"

SRC_URI="git://github.com/kipr/libbattlecreek.git;branch=add-robot-states"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE.txt;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="daylite bsonbind libbson"

do_install() {
  make install DESTDIR=${D}
  install -d ${D}/etc/libbattlecreek
  touch ${D}/etc/libbattlecreek/dummy
}

FILES_${PN} = "/etc/libbattlecreek/dummy"

