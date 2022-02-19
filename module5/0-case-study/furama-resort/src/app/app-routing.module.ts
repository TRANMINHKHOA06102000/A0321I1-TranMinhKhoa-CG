import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { CustomerRoutingModule } from './customer/customer-routing.module';
import {NgxPaginationModule} from 'ngx-pagination';
const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'customer',
    loadChildren: ()=>import('./customer/customer.module').then(module=>module.CustomerModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),Ng2SearchPipeModule],
  exports: [RouterModule],

})
export class AppRoutingModule {
}
