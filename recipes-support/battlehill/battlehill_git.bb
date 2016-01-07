inherit cmake

PN="battlehill"
PR="34"

SRCREV = "73bacfa828f415c487004d341357c5b03d87e89a"

SRC_URI="git://github.com/kipr/battlehill.git;branch=master \
         file://asound.state \
         file://turn_off_wallaby.wav \
         file://alsa.service \
         file://battlehill.service \
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
  install -m 0755 ${WORKDIR}/battlehill.service ${D}/lib/systemd/system
  ln -sf ${WORKDIR}/battlehill.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} += "/usr/share/battlehill /lib/systemd"
