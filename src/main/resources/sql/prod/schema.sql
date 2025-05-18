CREATE TABLE IF NOT EXISTS post
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(255) not null,
    content          TEXT not null,
    author           VARCHAR(255) not null,
    format           VARCHAR(255) not null,
    create_date_time TIMESTAMP(6) not null,
    update_date_time TIMESTAMP(6) not null
);