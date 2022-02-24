import { IKhachHang } from './KhachHang';

export interface ISoTietKiem {
  id:number,
  soTietKiem_id:string,
  khachHang:IKhachHang,
  ngayMo:string,
  thoiGianGui:string,
  kiHan:string,
  soTienGui:number,
  laiSuat:string,
  uuDai:string
}
