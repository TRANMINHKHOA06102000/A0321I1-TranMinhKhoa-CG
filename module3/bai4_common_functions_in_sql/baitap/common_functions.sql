create database common_function;
use common_function;
create table hoc_vien(
	id int auto_increment not null,
    ten varchar(15) not null,
    tuoi int not null,
    khoa_hoc varchar(50) not null,
    so_tien double not null,
    primary key(id)
);
insert into hocvien(ten,tuoi,khoa_hoc,so_tien) values
('Hoang',21,'cntt',400000),
('viet',19,'dtvt',320000),
('thanh',18,'ktdn',400000),
('nhan',19,'ck',450000),
('huong',20,'tcnh',500000),
('huong',20,'tcnh',200000);
-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select * from hoc_vien where ten='huong';
-- Viết câu lệnh lấy ra tổng số tiền của Huong
select ten,sum(so_tien) as 'tongTien' from hoc_vien where ten='huong';
-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select distinct ten from hoc_vien;
select ten from hoc_vien group by ten;