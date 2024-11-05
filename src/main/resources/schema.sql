-- schema.sql

CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
    -- Add additional fields as necessary, e.g., bio, profile_picture, etc.
);
