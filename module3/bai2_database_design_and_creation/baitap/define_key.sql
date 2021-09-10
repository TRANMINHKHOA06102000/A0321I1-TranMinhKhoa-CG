create database define_key;
use define_key;
drop database define_key;
create table Customers(
	customer_number int auto_increment primary key,
    fullname varchar(50) not null,
    address varchar(100),
    email varchar(100),
    phone char(10)
);
create table Accounts(
	account_number int auto_increment primary key,
    account_type varchar(50) not null,
    date date not null,
    balance double not null,
    customer_number int,
    foreign key (customer_number) references Customers(customer_number)
);
create table Transactions (
	tran_number  int auto_increment primary key,
    account_number int,
    date date not null,
    amounts  double not null,
    descriptions varchar(100),
    foreign key (account_number) references Accounts(account_number)
);