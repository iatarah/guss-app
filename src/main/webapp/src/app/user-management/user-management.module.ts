import { AlertService } from './../shared/_services/alert.service';
import { AlertComponent } from './../shared/_directives/alert.component';
import { MemberContributionComponent } from './../member-contribution/member-contribution.component';
import { MemberContributionModule } from './../member-contribution/member-contribution.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatStepperModule} from '@angular/material/stepper';

import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule, MatIconModule} from '@angular/material';
import {MomentDateModule} from '@angular/material-moment-adapter';
import {MatListModule} from '@angular/material/list';
import { MemberProfileComponent } from './member-profile/member-profile.component';
import { AuthGuard } from '../auth-guard.service';
import { AuthService } from '../shared/_services/auth.service';
import { RoleGuard } from '../role-guard.service';
import { AppRoutingModule } from '../app.routing.module';
import { AuthenticationService } from '../gen';

@NgModule({
  imports: [
    CommonModule,
    AppRoutingModule,
    MemberContributionModule,
    FormsModule,
    ReactiveFormsModule,
    MatTabsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatStepperModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MomentDateModule,
    MatListModule,
    MatIconModule
  ],
  declarations: [
    UserProfileComponent, 
    UserRegistrationComponent,
    AlertComponent,
    MemberProfileComponent
  ],
  providers: [
    AlertService,
    AuthGuard, 
    RoleGuard,
    AuthService,
    AuthenticationService
  ],
  exports: [UserProfileComponent, UserRegistrationComponent]
})
export class UserManagementModule { }
