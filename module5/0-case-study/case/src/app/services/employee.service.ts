import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IEmployee} from "../model/employee";


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API: string = 'http://localhost:3000/employees';

  constructor(private _http: HttpClient) {
  }

  getAllEmployees(): Observable<any> {
    return this._http.get(this.API);
  }

  findById(id: number): Observable<IEmployee> {
    return this._http.get<IEmployee>(this.API + "/" + id);
  }

  search(search: string): Observable<IEmployee[]> {
    return this._http.get<IEmployee[]>(this.API + '?fullName_like=' + search);
  }

  create(employee:IEmployee): Observable<any> {
    return this._http.post(this.API, employee);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(employee:IEmployee, employeeId:any): Observable<any> {
    return this._http.put(this.API + "/" + employeeId, employee);
  }
}
