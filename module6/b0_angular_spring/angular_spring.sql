-- create database angular_spring_connect;
INSERT INTO customer_type(customer_type_name)
	VALUES('Diamond'),
		  ('Platinium'),
          ('Gold'),
          ('Silver'),
          ('Member');

INSERT INTO customer(customer_type_id, customer_name, customer_birthday, customer_id_card, customer_phone, customer_email, customer_address, customer_gender)
	VALUES(1, 'Vo Thanh Luan', '2000-01-17', '212464739', '0383422211', 'thanhluan172@gmail.com', 'Quang Ngai', 1),
		  (1, 'Huynh Thanh Xuyen', '1994-07-01', '212464716', '0381723453', 'thanhxuyen11@gmail.com', 'Da Nang', 0),
		  (2, 'Tran Minh Khoa', '2003-05-11', '212464711', '0382716437', 'minhkhoa99@gmail.com', 'Vinh', 1),
          (3, 'Nguyen Van An', '1992-11-27', '212464790', '0371625341', 'vanan09@gmail.com', 'Quang Ngai', 1),
          (4, 'Tran Duc Chi', '2002-03-01', '212464788', '0301928172', 'ducchi01@gmail.com', 'Hue', 1),
          (5, 'Le Thi Ha', '2001-09-09', '212464791', '0351627183', 'hale37@gmail.com', 'Quang Nam', 0),
          (5, 'Bui Van Chung', '1999-12-12', '212464717', '0371827163', 'vanchung18@gmail.com', 'Quang Tri', 1);