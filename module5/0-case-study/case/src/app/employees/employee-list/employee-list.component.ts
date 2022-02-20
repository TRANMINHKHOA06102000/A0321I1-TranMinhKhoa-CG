import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  public employees;
  public searchValue!:string;

  constructor(public _employeeService:EmployeeService) { }

  ngOnInit(): void {
    this._employeeService.getAllEmployees().subscribe(data=>{
      this.employees=data;
      console.log(this.employees)
    })
  }

  doSearch(){
    this._employeeService.search(this.searchValue.trim()).subscribe(
      (data) => this.employees = data
    );
  }
}
