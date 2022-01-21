import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HackernewsPractiseComponent } from './hackernews-practise/hackernews-practise.component';
import {FormsModule} from "@angular/forms";
import { LikesComponent } from './hackernews-practise/likes/likes.component';

@NgModule({
  declarations: [
    AppComponent,
    HackernewsPractiseComponent,
    LikesComponent
  ],
    imports: [
        BrowserModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
