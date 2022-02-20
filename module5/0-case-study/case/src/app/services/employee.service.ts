import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API: string = 'http://localhost:3000/employees';

  constructor(private _http: HttpClient) {
  }

  getAllEmployees():Observable<any>{
    return this._http.get(this.API);
  }
  search(search: string): Observable<any[]> {
    return this._http.get<any[]>(this.API + '?fullName_like=' + search);
  }
  create(employee):Observable<any>{
    return this._http.post(this.API,employee);
  }
}
