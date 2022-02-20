import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {EmployeeService} from 'src/app/services/employee.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {

  public formEditNewEmployee: FormGroup

  public employeeOfId;

  constructor(public _formBuilder: FormBuilder,
              public _employeeService: EmployeeService,
              public _router: Router,
              public _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.formEditNewEmployee = this._formBuilder.group({
      fullName: ['', [Validators.required]],
      position: ['', [Validators.required]],
      academicLevel: ['', [Validators.required]],
      part: ['', [Validators.required]],
      dateOfBirth: ['', [Validators.required]],
      identityNumber: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      salary: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
      address: ['', [Validators.required]]
    })

    this._activatedRoute.params.subscribe(data => {
      this.employeeOfId = data.id;
      this._employeeService.findById(this.employeeOfId).subscribe(data => {
        this.formEditNewEmployee.patchValue(data);
      })
    })
  }

  editEmployee() {
    this._employeeService.edit(this.formEditNewEmployee.value, this.employeeOfId).subscribe(data => {
      this._router.navigateByUrl('employee-list');
    })
  }
}
