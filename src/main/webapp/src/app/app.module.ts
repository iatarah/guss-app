import { MemberContributionModule } from './member-contribution/member-contribution.module';
import { UserManagementModule } from './user-management/user-management.module';

import { AppSecurityModule } from './app-security/app-security.module';
import { LoginComponent } from './app-security/login/login.component';
import { ROUTING } from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import {ApiModule} from './gen/api.module';
import { MemberContributionComponent } from './member-contribution/member-contribution.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, 
    HttpClientModule, 
    ApiModule,
    ROUTING,
    FormsModule,
    ReactiveFormsModule,
    AppSecurityModule,
    UserManagementModule,
    MemberContributionModule,
    BrowserAnimationsModule
  ],
  exports: [
    LoginComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
