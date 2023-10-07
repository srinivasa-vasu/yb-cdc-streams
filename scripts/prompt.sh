#!/usr/bin/env bash

. pscript

TYPE_SPEED=50

DEMO_PROMPT="${GREEN}➜ ${CYAN}\W ${COLOR_RESET}"

clear

PROMPT_TIMEOUT=1

p "Press enter to test cdc-streams workflow from ysql to ycql"

PROMPT_TIMEOUT=0

p "Checking ycql alerts keyspace for any flight watch events!"

PROMPT_TIMEOUT=1

ycqlsh $(hostname -i) -k alerts -e "select * from flight_watch"

p "Inserting flight schedule data to ysql to test cdc flow event to ycql"

PROMPT_TIMEOUT=0

ysqlsh -h $(hostname -i) -c "insert into flight_schedule(flight_no, scheduled_date, origin, destination, sta, eta, ata, std, etd, atd, scheduled_bay_Id) values('YB529', current_date, 'SIN', 'IND', (now()+interval '320 minutes')::timestamp, (now()+interval '320 minutes')::timestamp, (now()+interval '320 minutes')::timestamp, (now()+interval '10 minutes')::timestamp, (now()+interval '30 minutes')::timestamp, (now()+interval '30 minutes')::timestamp, 'T4');"

PROMPT_TIMEOUT=1

p "Checking ycql alerts keyspace for any flight watch events!"

ycqlsh $(hostname -i) -k alerts -e "select * from flight_watch"

PROMPT_TIMEOUT=0

p "Checking an update event flow!"

PROMPT_TIMEOUT=1

p "Update flight schedule: estimated departure delayed by 20 minutes"

PROMPT_TIMEOUT=0

ysqlsh -h $(hostname -i) -c "update flight_schedule set(std, etd, atd, sta, eta, ata, origin, destination, scheduled_bay_Id) =((now()+interval '10 minutes')::timestamp, (now()+interval '30 minutes')::timestamp, (now()+interval '30 minutes')::timestamp, (now()+interval '320 minutes')::timestamp, (now()+interval '320 minutes')::timestamp, (now()+interval '320 minutes')::timestamp, 'SIN', 'IND', 'T4') where flight_no='YB529' and scheduled_date = current_date;"

PROMPT_TIMEOUT=1

p "Checking ycql alerts keyspace for any flight watch events!"

ycqlsh $(hostname -i) -k alerts -e "select * from flight_watch"

p "That's it with the cdc stream event from from ysql to ycql!"

cmd

p ""
