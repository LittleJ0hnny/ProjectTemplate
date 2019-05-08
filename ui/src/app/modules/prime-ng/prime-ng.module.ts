import { NgModule } from '@angular/core';
import {ButtonModule} from "primeng/button";
import {PanelModule} from 'primeng/panel';
import {FileUploadModule} from "primeng/primeng";

@NgModule({
  exports: [
    ButtonModule,
    FileUploadModule,
    PanelModule
  ],
  declarations: []
})
export class PrimeNgModule { }
