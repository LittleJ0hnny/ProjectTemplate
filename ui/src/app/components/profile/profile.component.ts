import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Component, HostListener, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/common";
import {ProfileData} from "./profileData";
import {ButtonModule} from 'primeng/button';

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

  constructor(private formBuilder: FormBuilder,
              @Inject(DOCUMENT) private document: any) {
    this.calculateSliderHeight();
    this.profileData = new ProfileData();
    this.profileData.firstName = 'Ostap';
    this.profileData.lastName = 'Kravtsiv';
  }

  ngOnInit() {
    this.profileForm = this.formBuilder.group({
      firstName: this.firstNameControl,
      lastName: this.lastNameControl
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

  toggleEdit(data: string) {
    alert(data);
  }
}
