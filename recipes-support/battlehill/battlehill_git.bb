inherit cmake

PN="battlehill"
PR="55"

SRCREV = "fcd2ab3f3b199d95fa978bfc05e15452ede9416d"

SRC_URI="git://github.com/kipr/battlehill.git;branch=master \
         file://asound.state \
         file://turn_off_wallaby.wav \
         file://alsa.service \
"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="libbattlecreek daylite libbson"

do_install() {
  make install DESTDIR=${D}

  install -d ${D}/usr/share/battlehill
  install -m 755 ${WORKDIR}/asound.state ${D}/usr/share/battlehill

  install -d ${D}/usr/share/battlehill
  install -m 755 ${WORKDIR}/turn_off_wallaby.wav ${D}/usr/share/battlehill

  install -d ${D}/lib/systemd/system
  install -d ${D}/lib/systemd/system/basic.target.wants/
  install -m 0755 ${WORKDIR}/alsa.service ${D}/lib/systemd/system
  ln -sf ${WORKDIR}/alsa.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} += "/usr/share/battlehill /lib/systemd"
