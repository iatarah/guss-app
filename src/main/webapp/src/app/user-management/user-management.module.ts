import { MemberContributionComponent } from './../member-contribution/member-contribution.component';
import { MemberContributionModule } from './../member-contribution/member-contribution.module';
import { ROUTING } from './../app.routing';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
  imports: [
    CommonModule,
    ROUTING,
    MemberContributionModule,
    FormsModule,
    ReactiveFormsModule,
    MatTabsModule
  ],
  declarations: [UserProfileComponent, UserRegistrationComponent],
  exports: [UserProfileComponent, UserRegistrationComponent]
})
export class UserManagementModule { }
