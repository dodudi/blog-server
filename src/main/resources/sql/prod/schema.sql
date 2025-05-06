CREATE TABLE IF NOT EXISTS post
(
    id               SERIAL PRIMARY KEY,
    title         VARCHAR(255),
    content         VARCHAR(255),
    author         VARCHAR(255),
    create_date_time TIMESTAMP(6),
    update_date_time TIMESTAMP(6),
    CONSTRAINT FK_role_id FOREIGN KEY (role_id) REFERENCES role_info (role_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES user_info (user_id) ON DELETE CASCADE
);