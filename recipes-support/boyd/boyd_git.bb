inherit cmake

PN="boyd"
PR="24"

SRCREV = "5cf454b4e16840fd018238b7e883c08cfa4985fb"

SRC_URI="git://github.com/kipr/boyd.git;branch=master \
         file://boyd.service \
"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="daylite libbson opencv bsonbind-native"
RDEPENDS_${PN} = "bsonbind"

do_install() {
  make install DESTDIR=${D}

  install -d ${D}/lib/systemd/system
  install -d ${D}/lib/systemd/system/basic.target.wants/

  install -m 0755 ${WORKDIR}/boyd.service ${D}/lib/systemd/system
  ln -sf ${WORKDIR}/boyd.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} += "/lib"
