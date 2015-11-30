FILESEXTRAPATHS_prepend := "${THISDIR}/bluez5-5.28:"

SRC_URI += " \
  file://99-bluetooth-via-uart.rules \
  file://bluetooth-ttyO5-wilink.service \
"

SYSTEMD_SERVICE_${PN} += "bluetooth-ttyO5-wilink.service"

SYSTEMD_AUTO_ENABLE = "enable"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/bluetooth-ttyO5*.service ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-bluetooth-via-uart.rules ${D}${sysconfdir}/udev/rules.d
}
