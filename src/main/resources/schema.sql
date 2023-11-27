create table if not exists users (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name varchar(255),
    data binary large object
);