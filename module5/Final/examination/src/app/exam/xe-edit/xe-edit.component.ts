import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {IDiaDiem} from "../../model/diadiem";
import {XeService} from "../../service/xe.service";

@Component({
  selector: 'app-xe-edit',
  templateUrl: './xe-edit.component.html',
  styleUrls: ['./xe-edit.component.scss']
})
export class XeEditComponent implements OnInit {

  public formEditXe: FormGroup
  public diaDiems!: IDiaDiem[];

  public xeOfId;

  constructor(public _formBuilder: FormBuilder,
              public _xeService: XeService,
              public _router: Router,
              public _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._xeService.getAllDiaDiems().subscribe(data => {
      this.diaDiems = data;
      console.log(data);
    }, error => {
      console.log('Failed to get list dia diem!');
    });

    this.formEditXe = this._formBuilder.group({
      biensoxe: ['', [Validators.required]],
      loaixe: ['', [Validators.required]],
      tennhaxe: ['', [Validators.required]],
      diadiem_diden: ['', [Validators.required]],
      sodienthoai: ['', [Validators.required, Validators.pattern('^(090|093|097)[0-9]{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      giodi: ['', [Validators.required]],
      gioden: ['', [Validators.required]],
    })

    this._activatedRoute.params.subscribe(data => {
      this.xeOfId = data.id;
      this._xeService.findById(this.xeOfId).subscribe(data => {
        console.log(data);
        this.formEditXe.patchValue(data);
      })
    })
  }

  editXe() {
    this._xeService.edit(this.formEditXe.value, this.xeOfId).subscribe(data => {
      this._router.navigateByUrl('xe-list');
      console.log(this.formEditXe.value);
    })
  }


  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
