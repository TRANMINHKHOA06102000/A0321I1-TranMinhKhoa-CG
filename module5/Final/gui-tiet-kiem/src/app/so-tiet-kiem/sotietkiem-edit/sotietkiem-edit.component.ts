import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {IKhachHang} from "../../model/KhachHang";
import {SotietkiemService} from "../../services/sotietkiem.service";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sotietkiem-edit',
  templateUrl: './sotietkiem-edit.component.html',
  styleUrls: ['./sotietkiem-edit.component.scss']
})
export class SotietkiemEditComponent implements OnInit {

  public formEditSoTietKiem: FormGroup
  public khachHangs!: IKhachHang[];

  public soTietKiemOfId;

  constructor(public _formBuilder: FormBuilder,
              public _sotietkiemService: SotietkiemService,
              public _router: Router,
              public _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._sotietkiemService.getAllKhachHang().subscribe(data => {
      this.khachHangs = data;
      console.log(data);
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this.formEditSoTietKiem = this._formBuilder.group({
      soTietKiem_id: ['',[Validators.required,Validators.pattern("^STK-[\\d]{4}$")]],
      kh_stk: ['',[Validators.required]],
      ngayMo: ['',[Validators.required]],
      thoiGianGui: ['',[Validators.required]],
      kiHan: ['',[Validators.required]],
      soTienGui: ['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      laiSuat: ['',[Validators.required]],
      uuDai: ['',[Validators.required]]
    })

    this._activatedRoute.params.subscribe(data => {
      this.soTietKiemOfId = data.id;
      this._sotietkiemService.findById(this.soTietKiemOfId).subscribe(data => {
        console.log(data);
        this.formEditSoTietKiem.patchValue(data);
      })
    })
  }

  editSoTietKiem() {
    this._sotietkiemService.edit(this.formEditSoTietKiem.value, this.soTietKiemOfId).subscribe(data => {
      this._router.navigateByUrl('sotietkiem-list');
      console.log(this.formEditSoTietKiem.value);
    })
  }


  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
