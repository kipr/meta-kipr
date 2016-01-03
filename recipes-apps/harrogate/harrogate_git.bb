inherit npm-install

PN="harrogate"
PR="2"

SRCREV = "b4edab26148442409eaa45bcb76137f36a1f93c7"

SRC_URI="git://github.com/kipr/harrogate.git"

EXTRA_OECMAKE += "-DBITBAKE_BS=1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
LICENSE="GPLv3"

DEPENDS="nodejs"

PACKAGES = "${PN}"
FILES_${PN} = "/usr/harrogate"
