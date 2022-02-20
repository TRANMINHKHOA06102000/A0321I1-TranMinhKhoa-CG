import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {EmployeeListComponent} from "./employees/employee-list/employee-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {EmployeeCreateComponent} from "./employees/employee-create/employee-create.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
