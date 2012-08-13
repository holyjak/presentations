Commit On Day One Thanks to Vagrant & Puppet!
=============================================

Instructions for a quick, demo-based introduction into Vagrant. Get the [accompanying presentation at SlideShare](http://www.slideshare.net/malyvelky/commit-on-day-one-thanks-to-vagrant-puppet).

Time needed: 10 - 14 min.

What to prepare to follow the demo
----------------------------------
1. Install Vagrant: http://downloads.vagrantup.com/tags/v1.0.3
2. Install `$ vagrant gem install vagrant-vbguest` ([Why?](http://theholyjava.wordpress.com/wiki/tools/vagrant-notes/#tip_install_vagrant-vbguest))
3. Download a base box: `vagrant box add base http://files.vagrantup.com/lucid32.box`
4. Install VirtualBox, e,g, 4.1.16: http://download.virtualbox.org/virtualbox/4.1.16/
   (For the presenter: Make sure the VB version is the same as VB Guest Additions installed on the base box.)

The demo
--------

Note: Net connection required (Puppet accesses Apt repositories when installing SW).

Preparation:
* browser for showing the web site
* two terminal tabs in a fullscreen window (with suitable font size and color scheme)
** Terminal 1: empty
** Terminal 2: run 'cat copy' (diff, copy config) and type 'vim manifest/base.pp' w/o executing it yet
* the presentation in fullscreen

Timing:
* While running vagrant up: talk about puppet, show its config
* While running provision: Slide benefits
* While running destroy: Slide pitfalls

### 1. A simple VM

```
$ mkdir vm; cd vm
$ vagrant		# displays help
$ vagrant init
$ diff Vagrantfile ../vm-finished/Vagrantfile # our 4 changes to the default config
$ cp ../vm-finished/Vagrantfile .
$ vim Vagrantfile	# to show it (well documented; options to know)
```

Our modifications to the default Vagrantfile:
* Set the base box URL http://files.vagrantup.com/lucid32.box
** So that it will be automatically downloaded if not present on the machine
* Shared directories - add www (by default: the dir with Vagrantfile is shared as /vagrant)
* Mapped ports - make Apache's 80 available as localhost:8080 on the host
* Provisioner - enable puppet (altern.: shell, chef)

```
$ mkdir manifests; touch manifests/base.pp 	# empty puppet config
$ vagrant up
 # Show our puppet manifest briefly (package installation, dir copy, service startup)
 # Afterwards: Highlight parts of the output: VM creation, dir sharing, port mapping, puppet execution
```

### 2. Installing & configuring SW with Puppet

Reusable configuration - Puppet can install SW, create files, users etc., execute commands, start services - used to set up the system in a repeatable manner.

To learn more about Puppet read the [Minimalistic Practical Introduction to Puppet For Vagrant Users](http://theholyjava.wordpress.com/2012/08/10//minimalistic-introduction-to-puppet-for-vagrant-users/).

```
 # Copy the previously shown manifest and the apache config files:
$ cp ../vm-finished/manifests/base.pp manifests/base.pp
$ cp -r ../vm-finished/files/ files
```

Re-run the puppet provisioner: 

```
vagrant provision
```

(While running, show the slide Benefits. Afterwards show the input, highlight package installation, file copying, service starting.)

### Daily use

```
$ vagrant ssh		# password-less ssh into the VM as the user vagrant
vagrant$ sudo ls /	# the user has password-less access to sudo
 # Ex.: tail apache log & browse to the port on the host machine

$ vagrant halt		# use 'vagrant suspend' to just sleep
$ vagrant destroy	# remove the VM
```

(While halting, show the slide Pitfalls.)

