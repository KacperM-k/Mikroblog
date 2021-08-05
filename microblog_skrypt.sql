CREATE DATABASE microblog;
USE microblog;

CREATE TABLE IF NOT EXISTS Users (
username VARCHAR (50) NOT NULL PRIMARY KEY,
login VARCHAR (50) unique NOT NULL,
password VARCHAR (50) NOT NULL,
display_name VARCHAR (50) NOT NULL,
description VARCHAR (255) NOT NULL,
create_account_date date NOT NULL,
status VARCHAR (50) NOT NULL,
typ VARCHAR (50) NOT NULL,
enabled TINYINT NOT NULL DEFAULT 1
);

CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO Users VALUES
('email1@wp.pl', 'user1', '{noop}password1', 'Użytkownik1', 'początkujący bloger', '2021-07-18', 'active','user', 1), 
('email2@wp.pl', 'admin1', '{noop}admin', 'Admin', 'administrator zamieszania', '2021-07-18', 'active','admin', 1), 
('email3@wp.pl', 'user3', '{noop}password3', 'Użytkownik2', 'młody bloger', '2021-07-18', 'inactive','user', 1);

INSERT INTO authorities VALUES 
('email1@wp.pl', 'USER'), ('email2@wp.pl', 'ADMIN');

CREATE TABLE post (
id BIGINT AUTO_INCREMENT,
user_name  VARCHAR (50),
title VARCHAR (50),
description LONGTEXT NOT NULL,
publication_date DATE,
edit_date DATE,
PRIMARY KEY (id),
FOREIGN KEY (user_name) REFERENCES Users (username) 
);

CREATE TABLE reactions (
id BIGINT AUTO_INCREMENT,
user_name VARCHAR(50),
post_id BIGINT,
reaction_type VARCHAR(50),
PRIMARY KEY (id),
-- FOREIGN KEY (reaction_type) REFERENCES reactions_type (reaction_type),
FOREIGN KEY (user_name) REFERENCES Users (username),
FOREIGN KEY (post_id) REFERENCES post (id)
);

CREATE TABLE comments (
comment_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
post_id BIGINT,
comment_author VARCHAR(50),
comment_date DATE NOT NULL,
comment_text VARCHAR (160) NOT NULL,
FOREIGN KEY (post_id) REFERENCES post(id),
FOREIGN KEY (comment_author) REFERENCES Users(username)
);
