inherit qt4x11 cmake

PN="botui"
PR="25"

SRCREV = "c7cf8c2b8c2e2653a0d3a73ad8e98fdd53e0294c"

SRC_URI="git://github.com/kipr/botui.git;branch=master \
	file://botui.desktop \
	file://botui_loop.sh \
	file://default \
	file://TestConfig.conf \
	file://asound.state \
	file://turn_off_wallaby.wav \
	file://alsa.service \
"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"
LICENSE="GPLv3"

DEPENDS="pcompiler libwallaby"

do_install() {
  make install DESTDIR=${D}

  install -d ${D}/etc/botui/channels
  install -m 0644 ${WORKDIR}/default ${D}/etc/botui/channels
  install -m 0644 ${WORKDIR}/TestConfig.conf ${D}/etc/botui/channels

  install -d ${D}/etc/xdg/autostart
  install -m 0644 ${WORKDIR}/botui.desktop ${D}/etc/xdg/autostart

  install -d ${D}/usr/local/bin
  install -m 0755 ${WORKDIR}/botui_loop.sh ${D}/usr/local/bin

  install -d ${D}/usr/share/botui
  install -m 755 ${WORKDIR}/asound.state ${D}/usr/share/botui

  install -d ${D}/usr/share/botui
  install -m 755 ${WORKDIR}/turn_off_wallaby.wav ${D}/usr/share/botui

  install -d ${D}/lib/systemd/system
  install -d ${D}/lib/systemd/system/basic.target.wants/
  install -m 0755 ${WORKDIR}/alsa.service ${D}/lib/systemd/system
  ln -sf ${WORKDIR}/alsa.service ${D}/lib/systemd/system/basic.target.wants/
}

FILES_${PN} += "/usr/lib/*.so /usr/local/lib/*.so /lib /etc/botui /usr/local/bin /etc/xdg/autostart"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/botui/.debug"
