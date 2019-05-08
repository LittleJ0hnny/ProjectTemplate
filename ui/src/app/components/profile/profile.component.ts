import {Component, HostListener, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/common";
import {ButtonModule} from 'primeng/button';
import {PanelModule} from 'primeng/panel';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenHeight: number;

  uploadedFile: File;

  imagePreview: string;

  constructor(@Inject(DOCUMENT) private document: any) {
    this.calculateSliderHeight();
  }

  ngOnInit() {
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
}
