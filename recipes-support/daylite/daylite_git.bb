inherit cmake

PN="daylite"
PR="46"

SRCREV = "c5e41a60812e7e50b015b8da340855d4cd215366"

SRC_URI="git://github.com/kipr/daylite.git file://daylited.service"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="libbson bsonbind-native"
RDEPENDS_${PN}="bsonbind"

do_install() {
  make install DESTDIR=${D}

  install -d ${D}/lib/systemd/system
  install -m 0755 ${WORKDIR}/daylited.service ${D}/lib/systemd/system

  install -d ${D}/lib/systemd/system/basic.target.wants/
  ln -sf ../daylited.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} = "/usr/bin/daylited /usr/bin/daylite/*.cpp /usr/lib/libdaylite.so /lib"
FILES_${PN}-dbg += "/usr/bin/daylite/.debug/*.cpp"
FILES_${PN}-dev = "/usr/include/daylite"
