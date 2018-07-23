import { ROUTING } from './../app.routing';
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
    ROUTING,
    MatStepperModule,
    MatTableModule
  ],
  exports: [MemberContributionComponent, MatInputModule, MatTableModule],
  declarations: [MemberContributionComponent, MemberContributionEntryComponent]
})
export class MemberContributionModule { }
