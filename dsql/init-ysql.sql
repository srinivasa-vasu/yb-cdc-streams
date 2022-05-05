CREATE TABLE FLIGHT_SCHEDULE
(
    flight_no        text,
    scheduled_date   date,
    origin           text,
    destination      text,
    sta              timestamp without time zone,
    eta              timestamp without time zone,
    ata              timestamp without time zone,
    std              timestamp without time zone,
    etd              timestamp without time zone,
    atd              timestamp without time zone,
    scheduled_bay_Id text,
    actual_bay_id    text,
    primary key (flight_no, scheduled_date)
);