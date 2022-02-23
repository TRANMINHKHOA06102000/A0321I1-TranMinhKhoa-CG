import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IShipment} from "../model/shipment";

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

  findById(id: number): Observable<IShipment> {
    return this._http.get<IShipment>(this.API + "/" + id);
  }

  search(searchName: string, searchDateExpiration: string): Observable<IShipment[]> {
    return this._http.get<IShipment[]>(this.API + '?product_shipment.name_like=' + searchName+ '&dateExpiration_like=' + searchDateExpiration);
  }

  create(shipment:IShipment): Observable<any> {
    return this._http.post(this.API, shipment);
  }

  delete(id: number): Observable<any> {
    return this._http.delete<any>(this.API + "/" + id)
  }

  edit(shipment:IShipment, shipmentId:any): Observable<any> {
    return this._http.put(this.API + "/" + shipmentId, shipment);
  }
}
