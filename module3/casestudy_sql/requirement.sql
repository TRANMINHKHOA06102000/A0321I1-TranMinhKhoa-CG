use case_study_sql;
-- câu 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select * ,length(hoTen) as soluongkituten
from nhanvien
where (hoten like 'H%') or  (hoten like 'T%') or (hoten like 'K%')
having soluongkituten<=15;
-- câu 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang;
select *, year(curdate())- year(ngaySinh) as tuoi
from khachhang
where (diaChi = 'Da Nang') or (diaChi = 'Quang Tri')
having tuoi between 18 and 50;
-- câu 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select count(hopdong.idKhachHang) as soluongdatphong,khachhang.idLoaiKhach,khachhang.hoTen,loaikhach.tenLoaiKhach
from khachhang inner join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach
			inner join hopdong on khachhang.idKhachHang=hopdong.idKhachHang
where loaikhach.tenLoaiKhach = 'Diamond'
group by khachhang.idKhachHang
order by soluongdatphong;
-- câu 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc,
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phòng.(Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khachhang.idKhachHang,khachhang.hoTen,loaikhach.tenLoaiKhach,hopdong.idHopDong,
		dichvu.tenDichVu,hopdong.ngayLamHopDong,hopdong.ngayKetThuc,
        (dichvu.chiPhiThue + hopdongchitiet.soLuong*dichvudikem.gia) as TongTien
from khachhang
left join loaikhach on khachhang.idLoaiKhach=loaikhach.idLoaiKhach
left join hopdong on khachhang.idKhachHang=hopdong.idKhachHang
left join hopdongchitiet on hopdong.idHopDong=hopdongchitiet.idHopDong
left join dichvudikem on dichvudikem.idDichVuDiKem=hopdongchitiet.idDichVuDiKem
left join dichvu on dichvu.idDichVu=hopdong.idDichVu
group by khachhang.hoTen;
-- câu 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
-- select dichvu.idDichVu,dichvu.tenDichVu,dichvu.chiPhiThue,loaidichvu.tenLoaiDichVu
-- from dichvu