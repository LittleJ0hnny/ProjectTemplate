#!/bin/bash

echo "Open MySQL console"

mysql -uroot -p

send "root"

CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON * . * TO 'admin'@'%';
FLUSH PRIVILEGES;

exit