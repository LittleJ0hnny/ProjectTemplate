import {Component, HostListener, OnInit, ViewEncapsulation} from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {
  screenWidth: number;
  screenHeight: number;

  constructor(private dialog: MatDialog) {
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
}
