CREATE TABLE posts
(
    id         SERIAL       NOT NULL,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    created_at timestamp    NOT NULL,
    updated_at timestamp    NOT NULL,
    PRIMARY KEY (id)
);
