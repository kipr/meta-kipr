DESCRIPTION = "Wallaby helper scripts"

SRC_URI = "file://test1.sh"

do_install() {
	install -d ${D}/home/root/
	install -m 0644 ${WORKDIR}/test1.sh ${D}/home/root/test1.sh
}
