## Buildbot master/slave on Ubuntu 16.04 (Xenial Xerus) - PPC64 Little-endian

> Note: adapted from http://docs.buildbot.net/current/tutorial/firstrun.html

### Install

```sh
sudo apt-get install python-dev
sudo apt-get install python-pip
mkdir -p /tmp/buildbot && cd /tmp/buildbot
sudo apt-get install virtualenv
virtualenv --no-site-packages sandbox
source sandbox/bin/activate
easy_install sqlalchemy==0.7.10
easy_install buildbot
pip install buildbot-www
pip install buildbot-waterfall-view
pip install buildbot-console-view
```
