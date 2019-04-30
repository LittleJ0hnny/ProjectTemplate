import {Component, Inject, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth/auth.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {RegistrationData} from "./registrationData";

export class PasswordValidation {

  static MatchPassword(AC: AbstractControl) {
    let password = AC.get('password').value;
    let confirmPassword = AC.get('confirmPassword').value;
    if (password != confirmPassword) {
      AC.get('confirmPassword').setErrors({MatchPassword: true})
    } else {
      return null
    }
  }
}

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  hide: boolean = true;
  registrationForm: FormGroup;
  registrationData: RegistrationData;

  emailControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.email,
    Validators.maxLength(225)
  ]);

  firstnameControl: FormControl = new FormControl('', [
    Validators.maxLength(255)
  ]);

  lastnameControl: FormControl = new FormControl('', [
    Validators.maxLength(255)
  ]);

  passwordControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(6),
    Validators.maxLength(16)
  ]);

  confirmPasswordControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(6),
    Validators.maxLength(16)
  ]);

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              public dialogRef: MatDialogRef<RegistrationComponent>,
              @Inject(MAT_DIALOG_DATA) public data: RegistrationData) {
  }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      email: this.emailControl,
      firstname: this.firstnameControl,
      lastname: this.lastnameControl,
      password: this.passwordControl,
      confirmPassword: this.confirmPasswordControl},
      {
      validator: PasswordValidation.MatchPassword
    });
  }

  register() {
    console.log("Register");
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }
}
