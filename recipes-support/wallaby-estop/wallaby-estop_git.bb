inherit cmake

PN="wallaby-estop"
PR="4"

SRCREV = "d0f2cc193219ede5dc1c4b477a17383b9362f803"

SRC_URI="git://github.com/kipr/wallaby-estop.git;branch=master \
  file://wallaby-estop.service \
"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS=""

do_install() {
  make install DESTDIR=${D}

  install -d ${D}/lib/systemd/system
  install -m 0644 ${WORKDIR}/wallaby-estop.service ${D}/lib/systemd/system

  install -d ${D}/lib/systemd/system/graphical.target.wants/
  ln -sf ../wallaby-estop.service ${D}/lib/systemd/system/graphical.target.wants/  
}

FILES_${PN} = "/usr/bin/wallaby-estop /lib/systemd/system"
