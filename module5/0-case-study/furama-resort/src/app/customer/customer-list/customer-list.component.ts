import { Component, OnInit } from '@angular/core';
import { ICustomer } from '../model/customer';
import { CustomerService } from '../services/customer.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers!:ICustomer[];
  public searchValue!:string;
  public name!:string;
  public id!:number;
  constructor(private _service: CustomerService,
              private _router:Router,
              private _activeRouter:ActivatedRoute) { }

  // listCustomer: ICustomer[] = this._service.getAll();
  page: number=1;

  ngOnInit(): void {
    this._service.getAllApi().subscribe(data=>{
      this.customers=data;
    })
  }

  deleteCus(id:number){
    this._service.delete(id).subscribe(data=>{
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
    })
  }

  getCustomerName(id:number){
    this._service.findById(id).subscribe(data=>{
      this.name=data.name;
      this.id=data.id;
    });
  }

  doSearch(){
    this._service.search(this.searchValue.trim()).subscribe(
      (data) => this.customers = data
    );
  }

}
