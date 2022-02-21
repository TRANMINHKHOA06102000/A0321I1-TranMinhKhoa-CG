import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {EmployeeListComponent} from "./employees/employee-list/employee-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {EmployeeCreateComponent} from "./employees/employee-create/employee-create.component";
import {EmployeeEditComponent} from "./employees/employee-edit/employee-edit.component";
import {CustomerListComponent} from "./customers/customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customers/customer-create/customer-create.component";
import {CustomerEditComponent} from "./customers/customer-edit/customer-edit.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},

  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
