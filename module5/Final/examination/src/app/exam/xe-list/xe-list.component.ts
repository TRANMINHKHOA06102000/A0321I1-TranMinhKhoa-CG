import {Component, OnInit} from '@angular/core';
import {IXe} from "../../model/xe";
import {IDiaDiem} from "../../model/diadiem";
import {XeService} from "../../service/xe.service";
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-xe-list',
  templateUrl: './xe-list.component.html',
  styleUrls: ['./xe-list.component.scss']
})
export class XeListComponent implements OnInit {

  public xes!: IXe[];
  public page = 1;
  public biensoxe!: string;
  public id!: number;

  public diaDiems!: IDiaDiem[];

  constructor(public _xeService: XeService,
              private _router: Router,
              private _activeRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._xeService.getAllDiaDiems().subscribe(data => {
      this.diaDiems = data;
    }, error => {
      console.log('Failed to get list dia diem!');
    });

    this._xeService.getAllXes().subscribe(data => {
      this.xes = data;
    })
  }

  deleteXe(id: number) {
    this._xeService.delete(id).subscribe(data => {
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
      this.page = 1;
    })
  }

  getXeBienSoXe(id: number) {
    this._xeService.findById(id).subscribe(data => {
      this.biensoxe = data.biensoxe;
      this.id = data.id;
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
