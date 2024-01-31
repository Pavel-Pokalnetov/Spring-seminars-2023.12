create schema if not exists userstable;
create table if not exists users(
    id int not null auto_increment primary key,
    name varchar(32) not null,
    password varchar(256) not null,
    user_group varchar(32) not null
    );