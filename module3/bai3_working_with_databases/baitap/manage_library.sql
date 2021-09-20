create database quan_ly_thu_vien;
use quan_ly_thu_vien;
-- drop database quan_ly_thu_vien;
create table loai_sach(
	ma_loai varchar(5) not null,
    ten_loai_sach varchar(50) not null,
    primary key(ma_loai)
);
create table sach(
	ma_sach varchar(5) not null,
    ten_sach varchar(50) not null,
    nha_xuat_ban varchar(50) not null,
    tac_gia varchar(50) not null,
    nam_xuat_xan int not null,
    so_lan_xuat_ban int not null,
    gia double not null,
    anh text,
    ma_loai varchar(50),
    primary key(ma_sach),
    foreign key(ma_loai) references loai_sach(ma_loai)
);
create table sinh_vien(
	ma_sinh_vien varchar(5) not null,
    ten_sinh_vien varchar(50) not null,
    dia_chi varchar(100) not null,
    email varchar(50) not null,
    so_dien_thoai char(10),
    anh text,
    primary key(ma_sinh_vien)
);
create table thu_thu(
	ma_thu_thu varchar(5) not null,
    ten_thu_thu varchar(50) not null,
    dia_chi varchar(100) not null,
    email varchar(50) not null,
    so_dien_thoai char(10),
    anh text,
    primary key(ma_thu_thu)
);
create table dang_ky_muon(
	ma_sinh_vien varchar(5) not null,
	ma_sach varchar(5) not null,
	ngay_dang_ky date not null,
	dat_muon	char(1),
	tinh_trang_muon char(1),
    primary key(ma_sinh_vien,ma_sach),
    foreign key (ma_sinh_vien) references sinh_vien(ma_sinh_vien),
    foreign key (ma_sach) references sach(ma_sach)
);
create table phieu_muon(
	ma_phieu_muon varchar(5) not null,
	ma_sinh_vien varchar(5) not null,
	ma_sach varchar(5) not null,
    ma_thu_thu varchar(5) not null,
	ngay_muon date not null,
	ngay_hen_tra date not null ,check(ngay_hen_tra >= ngay_muon),
	ngay_thuc_tra	date null ,check(ngay_thuc_tra <= ngay_hen_tra),
	qua_han char(1),
	hu_hong char(1),
	mat_sach char(1),
	tien_phat_cuon_sach double,
	primary key(ma_phieu_muon),
	foreign key (ma_thu_thu) references thu_thu(ma_thu_thu),
	foreign key (ma_sinh_vien) references sinh_vien(ma_sinh_vien),
    foreign key (ma_sach) references sach(ma_sach)
)