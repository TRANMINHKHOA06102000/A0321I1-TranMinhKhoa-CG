import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  public employees;

  constructor(public employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data=>{
      this.employees=data;
      console.log(this.employees)
    })
  }

}
