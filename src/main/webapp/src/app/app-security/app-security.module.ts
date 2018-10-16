import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { AppRoutingModule } from '../app.routing.module';
import { AuthGuard } from '../auth-guard.service';
import { RoleGuard } from '../role-guard.service';
import { AuthenticationService } from '../gen';
import { LogintestComponent } from './login_test/logintest.component';
import { AuthService } from '../shared/_services/auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    AppRoutingModule
  ],
  declarations: [
    LoginComponent,
    LogintestComponent
  ],
  providers: [
    AuthGuard, 
    RoleGuard,
    AuthenticationService,
    JwtHelperService,
    AuthService
  ],
  exports: [
    LoginComponent
  ]
})
export class AppSecurityModule { }
