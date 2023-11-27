create table if not exists USERS (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName varchar(255),
    data binary large object
);