import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from 'src/app/services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.scss']
})
export class EmployeeCreateComponent implements OnInit {

  public formCreateNewEmployee:FormGroup

  constructor(public _formBuilder:FormBuilder,
              public _employeeService:EmployeeService,
              public _router:Router) { }

  ngOnInit(): void {
    this.formCreateNewEmployee=this._formBuilder.group({
      fullName: ['',[Validators.required]],
      position: ['',[Validators.required]],
      academicLevel: ['',[Validators.required]],
      part: ['',[Validators.required]],
      dateOfBirth: ['',[Validators.required]],
      identityNumber: ['',[Validators.required,Validators.pattern('^[0-9]{9}$')]],
      salary: ['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      email: ['',[Validators.required,Validators.email]],
      phoneNumber: ['',[Validators.required, Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
      address: ['',[Validators.required]]
    })
  }

  createEmployee() {
    this._employeeService.create(this.formCreateNewEmployee.value).subscribe(data=>{
      this._router.navigateByUrl('employee-list');
    })
    console.log(this.formCreateNewEmployee);
  }

}
