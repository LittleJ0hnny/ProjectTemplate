import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Component, HostListener, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/common";
import {ProfileData} from "./profileData";
import {ButtonModule} from 'primeng/button';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputMaskModule} from 'primeng/inputmask';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenHeight: number;

  //Profile Form and Model
  profileForm: FormGroup;
  profileData: ProfileData;

  uploadedFile: File;

  imagePreview: string;

  //Form controls
  firstNameControl: FormControl = new FormControl('', [
    Validators.maxLength(255)
  ]);
  lastNameControl: FormControl = new FormControl('', [
    Validators.maxLength(255)
  ]);
  genderControl: FormControl = new FormControl('', [
  ]);
  birthDateControl: FormControl = new FormControl('', [
  ]);
  zipCodeControl: FormControl = new FormControl('', [
  ]);
  mobilePhoneControl: FormControl = new FormControl('', [
  ]);

  //Form controls visibility
  firstName: boolean = false;
  lastName: boolean = false;
  gender: boolean = false;
  birthDate: boolean = false;
  zipCode: boolean = false;
  mobilePhone: boolean = false;

  constructor(private formBuilder: FormBuilder,
              @Inject(DOCUMENT) private document: any) {
    this.calculateSliderHeight();
    this.profileData = new ProfileData();
    this.profileData.firstName = 'Ostap';
    this.profileData.lastName = 'Kravtsiv';
    this.profileData.gender = 'Male';
    this.profileData.birthDate = new Date();
    this.profileData.zipCode = 79005;
    this.profileData.mobilePhone = '(063)-903-3115';
  }

  ngOnInit() {
    this.profileForm = this.formBuilder.group({
      firstName: this.firstNameControl,
      lastName: this.lastNameControl,
      gender: this.genderControl,
      birthDate: this.birthDateControl,
      zipCode: this.zipCodeControl,
      mobilePhone: this.mobilePhoneControl
    });
    this.imagePreview = 'https://previews.123rf.com/images/artemstepanov/artemstepanov1606/artemstepanov160601228/57881761-vector-male-face-avatar-template-pictogram-button-round-trendy-flat-icon-with-man-for-business-inter.jpg';
  }

  @HostListener('window:resize', ['$event'])
  calculateSliderHeight(event?) {
    this.screenHeight = window.innerHeight;
  }

  onFileUpload(event) {
    this.uploadedFile = event.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.uploadedFile);
  }

  changeVisibility(fieldName: string) {
    switch(fieldName) {
      case 'firstName': {
        this.firstName = !this.firstName;
        break;
      }
      case 'lastName': {
        this.lastName = !this.lastName;
        break;
      }
      case 'gender': {
        this.gender = !this.gender;
        break;
      }
      case 'birthDate': {
        this.birthDate = !this.birthDate;
        break;
      }
      case 'zipCode': {
        this.zipCode = !this.zipCode;
        break;
      }
      case 'mobilePhone': {
        this.mobilePhone = !this.mobilePhone;
        break;
      }
    }
  }

  toggleEdit(data: string) {
    alert(data);
  }
}
