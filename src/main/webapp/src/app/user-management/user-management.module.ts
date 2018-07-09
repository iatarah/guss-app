import { ROUTING } from './../app.routing';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  imports: [
    CommonModule,
    ROUTING
  ],
  declarations: [UserProfileComponent],
  exports: [
    UserProfileComponent
  ]
})
export class UserManagementModule { }
