import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {XeListComponent} from "./exam/xe-list/xe-list.component";
import {XeEditComponent} from "./exam/xe-edit/xe-edit.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'xe-list', component: XeListComponent},
  {path: 'xe-edit/:id', component: XeEditComponent},


  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
