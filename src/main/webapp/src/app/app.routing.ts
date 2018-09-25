import { MemberProfileComponent } from './user-management/member-profile/member-profile.component';
import { MemberContributionEntryComponent } from './member-contribution/member-contribution-entry/member-contribution-entry.component';
import { UserRegistrationComponent } from './user-management/user-registration/user-registration.component';
import { UserProfileComponent } from './user-management/user-profile/user-profile.component';
import { LoginComponent } from './app-security/login/login.component';
import { MemberContributionComponent } from './member-contribution/member-contribution.component';
import { ModuleWithProviders, Component } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AuthGuard } from './auth-guard.service';

export const AppRoutes: Routes = [
   // {path: '', redirectTo:'login', pathMatch: 'full'},
    {path: '', component: LoginComponent, pathMatch: 'full'},
    {
        path: 'user-profile/:userName', 
        component: UserProfileComponent,
        canActivate: [AuthGuard],
        data: {
            expectedRole: 'staff'
        }
    },
    {path: 'contribution/:memberId', component: MemberContributionComponent},
    {path: 'registration', component: UserRegistrationComponent},
    {path: 'contribution-entry', component: MemberContributionEntryComponent},
    {path: 'member-profile/:memberId', component: MemberProfileComponent},
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(AppRoutes, {useHash: true});