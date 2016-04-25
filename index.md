## Buildbot master/slave on Ubuntu 16.04 (Xenial Xerus) - PPC64 Little-endian

> Note: adapted from http://docs.buildbot.net/current/tutorial/firstrun.html

### Install

```sh
sudo apt-get install python-dev
mkdir -p /tmp/buildbot && cd /tmp/buildbot
sudo apt-get install virtualenv
virtualenv --no-site-packages sandbox
source sandbox/bin/activate
easy_install sqlalchemy==0.7.10
easy_install buildbot
```
