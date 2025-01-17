import { MemberProfileComponent } from './user-management/member-profile/member-profile.component';
import { MemberContributionEntryComponent } from './member-contribution/member-contribution-entry/member-contribution-entry.component';
import { UserRegistrationComponent } from './user-management/user-registration/user-registration.component';
import { UserProfileComponent } from './user-management/user-profile/user-profile.component';
import { LoginComponent } from './app-security/login/login.component';
import { MemberContributionComponent } from './member-contribution/member-contribution.component';
import { ModuleWithProviders, Component, NgModule } from '@angular/core';
import {RouterModule, Routes, PreloadAllModules} from '@angular/router';
import { AuthGuard } from './auth-guard.service';
import { AuthService } from './shared/_services/auth.service';
import { RoleGuard } from './role-guard.service';
import { AppConfig } from './config/app.config';

export const appRoutes: Routes = [
   // {path: '', redirectTo:'login', pathMatch: 'full'},
    {path: '', redirectTo:'login', pathMatch: 'full'},
    {path: AppConfig.routes.login, component: LoginComponent },
    {
        path: 'user-profile/:userName', 
        component: UserProfileComponent,
        canActivate: [RoleGuard],
        data: {
             expectedRole: ['ROLE_STAFF', 'ROLE_ADMIN','ROLE_GUSS_MEMBER']
         }
    },
    {path: 'contribution/:memberId', component: MemberContributionComponent},
    {path: 'registration', component: UserRegistrationComponent},
    {path: 'contribution-entry', component: MemberContributionEntryComponent},
    {path: 'member-profile/:memberId', component: MemberProfileComponent},
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules, useHash: true})
    ],
    exports: [
        RouterModule
    ],
    providers: [
        AuthService
    ]
})
export class AppRoutingModule {

}
