create database demo_jdbc;
use demo_jdbc;
create table users (
 id  int AUTO_INCREMENT not null,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(`name`,email,country) values
('Minh','minh@codegym.vn','Viet Nam'),
('Kante','kante@che.uk','Kenia');