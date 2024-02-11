drop table if exists tasks;
create table tasks
(
    id      int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title   text            not null,
    text   text            not null,
    user_id int default 0 not null
);
