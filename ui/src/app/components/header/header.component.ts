import {Component, HostListener, OnInit, ViewEncapsulation} from '@angular/core';
import {LoginComponent} from "../auth/login/login.component";
import {MatDialog} from "@angular/material";
import {Router} from "@angular/router";
import {routesConst} from "../../modules/app-routing/app-routing.module";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {
  hide:boolean = false;

  firstname:string = "Ostap";
  lastname:string = "Kravtsiv";

  screenWidth: number;
  screenHeight: number;

  constructor(private dialog: MatDialog,
              private router: Router) {
    this.readScreenSize();
  }

  ngOnInit() {
  }

  @HostListener('window:resize', ['$event'])
  readScreenSize(event?) {
    this.screenWidth = window.innerWidth;
    this.screenHeight = window.innerHeight;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LoginComponent, {
      //width: Math.round(this.screenWidth/3.5) + 'px',
      //height: Math.round(this.screenHeight/2) + 'px',
      panelClass: 'my-dialog'
    });

    dialogRef.afterClosed().subscribe(result => {});
  }

  navigateToProfilePage() {
    this.router.navigate([{outlets: {primary: routesConst.profile, navigationBar: routesConst.profile}}]);
  }
}
