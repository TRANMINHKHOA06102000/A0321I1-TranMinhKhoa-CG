create database table_manipulation;
use table_manipulation; 
drop database table_manipulation;
-- tạo bảng contacts
create table contacts(
	contact_id int(11) not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(25),
    brithday date,
    constraint contacts_pk primary key(contact_id)
);

CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

DROP TABLE contacts;
DROP TABLE contacts, suppliers;
-- thêm cột mới
ALTER TABLE contacts
  ADD last_names varchar(40) NOT NULL
    AFTER contact_id;
-- thêm nhiều cột mới
ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id,
  ADD first_name varchar(35) NULL
    AFTER last_name;
-- xóa cột
ALTER TABLE contacts
  DROP COLUMN last_names;
-- chỉnh sửa mô tả của một cột
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
-- thay đổi tên cột
ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL;
-- đổi tên bảng
ALTER TABLE contacts
  RENAME TO people;