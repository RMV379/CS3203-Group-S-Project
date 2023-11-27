create table if not exists USERS (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName varchar(255),
    data binary large object
);

CREATE TABLE IF NOT EXISTS POSTS (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    content TEXT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES USERS(id)
);