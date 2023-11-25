-- liquibase formatter sql

-- changeset vaverin:1
CREATE TABLE notification_task (
    id           bigserial primary key,
    chat_id      bigserial,
    text         varchar,
    date_time    timestamp
);