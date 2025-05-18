CREATE TABLE IF NOT EXISTS post
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(255),
    content          TEXT,
    author           VARCHAR(255),
    create_date_time TIMESTAMP(6),
    update_date_time TIMESTAMP(6)
);