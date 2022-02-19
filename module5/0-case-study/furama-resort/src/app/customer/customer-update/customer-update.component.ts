import { Component, OnInit } from '@angular/core';
import { ICustomer } from '../model/customer';
import { ICustomerType } from '../model/customer-type';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { CustomerService } from '../services/customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TypeCustomerService } from '../services/type-customer.service';

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {
  customer!: ICustomer;
  customerTypes!: ICustomerType[];
  id!: string;
  message!:string;
  constructor(private _customerService: CustomerService,
              private _activeRouter: ActivatedRoute,
              private _serviceTypeCus: TypeCustomerService,
              private router: Router) {
  }

  updateForm = new FormGroup({
      id: new FormControl(''),
      cus_id: new FormControl('',
        [Validators.required, Validators.pattern("^KH-[\\d]{4}$")]),
      cus_type: new FormControl('',[Validators.required]),
      name: new FormControl('',[Validators.required]),
      birthday: new FormControl('',[Validators.required]),
      gender: new FormControl('',[Validators.required]),
      id_card: new FormControl('',
        [Validators.required,Validators.pattern("^(\\d{9}$)")]),
      phone: new FormControl('',
        [Validators.required,Validators.pattern("0?(\\d{10}$)")]),
      email: new FormControl('',
        [Validators.required,Validators.pattern("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")]),
      address: new FormControl('',[Validators.required])
    }
  );

  get getCusId() {
    return this.updateForm.get("cus_id");
  }
  get getBirthday() {
    return this.updateForm.get("birthday");
  }
  get getType() {
    return this.updateForm.get("cus_type");
  }
  get getName() {
    return this.updateForm.get("name");
  }

  get getIdCard() {
    return this.updateForm.get("id_card");
  }

  get getPhone() {
    return this.updateForm.get("phone");
  }

  get getEmail() {
    return this.updateForm.get("email");
  }

  get getAddress() {
    return this.updateForm.get("address");
  }
  get getGender() {
    return this.updateForm.get("gender");
  }

  ngOnInit(): void {
    // @ts-ignore
    this._serviceTypeCus.getAllCustomerType().subscribe(data => {
      // @ts-ignore
      this.customerTypes = data;
    });
    this._activeRouter.paramMap.subscribe((param) => {
      this.id = param.get("id");
      this._customerService.findById(Number(this.id)).subscribe((data: ICustomer) => {
          this.updateForm.patchValue(data);
          this.updateForm.get('birthday').patchValue(this.formatDate(data.birthday));
        }
      );
    })
  }

  updateCus() {
    console.log(this.updateForm.get("name"));
    this._customerService.update(this.id, this.updateForm.value).subscribe(data => {
      this.router.navigateByUrl('detailCus/' + this.id);
      this.message="Update customer successful";
    })
  }

  formatDate(date) {
    const d = new Date(date);
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();
    const year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }

  compareWith(val1, val2) {
    return val1.id === val2.id;
  }

}
