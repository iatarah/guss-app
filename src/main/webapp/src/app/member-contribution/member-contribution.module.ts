import { AppRoutingModule } from '../app.routing.module';
import { MemberContributionComponent } from './member-contribution.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MemberContributionEntryComponent } from './member-contribution-entry/member-contribution-entry.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTableModule} from '@angular/material/table';
import { DatePipe } from '@angular/common';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';

import {MomentDateModule} from '@angular/material-moment-adapter';
import { AuthGuard } from '../auth-guard.service';
import { RoleGuard } from '../role-guard.service';
import { AuthenticationService } from '../gen';
import { AuthService } from '../shared/_services/auth.service';
import { MemberContributionBenefitsComponent } from './member-contribution-benefits/member-contribution-benefits.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatTabsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    AppRoutingModule,
    MatStepperModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MomentDateModule,
  ],
  exports: [MemberContributionComponent, MatInputModule, MatTableModule, MemberContributionBenefitsComponent],
  declarations: [MemberContributionComponent, MemberContributionEntryComponent, MemberContributionBenefitsComponent, MemberContributionBenefitsComponent],
  providers: [
    DatePipe,
    AuthGuard,
    AuthenticationService,
    RoleGuard,
    AuthService,
  ]

})
export class MemberContributionModule { }
