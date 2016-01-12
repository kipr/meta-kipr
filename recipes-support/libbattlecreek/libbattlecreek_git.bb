inherit cmake

PN="libbattlecreek"
PR="17"

SRCREV = "afb84ca051b894d7aa85da424bee20a0118ba69f"

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

