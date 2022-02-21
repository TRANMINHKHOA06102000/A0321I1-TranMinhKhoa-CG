import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ShipmentService} from "../../services/shipment.service";

@Component({
  selector: 'app-warehous-create',
  templateUrl: './warehous-create.component.html',
  styleUrls: ['./warehous-create.component.scss']
})
export class WarehousCreateComponent implements OnInit {
  public formCreateNewShipment:FormGroup
  public products;
  public product_shipment;
  public id;
  public name;
  public price;
  public unit;

  constructor(public _formBuilder:FormBuilder,
              public _shipmentService:ShipmentService,
              public _router:Router) { }

  ngOnInit(): void {
    this._shipmentService.getAllProduct().subscribe(data => {
      this.products = data;
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this.formCreateNewShipment=this._formBuilder.group({
      shipment_id: ['',[Validators.required,Validators.pattern("^LH-[\\d]{4}$")]],
      product_shipment: this._formBuilder.group({
        id: [''],
        name: ['', [Validators.required]],
        price: [''],
        unit: ['']
      }),
      amount: ['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      dateAdd: ['',[Validators.required]],
      dateProduce: ['',[Validators.required]],
      dateExpiration: ['',[Validators.required]]
    })
  }

  createShipment() {
    this._shipmentService.create(this.formCreateNewShipment.value).subscribe(data=>{
      this._router.navigateByUrl('warehous-list');
    })
    console.log(this.formCreateNewShipment);
  }

  changeProduct(type: any) {
    this.product_shipment = JSON.parse(type);
    this.id = this.product_shipment.id;
    this.name = this.product_shipment.name;
    this.price = this.product_shipment.price;
    this.unit = this.product_shipment.unit;
    console.log(this.product_shipment);
  }

}
