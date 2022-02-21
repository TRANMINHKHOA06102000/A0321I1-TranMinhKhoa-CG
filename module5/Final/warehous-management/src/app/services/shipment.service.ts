import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShipmentService {
  public API: string = 'http://localhost:3000/shipment';
  public API_TYPE = 'http://localhost:3000/product';

  constructor(private _http: HttpClient) {
  }

  getAllProduct(): Observable<any[]> {
    return this._http.get<any[]>(this.API_TYPE);
  }

  getAllShipments(): Observable<any> {
    return this._http.get(this.API);
  }

  findById(id: number): Observable<any> {
    return this._http.get<any>(this.API + "/" + id);
  }

  search(search: string): Observable<any[]> {
    return this._http.get<any[]>(this.API + '?name_like=' + search);
  }

  create(shipment): Observable<any> {
    return this._http.post(this.API, shipment);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(shipment, shipmentId): Observable<any> {
    return this._http.put(this.API + "/" + shipmentId, shipment);
  }
}
