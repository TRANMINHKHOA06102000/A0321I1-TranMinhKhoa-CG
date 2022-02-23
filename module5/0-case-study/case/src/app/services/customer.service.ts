import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { ICustomer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public API: string = 'http://localhost:3000/customers';
  public API_TYPE = 'http://localhost:3000/customerTypes';

  constructor(private _http: HttpClient) {
  }

  getAllCustomerType(): Observable<any[]> {
    return this._http.get<any[]>(this.API_TYPE);
  }

  getAllCustomers(): Observable<any> {
    return this._http.get(this.API);
  }

  findById(id: number): Observable<ICustomer> {
    return this._http.get<ICustomer>(this.API + "/" + id);
  }

  // search(search: string): Observable<ICustomer[]> {
  //   return this._http.get<ICustomer[]>(this.API + '?name_like=' + search);
  // }
  //
  // search2Way(search: string, searchGender: string): Observable<ICustomer[]> {
  //   console.log(search, searchGender);
  //   return this._http.get<ICustomer[]>(this.API + '?name_like=' + search + '&gender_like=' + searchGender);
  // }
  //
  // search3Way(search: string, searchGender: string, searchBirthday: string): Observable<ICustomer[]> {
  //   console.log(search, searchGender);
  //   return this._http.get<ICustomer[]>(this.API + '?name_like=' + search + '&gender_like=' + searchGender + '&birthday_like=' + searchBirthday);
  // }

  search4Way(search: string, searchGender: string, searchBirthday: string, searchType:string): Observable<ICustomer[]> {
    console.log(search, searchGender);
    return this._http.get<ICustomer[]>(this.API + '?name_like=' + search + '&gender_like=' + searchGender + '&birthday_like=' + searchBirthday+ '&cus_type.name_like=' + searchType);
  }

  create(customer:ICustomer): Observable<any> {
    return this._http.post(this.API, customer);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(customer:ICustomer, customerId:any): Observable<any> {
    return this._http.put(this.API + "/" + customerId, customer);
  }
}
