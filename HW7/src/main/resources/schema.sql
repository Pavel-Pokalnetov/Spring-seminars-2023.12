create schema if not exists userstable;
drop table if exists users;
create table if not exists users(
    id int not null auto_increment primary key,
    name varchar(32) not null,
    password varchar(256) not null,
    user_group Text not null
    );