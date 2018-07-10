import { UserProfileComponent } from './user-management/user-profile/user-profile.component';
import { LoginComponent } from './app-security/login/login.component';
import { MemberContributionComponent } from './member-contribution/member-contribution.component';
import { ModuleWithProviders, Component } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

export const AppRoutes: Routes = [
    {path: '', component: LoginComponent},
    {path: 'user-profile/:userName', component: UserProfileComponent},
    {path: 'contribution', component: MemberContributionComponent}
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(AppRoutes, {useHash: true});