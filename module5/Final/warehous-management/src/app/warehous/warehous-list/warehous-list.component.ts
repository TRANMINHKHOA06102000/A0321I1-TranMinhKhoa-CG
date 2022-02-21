import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ShipmentService} from "../../services/shipment.service";

@Component({
  selector: 'app-warehous-list',
  templateUrl: './warehous-list.component.html',
  styleUrls: ['./warehous-list.component.scss']
})
export class WarehousListComponent implements OnInit {

  public shipments;
  public page;
  public searchValue!:string;
  public shipment_id!:string;
  public id!:number;

  constructor(public _shipmentService:ShipmentService,
              private _router:Router,
              private _activeRouter:ActivatedRoute) { }

  ngOnInit(): void {
    this._shipmentService.getAllShipments().subscribe(data=>{
      this.shipments=data;
    })
  }

  doSearch(){
    this._shipmentService.search(this.searchValue.trim()).subscribe(
      (data) => {
        this.shipments = data;
      });

  }
  deleteShip(id:number){
    this._shipmentService.delete(id).subscribe(data=>{
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
    })
  }
  getShipmentShipment_id(id:number){
    this._shipmentService.findById(id).subscribe(data=>{
      this.shipment_id=data.shipment_id;
      this.id=data.id;
    });
  }

}
