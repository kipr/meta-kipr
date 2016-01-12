inherit npm-install

PN="harrogate"
PR="40"

SRCREV = "74473e3b15e8ae2ff5dd40488574d48ae21212ef"

SRC_URI="git://github.com/kipr/harrogate.git"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
LICENSE="GPLv3"

DEPENDS="nodejs daylite libbson libaurora"

do_compile() {
  cd ${S}
  oe_runnpm install gulp -g
  export V=1
  export SYSROOT=/home/kipr/yocto/build/tmp/sysroots/pepper
  oe_runnpm install
  gulp compile
}

do_install() {
  install -d ${D}/harrogate
  cp -r ${S}/* ${D}/harrogate
}

PACKAGES = "${PN}"
FILES_${PN} = "/harrogate /usr"

INSANE_SKIP_${PN} += "staticdev"
