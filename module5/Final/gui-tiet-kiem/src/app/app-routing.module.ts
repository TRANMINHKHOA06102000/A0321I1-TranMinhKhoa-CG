import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {SotietkiemListComponent} from "./so-tiet-kiem/sotietkiem-list/sotietkiem-list.component";
import {SotietkiemCreateComponent} from "./so-tiet-kiem/sotietkiem-create/sotietkiem-create.component";
import {SotietkiemEditComponent} from "./so-tiet-kiem/sotietkiem-edit/sotietkiem-edit.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'sotietkiem-list', component: SotietkiemListComponent},
  {path: 'sotietkiem-create', component: SotietkiemCreateComponent},
  {path: 'sotietkiem-edit/:id', component: SotietkiemEditComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
