create database demo;
use demo;
-- tạo bảng products
create table Products(
	id int auto_increment not null,
    productCode varchar(15) not null,
    productName varchar(50) not null,
    productPrice double not null,
    productAmount int not null,
    productDescription varchar(250),
    productStatus varchar(50),
    primary key(id)
);
-- chèn dữ liệu cho bảng products
insert into Products(productCode,productName,productPrice,productAmount) values
('P01','Iphone6',100000,5),
('P02','Iphone7',200000,5),
('P03','Iphone8',300000,5),
('P04','Iphone11',400000,5),
('P05','Iphone12',50000,5);
-- 1.index
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table Products add index index_productCode(productCode);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table Products add index index_name_price(productName,productPrice);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from Products;
-- 2.view
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view products_view as
select productCode, productName, productPrice, productStatus
from Products;
select * from products_view;
-- Tiến hành sửa đổi view
create or replace view products_view as
select productCode, productName, productPrice, productStatus
from Products
where productName='Iphone6';
select * from products_view;
-- Tiến hành xoá view
drop view products_view;
-- 3.store procedure
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure findAllProducts()
begin 
	select * from Products;
end //
delimiter ;
call findAllProducts();
-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure insertProducts()
begin 
	insert into Products(productCode,productName,productPrice,productAmount) values
	('P07','Iphone12 pro max',1200000,10);
end //
delimiter ;
call insertProducts();
select * from Products;
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure updateProducts(in id int, in product_name varchar(50))
begin 
	update Products
    set Products.productName=product_name
    where Products.id= id;
end //
delimiter ;
call updateProducts(5,'Samsung');
select * from Products;
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure deleteProducts(in id int)
begin 
	delete Products
    from Products
    where Products.id= id;
end //
delimiter ;
call deleteProducts(4);
select * from Products;

