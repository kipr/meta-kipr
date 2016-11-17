# meta-kipr
This repo contains recipes for building a Yocto Linux image for the "Wallaby" KIPR Botball Robot Controller.

## Build notes for a clean 14.04 Ubuntu VM

````
$ sudo apt-get install git g++ binutils diffstat chrpath make texinfo npm nodejs-legacy libboost-dev gawk

````

###  Set up gitconfig
````
$ git config --global user.email "you@example.com"
$ git config --global user.name "Your Name"
````

### Get the repo tool and set up our sources
````
$ curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > repo
$ chmod a+x repo
$ sudo mv repo /usr/local/bin/

$ mkdir yocto
$ cd yocto
$ repo init -u git://github.com/kipr/yocto-manifest.git -b kipr-wallaby
$ repo sync
````

Fix the SYSROOT path in ``yocto/poky/meta-kipr/recipes-apps/harrogate/harrogate_git.bb``:
https://github.com/kipr/meta-kipr/blob/master/recipes-apps/harrogate/harrogate_git.bb#L25



Configure more path stuff and the build:
````
$ export TEMPLATECONF=meta-kipr/conf
$ npm config set prefix '~/.npm-global'
$ export PATH=~/.npm-global/bin:$PATH
$ source ~/.profile
$ . poky/oe-init-build-env        (moves you to yocto/build)
````

### Start a partial build

Build harrogate first, since it is the most likely package to cause problems:
````
$ bitbake harrogate
````

A common error:
````
ERROR: QA Issue: harrogate: The compile log indicates that host include and/or library paths were used.
  Please check the log '/home/kipr/yocto/build/tmp/work/cortexa8hf-vfp-neon-poky-linux-gnueabi/harrogate/git-74/temp/log.do_compile' for more information. [compile-host-path]
WARNING: QA Issue: harrogate requires /bin/bash, but no providers in its RDEPENDS [file-rdeps]
ERROR: QA run found fatal errors. Please consider fixing them.
ERROR: Function failed: do_package_qa
ERROR: Logfile of failure stored in: /home/kipr/yocto/build/tmp/work/cortexa8hf-vfp-neon-poky-linux-gnueabi/harrogate/git-74/temp/log.do_package_qa.7084
ERROR: Task 10 (/home/kipr/yocto/poky/meta-kipr/recipes-apps/harrogate/harrogate_git.bb, do_package_qa) failed with exit code '1'
````

The following re-build resolves it:
````
$ bitbake -c clean harrogate
$ bitbake harrogate
````

### Build the rest of the image
````
$ bitbake kipr-console-image
````


