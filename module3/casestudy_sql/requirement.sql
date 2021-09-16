use case_study_sql;
-- câu 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select * ,length(hoTen) as soluongkituten
from nhanvien
where (hoten like 'H%') or  (hoten like 'T%') or (hoten like 'K%')
having soluongkituten<=15;
-- câu 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang;
select *, year(now())- year(ngaySinh) as tuoi
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
select dichvu.idDichVu,dichvu.tenDichVu,dichvu.dienTich,dichvu.chiPhiThue,loaidichvu.tenLoaiDichVu,temp.ngayLamHopDong
from dichvu
left join (select * from hopdong where hopdong.ngayLamHopDong between '2021-01-01' and '2021-03-31') as temp 
			on dichvu.idDichVu= temp.idDichVu
inner join loaidichvu on dichvu.idLoaiDichVu= loaidichvu.idLoaiDichVu
group by dichvu.tenDichVu
having temp.ngayLamHopDong is null;
-- câu 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2021
-- nhưng chưa từng được Khách hàng đặt phòng trong năm 2020.
select dichvu.idDichVu,dichvu.tenDichVu,dichvu.dienTich,dichvu.soNguoiToiDa,dichvu.chiPhiThue,loaidichvu.tenLoaiDichVu
from dichvu
inner join loaidichvu on dichvu.idLoaiDichVu=loaidichvu.idLoaiDichVu
left join (select * from hopdong where year(ngayLamHopDong)=2021) as temp1
	on dichvu.idDichVu=temp1.idDichVu
left join (select * from hopdong where year(ngayLamHopDong)=2020) as temp2
	on dichvu.idDichVu=temp2.idDichVu
where temp1.idDichVu is null;
-- câu 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinct khachhang.hoTen from khachhang;
select khachhang.hoTen from khachhang group by khachhang.hoTen;
select hoTen from khachhang union select hoTen from khachhang;
-- câu 9.Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
select sum((dichvu.chiPhiThue + hopdongchitiet.soLuong*dichvudikem.gia)) as TongTien,
		count(khachhang.idKhachHang) as 'soluongkhachdatphong',
        month(hopdong.ngayLamHopDong) as 'thang'
from hopdong
inner join khachhang on hopdong.idKhachHang=khachhang.idKhachHang
inner join dichvu on dichvu.idDichVu=hopdong.idDichVu
inner join hopdongchitiet on hopdongchitiet.idHopDong=hopdong.idHopDong
inner join dichvudikem on dichvudikem.idDichVuDiKem=hopdongchitiet.idDichVuDiKem
where year(hopdong.ngayLamHopDong)=2021
group by thang;
-- câu 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.idHopDong,hopdong.ngayLamHopDong,hopdong.ngayKetThuc,hopdong.tienDatCoc,
		count(hopdongchitiet.idHopDongChiTiet) as 'SoLuongDichVuDiKem'
from hopdong
join hopdongchitiet on hopdong.idHopDong=hopdongchitiet.idHopDong
join dichvudikem on hopdongchitiet.idDichVuDiKem=dichvudikem.idDichVuDiKem
group by hopdong.idHopDong
order by hopdong.idHopDong;
-- câu 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
