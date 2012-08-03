# Define a set of SW and config needed to run Apache
# (plus some utils)
class web_box {

  package {['apache2', 'vim']:
    ensure => 'present',
  }


  # Copy all the apache config files that we have created:
  file {'/etc/apache2':
    ensure  => 'directory',
    source  => '/vagrant/files/etc/apache2',
    recurse => 'remote',
    owner   => 'root',
    group   => 'root',
    mode    => '0755',
    notify  => Service['apache2'],
  }
  
  service { 'apache2': 
    ensure => running, 
    require => [ Package['apache2'] ],
  }
}

# Apply it
include web_box
