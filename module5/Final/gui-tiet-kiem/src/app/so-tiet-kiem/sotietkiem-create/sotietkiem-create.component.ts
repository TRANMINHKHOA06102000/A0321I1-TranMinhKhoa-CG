import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {IKhachHang} from "../../model/KhachHang";
import {SotietkiemService} from "../../services/sotietkiem.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-sotietkiem-create',
  templateUrl: './sotietkiem-create.component.html',
  styleUrls: ['./sotietkiem-create.component.scss']
})
export class SotietkiemCreateComponent implements OnInit {

  public formCreateNewSoTietKiem:FormGroup
  public khachHangs!: IKhachHang[];

  constructor(public _formBuilder:FormBuilder,
              public _sotietkiemService:SotietkiemService,
              public _router:Router) { }

  ngOnInit(): void {
    this._sotietkiemService.getAllKhachHang().subscribe(data => {
      this.khachHangs = data;
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this.formCreateNewSoTietKiem=this._formBuilder.group({
      soTietKiem_id: ['',[Validators.required,Validators.pattern("^STK-[\\d]{4}$")]],
      kh_stk: ['',[Validators.required]],
      ngayMo: ['',[Validators.required]],
      thoiGianGui: ['',[Validators.required]],
      kiHan: ['',[Validators.required]],
      soTienGui: ['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      laiSuat: ['',[Validators.required]],
      uuDai: ['',[Validators.required]]
    })
  }

  createSoTietKiem() {
    this._sotietkiemService.create(this.formCreateNewSoTietKiem.value).subscribe(data=>{
      this._router.navigateByUrl('sotietkiem-list');
    })
    console.log(this.formCreateNewSoTietKiem);
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
