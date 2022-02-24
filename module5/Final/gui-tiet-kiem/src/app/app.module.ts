import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SotietkiemListComponent } from './so-tiet-kiem/sotietkiem-list/sotietkiem-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import { SotietkiemCreateComponent } from './so-tiet-kiem/sotietkiem-create/sotietkiem-create.component';
import { SotietkiemEditComponent } from './so-tiet-kiem/sotietkiem-edit/sotietkiem-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    SotietkiemListComponent,
    SotietkiemCreateComponent,
    SotietkiemEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
