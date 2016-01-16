inherit cmake

PN="wallaby-estop"
PR="1"

SRCREV = "927c8394ee3ff1c578585a6ce370c20289e60da5"

SRC_URI="git://github.com/kipr/wallaby-estop.git;branch=master"

EXTRA_OECMAKE += "-DBITBAKE_BS=1 -DCMAKE_SYSROOT=${D}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"
LICENSE="GPLv3"

DEPENDS=""

do_install() {
  make install DESTDIR=${D}
}

FILES_${PN} += "/usr/local/bin/wallaby-estop"
