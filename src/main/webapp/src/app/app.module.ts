import { MemberContributionModule } from './member-contribution/member-contribution.module';
import { UserManagementModule } from './user-management/user-management.module';

import { AppSecurityModule } from './app-security/app-security.module';
import { LoginComponent } from './app-security/login/login.component';
import { AppRoutingModule } from './app.routing.module';
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

import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { RoleGuard } from './role-guard.service';
import { AuthenticationService } from './gen';
import { AuthService } from './shared/_services/auth.service';
// import { JwtHelperService } from '@auth0/angular-jwt/src/jwthelper.service';
import { AuthGuard } from './auth-guard.service';
import { JwtModule } from '@auth0/angular-jwt';

export function getToken() {
  console.log('I am here getToken');
  var currentUser = JSON.parse(localStorage.getItem('currentUser'));
  var token = currentUser && currentUser.token;
  return token ? token : "";
}


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, 
    HttpClientModule, 
    ApiModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AppSecurityModule,
    UserManagementModule,
    MemberContributionModule,
    BrowserAnimationsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter : getToken,
        throwNoTokenError: true,
        whitelistedDomains: ['http://localhost:4200/#/login'],
        blacklistedRoutes: ['http://localhost:8080/guss-app/rest/ugguss/api/v1/token/auth']
      }
    })
  ],
  providers: [ 
    AuthService,
    AuthGuard, 
    RoleGuard,
    AuthenticationService

   ],
  exports: [
    LoginComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
