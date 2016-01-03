inherit cmake

PN="libbson"
PR="1"

SRCREV = "12750146601dff97493675e4d4b85a7d5c03d6e1"

SRC_URI=" \
	git://github.com/mongodb/libbson.git \
	file://libbson_remove_concat.patch \
"

EXTRA_OECMAKE += "-DBITBAKE_BS=1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM="file://${S}/COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"
LICENSE="Apache"

DEPENDS=""

do_install() {
	make install DESTDIR=${D}
}

FILES_${PN} += "${bindir}"
FILES_${PN} += "${libdir}"
FILES_${PN}-dev += "${includedir}"
