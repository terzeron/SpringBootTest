drop TABLE IF EXISTS book;
create table book(
      id int not null primary key,
      name varchar(50) not null,
      author varchar(50) not null,
      price int,
      creation_time datetime);