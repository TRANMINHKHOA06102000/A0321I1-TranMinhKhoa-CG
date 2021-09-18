insert into vitri(tenViTri) values
('le tan'),
('phuc vu'),
('chuyen vien'),
('giam sat'),
('quan ly'),
('giam doc');
insert into trinhdo(trinhDo) values
('trung cap'),
('cao dang'),
('dai hoc'),
('sau dai hoc');
insert into bophan(tenBoPhan) values
('sale – marketing'),
('hanh chinh'),
('phuc vu'),
('quan ly');
insert into nhanvien(hoTen,idViTri,idTrinhDo,idBoPhan,ngaySinh,soCMTND,luong,sdt,email,diaChi) values
('Hoa Vo Khuyet',4,3,1,'2000-12-06','123123123456',10000000,'0357740063','khoa45@gmail.com','Da Nang'),
('Tran Minh Khoa',5,3,2,'2000-10-06','123123123459',10000000,'0357740062','khoa415@gmail.com','Quang Ngai'),
('Le Anh Minh',6,3,4,'2008-12-06','123123123458',8000000,'0357740061','khoa452@gmail.com','Quang Tri');
insert into loaikhach(tenLoaiKhach) values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');
insert into khachhang(idLoaiKhach,hoTen,ngaySinh,soCMTND,sdt,email,diaChi) values
(1,'Truong Tan Hai','1998-02-02','123123123477','0957740069','hai@gmail.com','Da Nang'),
(2,'Truong Tan Beo','1998-02-02','923123123479','0997740069','hai1@gmail.com','Quang Ngai'),
(2,'Truong Tan Beo','1998-02-02','923123123470','0997740060','hai0@gmail.com','Quang Ngai'),
(1,'Truong Tan Vui','1998-02-02','723123123437','0657740059','hai2@gmail.com','Da Nang');
insert into kieuthue(tenKieuThue, gia) values
('Year', 105000), 
('Month', 35000), 
('Day', 25000),
('Hour', 7984);
insert into loaidichvu(tenLoaiDichVu) values 
('Villa'), 
('House'), 
('Room');
insert into dichvu(tenDichVu,dienTich,sotang,soNguoiToiDa,chiPhiThue,idKieuThue,idLoaiDichVu,trangThai) values 
('Villa', 30, 99, 30, 900000, 1, 1,'booked'),
('House', 20, 15, 45, 800000, 2, 2,'booked'),
('House', 20, 15, 45, 800000, 3, 2,'booked'),
('Room', 10, 66, 15, 500000, 4, 3, 'booked'),
('Room', 5, 75, 15, 400000, 4, 3, 'booked'),
('Villa', 50, 12, 6, 900000, 3, 1, 'booked'),
('Villa', 60, 78, 69, 899000, 2, 1,'booked');
insert into dichvudikem (tenDichVuDiKem, gia, donVi, trangThaiKhaDung) values
('massage', 500000, 'VND', 'full'),
('karaoke', 500000, 'VND', 'full'),
('thuc an', 500000, 'VND', 'full'),
('nuoc uong', 500000, 'VND', 'full'),
('thue xe', 500000, 'VND', 'still');
insert into hopdong (idNhanvien, idKhachHang, idDichVu,ngayLamHopDong, ngayKetThuc, tienDatCoc,tongtien) values
(2, 2, 1,'2021-02-06', '2021-02-24', 5000000,10000000),
(2, 3, 4,'2021-02-06', '2021-02-24', 5000000,10000000),
(2, 3, 3,'2020-02-06', '2020-02-24', 5000000,10000000),
(3, 1, 2,'2021-04-06', '2021-05-18', 6000000,10000000);
insert into hopdongchitiet(idHopDong,idDichVuDiKem,soLuong) values
(1,5,2),
(2,1,5);