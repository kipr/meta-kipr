inherit cmake

PN="libbattlecreek"
PR="15"

SRCREV = "0b4020499c03578018318403250d3a50b079237c"

SRC_URI="git://github.com/kipr/libbattlecreek.git;branch=master"

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

