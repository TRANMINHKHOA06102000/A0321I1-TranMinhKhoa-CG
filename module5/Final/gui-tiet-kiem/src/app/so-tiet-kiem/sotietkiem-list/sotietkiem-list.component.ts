import {Component, OnInit} from '@angular/core';
import {ISoTietKiem} from "../../model/SoTietKiem";
import {SotietkiemService} from "../../services/sotietkiem.service";
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-sotietkiem-list',
  templateUrl: './sotietkiem-list.component.html',
  styleUrls: ['./sotietkiem-list.component.scss']
})
export class SotietkiemListComponent implements OnInit {

  public sotietkiems: ISoTietKiem[];

  public page = 1;

  public searchValue: string = "";
  public searchThoiGianGui: string = "";
  public searchLaiSuat: string = "";

  public soTietKiem_id!: string;
  public id!: number;

  constructor(public _sotietkiemService: SotietkiemService,
              private _router: Router,
              private _activeRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._sotietkiemService.getAllSoTietKiem().subscribe(data => {
      this.sotietkiems = data;
    })
  }

  doSearch() {
    this._sotietkiemService.search(this.searchValue, this.searchThoiGianGui, this.searchLaiSuat).subscribe(
      (data) => {
        this.page = 1;
        this.sotietkiems = data;
      });

  }

  deleteSoTietKiem(id: number) {
    this._sotietkiemService.delete(id).subscribe(data => {
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
      this.page = 1;
    })
  }

  getSoTietKiemsoTietKiem_id(id: number) {
    this._sotietkiemService.findById(id).subscribe(data => {
      this.soTietKiem_id = data.soTietKiem_id;
      this.id = data.id;
    });
  }

}
