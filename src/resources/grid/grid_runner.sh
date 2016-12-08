#!/bin/bash

xterm -e java -jar selenium-server-standalone-2.53.1.jar -role hub &

xterm -e java -jar selenium-server-standalone-2.53.1.jar -role node -nodeConfig nodes_config.json &

open -a "Safari" http://localhost:4444/grid/console#

cd ..\..\..

mvn test -Dsuite=grid