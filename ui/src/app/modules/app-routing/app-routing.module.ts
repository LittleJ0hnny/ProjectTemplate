import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {IndexComponent} from "../../components/index/index.component";
import {LoginComponent} from "../../components/auth/login/login.component";
import {RegistrationComponent} from "../../components/auth/registration/registration.component";
import {ProfileComponent} from "../../components/profile/profile.component";
import {MainNavigationComponent} from "../../components/main-navigation/main-navigation.component";


const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: IndexComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'profile', component: MainNavigationComponent, outlet: 'navigationBar'}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
