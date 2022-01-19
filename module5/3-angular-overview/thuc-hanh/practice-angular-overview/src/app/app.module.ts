import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PetComponent} from "./pet/pet.component";
import {FontSizeEditorComponent} from "./font-size-editor/profile.component";
import {InstallBootstrapComponent} from "./install-bootstrap/install-bootstrap.component";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    PetComponent,
    FontSizeEditorComponent,
    InstallBootstrapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
