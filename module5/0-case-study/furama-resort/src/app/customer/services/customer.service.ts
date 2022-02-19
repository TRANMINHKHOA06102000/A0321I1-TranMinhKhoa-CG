import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { ICustomer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API: string = 'http://localhost:3000/customers';

  constructor(private _httpClient:HttpClient) {
  }

  getAllApi():Observable<any>{
    return this._httpClient.get(this.API+"?_sort=cus_id&_order=asc");
  }

  findById(id:number):Observable<ICustomer>{
    return this._httpClient.get<ICustomer>(this.API+"/"+id);
  }
  search(search: string): Observable<ICustomer[]> {
    return this._httpClient.get<ICustomer[]>(this.API + '?name_like=' + search);
  }

  create(customer:ICustomer):Observable<any>{
    return this._httpClient.post<any>(this.API,customer);
  }

  delete(id:number):Observable<any>{
    return this._httpClient.delete<any>(this.API+"/"+id)
  }
  update(id:any,customer:ICustomer):Observable<ICustomer>{
    return this._httpClient.put<ICustomer>(this.API+"/"+id,customer);
  }

}
