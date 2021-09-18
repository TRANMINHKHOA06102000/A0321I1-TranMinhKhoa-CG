create database case_study_sql;
use case_study_sql;
-- drop database case_study_sql;
create table vitri(
	idViTri int auto_increment not null,
    tenViTri varchar(45) not null,
    primary key(idViTri)
);
create table trinhdo(
	idTrinhDo int auto_increment not null,
    trinhDo varchar(45) not null,
    primary key(idTrinhDo)
);
create table bophan(
	idBoPhan int auto_increment not null,
    tenBoPhan varchar(45) not null,
    primary key(idBoPhan)
);
create table nhanvien(
	idNhanVien int auto_increment,
    hoTen varchar(50) not null,
    idViTri int not null,
    idTrinhDo int not null,
    idBoPhan int not null,
    ngaySinh date,
    soCMTND varchar(15),
    luong double,
    sdt char(10),
    email varchar(45),
    diaChi varchar(45),
    primary key(idNhanVien),
    foreign key(idViTri) references vitri(idViTri),
    foreign key(idTrinhDo) references trinhdo(idTrinhDo),
    foreign key(idBoPhan) references bophan(idBoPhan)
);
create table loaikhach(
	idLoaiKhach int auto_increment not null,
    tenLoaiKhach varchar(45) not null,
    primary key(idLoaiKhach)
);
create table khachhang(
	idKhachHang int auto_increment not null,
    idLoaiKhach int not null,
    hoTen varchar(45) not null,
    ngaySinh date,
    soCMTND varchar(15),
    sdt char(10),
    email varchar(45),
    diaChi varchar(45),
    primary key(idKhachHang),
    foreign key(idLoaiKhach) references loaikhach(idLoaiKhach)
);
create table kieuthue(
	idKieuThue int auto_increment not null,
    tenKieuThue varchar(45) not null,
    gia int not null,
    primary key(idKieuThue)
);
create table loaidichvu(
	idLoaiDichVu int auto_increment not null,
    tenLoaiDichVu varchar(45) not null,
    primary key(idLoaiDichVu)
);
create table dichvu(
	idDichVu int auto_increment not null,
    tenDichVu varchar(45) not null,
    dienTich int,
    sotang int,
    soNguoiToiDa int,
    chiPhiThue double,
    idKieuThue int not null,
    idLoaiDichVu int not null,
    trangThai varchar(45),
    primary key(idDichVu),
    foreign key(idKieuThue) references kieuthue(idKieuThue),
    foreign key(idLoaiDichVu) references loaidichvu(idLoaiDichVu)
);
create table dichvudikem(
	idDichVuDiKem int auto_increment not null,
    tenDichVuDiKem varchar(45) not null,
    gia int not null,
    donVi varchar(15) not null,
    trangThaiKhaDung varchar(45),
    primary key(idDichVuDiKem)
);
create table hopdong(
	idHopDong int auto_increment not null,
    idNhanvien int not null,
    idKhachHang int not null,
    idDichVu int not null,
    ngayLamHopDong date not null,
    ngayKetThuc date not null,
    tienDatCoc double,
    tongtien double,
    primary key(idHopDong),
    foreign key(idNhanvien) references nhanvien(idNhanvien),
    foreign key(idKhachHang) references khachhang(idKhachHang),
    foreign key(idDichVu) references dichvu(idDichVu)
);
create table hopdongchitiet(
	idHopDongChiTiet int auto_increment not null,
    idHopDong int not null,
    idDichVuDiKem int not null,
    soLuong int not null,
    primary key(idHopDongChiTiet),
    foreign key(idHopDong) references hopdong(idHopDong),
    foreign key(idDichVuDiKem) references dichvudikem(idDichVuDiKem)
);

