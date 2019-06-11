import {Component, HostListener, Inject, OnInit, ViewEncapsulation} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginData} from "./loginData";
import {AuthService} from "../../../services/auth/auth.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {RegistrationComponent} from "../registration/registration.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  hide: boolean = true;

  //Profile Form and Model
  loginForm: FormGroup;
  loginData: LoginData;

  //Form controls
  loginControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.maxLength(25)
  ]);
  passwordControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(4),
    Validators.maxLength(16)
  ]);

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private dialog: MatDialog,
              public dialogRef: MatDialogRef<LoginComponent>,
              @Inject(MAT_DIALOG_DATA) public data: LoginData) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      login: this.loginControl,
      password: this.passwordControl
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(RegistrationComponent, {
      //width: Math.round(this.screenWidth/3.5) + 'px',
      //height: Math.round(this.screenHeight/2) + 'px',
      panelClass: 'my-dialog'
    });

    dialogRef.afterClosed().subscribe(result => {});
  }

  login() {
    this.loginData = this.loginForm.value;
    this.authService.signIn(this.loginData).subscribe();
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }
}
