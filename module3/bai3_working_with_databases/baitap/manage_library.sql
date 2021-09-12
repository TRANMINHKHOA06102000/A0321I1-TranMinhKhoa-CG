create database quan_ly_thu_vien;
use quan_ly_thu_vien;
create table loaisach(
	maLoai varchar(5) not null,
    tenLoaiSach varchar(50) not null,
    primary key(maLoai)
);
create table sach(
	maSach varchar(5) not null,
    tenSach varchar(50) not null,
    nhaXuatBan varchar(50) not null,
    tacGia varchar(50) not null,
    namXuatBan int not null,
    soLanXuatBan int not null,
    gia double not null,
    anh text,
    maLoai varchar(50),
    primary key(maSach),
    foreign key(maLoai) references loaiSach(maLoai)
);
create table sinhvien(
	maSinhVien varchar(5) not null,
    tenSinhVien varchar(50) not null,
    diaChi varchar(100) not null,
    email varchar(50) not null,
    soDienThoai char(10),
    anh text,
    primary key(maSinhVien)
);
create table thuthu(
	maThuThu varchar(5) not null,
    tenThuThu varchar(50) not null,
    diaChi varchar(100) not null,
    email varchar(50) not null,
    soDienThoai char(10),
    anh text,
    primary key(maThuThu)
);
create table dangkymuon(
	maSinhVien varchar(5) not null,
	maSach varchar(5) not null,
	ngayDangKy date not null,
	datMuon	char(1),
	tinhTrangMuon char(1),
    primary key(maSinhVien,maSach),
    foreign key (maSinhVien) references sinhvien(maSinhVien),
    foreign key (maSach) references sach(maSach)
);
create table phieumuon(
	maPhieuMuon varchar(5) not null,
	maSinhVien varchar(5) not null,
	maSach varchar(5) not null,
    maThuThu varchar(5) not null,
	ngayMuon date not null,
	ngayHenTra date not null ,check(ngayHenTra >= ngayMuon),
	ngayThucTra	date null ,check(ngayThucTra <= ngayHenTra),
	quaHan char(1),
	huHong char(1),
	matSach char(1),
	tienPhatCuonSach double,
	primary key(maPhieuMuon),
	foreign key (maThuThu) references thuthu(maThuThu),
	foreign key (maSinhVien) references sinhvien(maSinhVien),
    foreign key (maSach) references sach(maSach)
)