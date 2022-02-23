import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  public customers;
  public page = 1;
  public name!: string;
  public id!: number;

  public searchValue: string="";

  public searchGender: string = "";
  public searchBirthday: string = "";

  public customerTypes!: any[];
  public searchType: string = "";

  constructor(public _customerService: CustomerService,
              private _router: Router,
              private _activeRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._customerService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this._customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
    })
  }

  doSearch() {
    this._customerService.search(this.searchValue.trim()).subscribe(
      (data) => {
        this.page = 1;
        this.customers = data
      }
    );
  }

  doSearch2() {
    this._customerService.search2Way(this.searchValue.trim(), this.searchGender).subscribe(
      (data) => {
        this.page = 1;
        this.customers = data
      }
    );
  }

  doSearch3() {
    this._customerService.search3Way(this.searchValue.trim(), this.searchGender, this.searchBirthday).subscribe(
      (data) => {
        this.page = 1;
        this.customers = data
      }
    );
  }

  doSearch4() {
    this._customerService.search4Way(this.searchValue, this.searchGender, this.searchBirthday, this.searchType).subscribe(
      (data) => {
        this.page = 1;
        this.customers = data
      }
    );
  }

  deleteCus(id: number) {
    this._customerService.delete(id).subscribe(data => {
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
      this.page=1;
    })
  }

  getCustomerName(id: number) {
    this._customerService.findById(id).subscribe(data => {
      this.name = data.name;
      this.id = data.id;
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
