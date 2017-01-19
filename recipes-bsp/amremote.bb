SUMMARY = "AML remote setup"
LICENSE = "GPLv2"
SECTION = "base"
PRIORITY = "required"

PR = "r6"

require conf/license/license-gplv2.inc

SRCREV = "cac12639977a2924d4bb120e02d1aa15cffcd607"

SRC_URI = "git://github.com/wetek-enigma/amremote.git \
           file://wetek.conf \
           file://wetek1.conf \
           file://wetek2.conf \
           file://wetek3.conf \
"

S = "${WORKDIR}/git"



do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/amremote
    install -m 0755 ${S}/remotecfg ${D}${bindir}/
    install -m 0644 ${WORKDIR}/wetek.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${WORKDIR}/wetek1.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${WORKDIR}/wetek2.conf ${D}${sysconfdir}/amremote/
    install -m 0644 ${WORKDIR}/wetek3.conf ${D}${sysconfdir}/amremote/
}

FILES_${PN} = "${bindir} ${sysconfdir}"

