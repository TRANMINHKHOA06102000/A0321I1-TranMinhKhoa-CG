import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IXe} from "../model/xe";

@Injectable({
  providedIn: 'root'
})
export class XeService {

  public API: string = 'http://localhost:3000/xe';
  public API_TYPE = 'http://localhost:3000/diaDiem';

  constructor(private _http: HttpClient) {
  }

  getAllDiaDiems(): Observable<any[]> {
    return this._http.get<any[]>(this.API_TYPE);
  }

  getAllXes(): Observable<any> {
    return this._http.get(this.API);
  }

  findById(id: number): Observable<IXe> {
    return this._http.get<IXe>(this.API + "/" + id);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(xe: IXe, xeId: any): Observable<any> {
    return this._http.put(this.API + "/" + xeId, xe);
  }
}
