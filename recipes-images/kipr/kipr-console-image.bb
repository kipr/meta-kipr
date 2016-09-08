DESCRIPTION = "A basic console image for Gumstix boards."
LICENSE = "MIT"

IMAGE_FEATURES += "splash package-management ssh-server-openssh x11-base qt4-pkgs"
# Uncomment below to include dev tools and packages
# IMAGE_FEATURES += "tools-sdk dev-pkgs"

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_LINGUAS = "en-us"

inherit core-image

# Gumstix machines individually RDEPEND on the firware they need but we repeat
# it here as we might want to use the same image on multiple different machines.
FIRMWARE_INSTALL = " \
  linux-firmware-sd8686 \
  linux-firmware-sd8787 \
  linux-firmware-wl18xx \
"

SYSTEM_TOOLS_INSTALL = " \
  alsa-utils \
  cpufrequtils \
  systemd-analyze \
  tzdata \
"

DEV_TOOLS_INSTALL = " \
  memtester \
  mtd-utils-ubifs \
  u-boot-mkimage \
  gcc \
  boost \
  boost-dev \
  cmake \
  make \
  python-core \
  python-pyserial \
"

NETWORK_TOOLS_INSTALL = " \
  curl \
  hostapd \
  iputils \
  iw \
  ntp \
  ntpdate \
  openssh-sftp \
  uim \
"

MEDIA_TOOLS_INSTALL = " \
  media-ctl \
  raw2rgbpnm \
  v4l-utils \
  opencv \
  opencv-samples \
  yavta \
"

GRAPHICS_LIBS = " \
  mtdev \ 
  tslib \
"  

UTILITIES_INSTALL = " \
  php \
  coreutils \
  diffutils \
  findutils \
  bzip2 \
  gpsd \
  grep \
  gzip \
  less \
  nano \
  packagegroup-cli-tools \
  packagegroup-cli-tools-debug \
  sudo \
  tar \
  tslib \
  tslib-conf \
  tslib-tests \
  tslib-calibrate \
  xf86-input-tslib \
  nodejs \
  nodejs-npm \
  libpng \
  libpng-dev \  
  zlib \
  zlib-dev \
  xrandr \
  libxrandr \
  chromium \
  vim \
  gstreamer \
  wget \
  zip \
  git \
  subversion \ 
  cmake \
  llvm3.3 \
  binutils \
  glibc-dev \
  libgcc-dev \
  libstdc++-dev \
  ttf-wqy-zenhei \
  g++ \
  g++-symlinks \
  gcc \
  gcc-symlinks \
  dhcp-client \
  ckermit \
  valgrind \
"

HIGHLEVEL_INSTALL = " \
  chromium \
  wallaby-utility \
  libwallaby \
  harrogate \
  botui \
  wifi-ap \
  botball-versions \
"
 
IMAGE_INSTALL += " \
  ${FIRMWARE_INSTALL} \
  ${SYSTEM_TOOLS_INSTALL} \
  ${DEV_TOOLS_INSTALL} \
  ${NETWORK_TOOLS_INSTALL} \
  ${MEDIA_TOOLS_INSTALL} \
  ${GRAPHICS_LIBS} \
  ${UTILITIES_INSTALL} \
  ${HIGHLEVEL_INSTALL} \
"

#  ${HIGHLEVEL_INSTALL} \
# Create a generic 'gumstix' user account, part of the gumstix group,
# using '/bin/sh' and with a home directory '/home/gumstix' (see
# /etc/default/useradd).  We set the password to 'gumstix' and add them
# to the 'sudo' group.
inherit extrausers
EXTRA_USERS_PARAMS = " \
    useradd -P gumstix -G sudo gumstix; \
"
