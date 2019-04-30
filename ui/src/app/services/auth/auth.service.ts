import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {LoginData} from "../../components/auth/login/loginData";
import {Observable} from "rxjs";
import {RegistrationData} from "../../components/auth/registration/registrationData";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = environment.authServerUrl + '/login';
  private registrationUrl = environment.authServerUrl + '/registration';

  constructor(private http: HttpClient) {
  }

  signIn(loginData: LoginData): Observable<any> {
    return this.http.post(this.loginUrl, loginData);
  }

  signUp(registrationData: RegistrationData): Observable<any> {
    return this.http.post(this.registrationUrl, registrationData);
  }
}
