import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {IndexComponent} from "../../components/index/index.component";
import {LoginComponent} from "../../components/auth/login/login.component";
import {RegistrationComponent} from "../../components/auth/registration/registration.component";
import {ProfileComponent} from "../../components/profile/profile.component";
import {MainNavigationComponent} from "../../components/main-navigation/main-navigation.component";

export const routesConst = {
  index: 'index',
  profile: 'profile'
};

export const outletConst = {
  mainNavBar: 'navigationBar'
};

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: routesConst.index, component: IndexComponent},
  {path: routesConst.profile, component: ProfileComponent},
  {path: routesConst.profile, component: MainNavigationComponent, outlet: outletConst.mainNavBar}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
