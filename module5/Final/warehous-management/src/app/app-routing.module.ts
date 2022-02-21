import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { WarehousListComponent } from './warehous/warehous-list/warehous-list.component';
import {WarehousCreateComponent} from "./warehous/warehous-create/warehous-create.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'warehous-list', component: WarehousListComponent},
  {path: 'warehous-create', component: WarehousCreateComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
