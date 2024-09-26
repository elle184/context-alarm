import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AlarmListComponent } from './alarm-list/alarm-list.component';
import { InformesComponent } from './informes/informes.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AlarmListComponent,
    InformesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
