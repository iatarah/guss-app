import { MyMaterialModule } from './../mymaterial.module';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { UserMenuComponent } from './user-menu/user-menu.component';

@NgModule({
  declarations: [ToolbarComponent, UserMenuComponent],
  imports: [
    CommonModule,
    MyMaterialModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
],
  exports: [
    ToolbarComponent,
    UserMenuComponent
  ]
})
export class ToolbarModule { }
