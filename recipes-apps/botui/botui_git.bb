# TODO: not finished -  I went to work on libkar
inherit qt4x11 cmake

PN="botui"
PR="16"

SRCREV = "623c85a94f2c36a3d93144d99f38c4c6ba8ac105"

SRC_URI="git://github.com/kipr/botui.git;branch=master \
	file://botui.service \
	file://default \
	file://TestConfig.conf \
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

  install -d ${D}/lib/systemd/system
  install -m 0644 ${WORKDIR}/botui.service ${D}/lib/systemd/system

  install -d ${D}/lib/systemd/system/graphical.target.wants/
  ln -sf ../botui.service ${D}/lib/systemd/system/graphical.target.wants/
}

FILES_${PN} += "/usr/lib/*.so /usr/local/lib/*.so /lib /etc/botui"
FILES_${PN}-dev = "/usr/include"
FILES_${PN}-dbg += "/usr/bin/botui/.debug"
