import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {AlarmListComponent} from './alarm-list/alarm-list.component'
import {InformesComponent} from './informes/informes.component'

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'alarmList', component: AlarmListComponent },
  { path: 'informes', component: InformesComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
