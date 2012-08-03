Commit On Day One Thanks to Vagrant & Puppet!
=============================================

What to prepare to follow the demo
----------------------------------
1. Install Vagrant: http://downloads.vagrantup.com/tags/v1.0.3
2. Install `$ vagrant gem install vagrant-vbguest`
3. Download a base box: `vagrant box add base http://files.vagrantup.com/lucid32.box`
4. Install VirtualBox, e,g, 4.1.16: http://download.virtualbox.org/virtualbox/4.1.16/

The demo
--------

Note: Net connection required (Puppet accesses Apt repositories when installing SW).

Preparation:
* browser for showing the web site
* two terminal tabs (alt+cmd+arrow) in a fullscreen window
* presentation in fullscreen
* base box url

Timing:
* While running vagrant up: talk about puppet, show its config
* While running provision: Slide benefits
* While running destroy: Slide pitfalls

### A simple VM

```
$ vagrant		# displays help
$ vagrant init
$ vim Vagrantfile
```

About Vagrantfile & modifications:
* Set the base box URL http://files.vagrantup.com/lucid32.box
* Shared directories - add (by default: . as /vagrant)
* Mapped ports - add Apache's 80
* Provisioner - enable puppet (altern.: shell, chef)
* GUI mode for troubleshooting

```
$ vagrant up
```

### Installing & configuring SW with Puppet

Reusable configuration - Puppet can install SW, create files, users etc., execute commands, start services - used to set up the system in a repeatable manner.

=> cp -r vm-finished/manifests vm; cp -r vm-finished/files vm
=> show the prepared manifest (to mention: Ruby-like syntax, classes, usage of 'types' (package, file, service, exec), dependencies)

Re-run provisioner: `vagrant provision` (run also at `up`)

### Daily use

```
$ vagrant ssh		# ssh into as the user vagrant; use 'sudo' to get root access
# Ex.: tail apache log & browse to the port on the host machine
vagrant> TBD

$ vagrant halt		# use 'vagrant suspend' to just sleep
$ vagrant destroy	# remove the VM
```
