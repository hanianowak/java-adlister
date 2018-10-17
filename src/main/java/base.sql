use adlister_db;

create table users (
id int unsigned not null auto_increment,
username varchar(50),
email varchar(50),
password varchar(50),
primary key (id)
);

create table ads (
id int unsigned not null auto_increment,
user_id int unsigned default null,
title varchar(250),
description varchar(250),
primary key (id),
foreign key (user_id) references users (id)
);

insert into users (username, email, password)
values ("hania", "h@jsd.com", "jsdssda"),
("tom", "sas@jdsf.com", "jdkajsdas"),
("peggy", "p@skdfs.com","ksjdskdf");
