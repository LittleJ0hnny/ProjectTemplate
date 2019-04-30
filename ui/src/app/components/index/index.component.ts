import {Component, HostListener, Inject, OnInit} from '@angular/core';
import {CarouselComponent} from "angular2-carousel";
import {IImage} from "ng-simple-slideshow";
import {DOCUMENT} from "@angular/common";
import {MatDialog} from "@angular/material";
import {LoginComponent} from "../auth/login/login.component";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  //images for main slider
  imageUrls: (string | IImage)[] = [{url: 'assets/images/Sourcing_a_Supplier.jpg'}];

  screenHeight: number;

  //configuration of little slider
  public degree = 25;
  public moreSlides = 3;

  constructor(@Inject(DOCUMENT) private document: any) {
    this.calculateSliderHeight();
  }

  ngOnInit() {
  }

  @HostListener('window:resize', ['$event'])
  calculateSliderHeight(event?) {
    this.screenHeight = window.innerHeight;
  }

  mainSliderHeight() {
    return Math.round(this.screenHeight/1.5) + 'px';
  }

  navigate(pagename: string) {
    this.document.location.href = pagename;
  }
}
