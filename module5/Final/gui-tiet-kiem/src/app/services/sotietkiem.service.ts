import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ISoTietKiem} from "../model/SoTietKiem";

@Injectable({
  providedIn: 'root'
})
export class SotietkiemService {
  public API: string = 'http://localhost:3000/soTietKiem';
  public API_TYPE = 'http://localhost:3000/khachHang';

  constructor(private _http: HttpClient) {
  }

  getAllKhachHang(): Observable<any[]> {
    return this._http.get<any[]>(this.API_TYPE);
  }

  getAllSoTietKiem(): Observable<any> {
    return this._http.get(this.API);
  }

  findById(id: number): Observable<ISoTietKiem> {
    return this._http.get<ISoTietKiem>(this.API + "/" + id);
  }

  search(search: string): Observable<ISoTietKiem[]> {
    return this._http.get<ISoTietKiem[]>(this.API + '?kh_stk.name_like=' + search);
  }

  // search2Way(search: string, searchType: string): Observable<ICustomer[]> {
  //   console.log(search, searchType);
  //   return this.http.get<ICustomer[]>(this.API + '?name_like=' + search + '&cus_type.name_like=' + searchType);
  // }
  //
  // search3Way(search: string, gender: string, searchType: string): Observable<ICustomer[]> {
  //   console.log(search, searchType);
  //   return this.http.get<ICustomer[]>(this.API + '?name_like=' + search + '&gender_like=' + gender + '&cus_type.name_like=' + searchType);
  // }

  create(sotietkiem:ISoTietKiem): Observable<any> {
    return this._http.post(this.API, sotietkiem);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(sotietkiemId,sotietkiem:ISoTietKiem): Observable<ISoTietKiem> {
    return this._http.put<ISoTietKiem>(this.API + "/" + sotietkiemId, sotietkiem);
  }
}
