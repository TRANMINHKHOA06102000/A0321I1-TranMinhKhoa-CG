import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import {CustomerUpdateComponent} from "./customer-update/customer-update.component";
const routes: Routes = [
  {path: 'listCus', component: CustomerListComponent},
  {path: 'createCus', component: CustomerCreateComponent},
  {path: 'updateCus/:id', component: CustomerUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
