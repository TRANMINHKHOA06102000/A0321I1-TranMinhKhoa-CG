create database product_management;
use product_management;
create table category(
	category_id int auto_increment not null,
    category_name varchar(45) not null,
    primary key(category_id)
);
insert into category(category_name) values
('LapTop'),
('Điện Thoại'),
('Phụ Kiện');
create table product(
	product_id int auto_increment not null,
	product_name varchar(50) not null,
    product_price double not null,
    product_quantity int not null,
    product_color varchar(50) not null,
    product_description varchar(50) not null,
    category_id int,
    primary key(product_id),
    foreign key(category_id) references category(category_id) on update cascade on delete cascade
);
insert into product(product_name,product_price,product_quantity,product_color,product_description,category_id) values
('Lenovo ideapad',2000,3,'Đỏ','Hàng mới',1),
('Iphone 11',2500,4,'Xanh','Hàng mới',2),
('Iphone 12',2000,3,'Đen','Hàng mới',2),
('Pin dự phòng',1000,3,'Đen','Hàng mới',3);
