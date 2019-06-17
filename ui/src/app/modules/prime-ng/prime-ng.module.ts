import { NgModule } from '@angular/core';
import {ButtonModule} from "primeng/button";
import {PanelModule} from 'primeng/panel';
import {FileUploadModule} from "primeng/primeng";
import {RadioButtonModule} from 'primeng/radiobutton';
import {CalendarModule} from 'primeng/calendar';
import {InputMaskModule} from 'primeng/inputmask';

@NgModule({
  exports: [
    ButtonModule,
    FileUploadModule,
    PanelModule,
    RadioButtonModule,
    CalendarModule,
    InputMaskModule
  ],
  declarations: []
})
export class PrimeNgModule { }
