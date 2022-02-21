import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  public customers;
  public page;
  public searchValue!:string;
  public name!:string;
  public id!:number;

  constructor(public _customerService:CustomerService,
              private _router:Router,
              private _activeRouter:ActivatedRoute) { }

  ngOnInit(): void {
    this._customerService.getAllCustomers().subscribe(data=>{
      this.customers=data;
    })
  }

  doSearch(){
    this._customerService.search(this.searchValue.trim()).subscribe(
      (data) => this.customers = data
    );
  }
  deleteCus(id:number){
    this._customerService.delete(id).subscribe(data=>{
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
    })
  }
  getCustomerName(id:number){
    this._customerService.findById(id).subscribe(data=>{
      this.name=data.name;
      this.id=data.id;
    });
  }

}
