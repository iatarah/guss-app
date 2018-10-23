import { Injectable } from "@angular/core";
import { CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";

import { AuthenticationService } from "./gen";
import { AuthService } from "./shared/_services/auth.service";
import { AppConfig } from "./config/app.config";
import * as jwt_decode from "jwt-decode";

@Injectable()
export class RoleGuard implements CanActivate, CanActivateChild {


    constructor(public router: Router,
                public geneAuthService: AuthenticationService,
                public auth : AuthService) {

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        console.log("Am here");
        // const expectedRole = route.data.expectedRole;
        const expectedRole ='ROLE_ADMIN';
        const token = localStorage.getItem('currentUser');
        if(token != null || token != undefined) {
            console.log(token);
            console.log("Token on Role Guard");
            let tokenInfo = jwt_decode(token);
            console.log(tokenInfo);
            console.log(tokenInfo.scopes[0].authority);
            // console.log(tokenPayload.role);
            console.log(this.auth.isAuthenticated());
            if(!this.auth.isAuthenticated() || tokenInfo.scopes[0].authority !== expectedRole) {
                console.log('Am not Authenticated Role Guard');
                this.router.navigate([AppConfig.routes.login]);
                return false;
            }
            return true;
        } else {
            console.log('Role Guard token is null');
            return false;
        }
    }
 
    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        return this.canActivate(childRoute, state);
    }

    // canActivate(route: ActivatedRoute, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    //     console.log("Am here");
    //     // const expectedRole = route.data.expectedRole;
    //     const expectedRole ='staff';
    //     const token = localStorage.getItem('token');
    //     const tokenPayload = decode(token);
    //     if(!this.auth.isAuthenticated() || tokenPayload.role !== expectedRole) {
    //         this.router.navigate([AppConfig.routes.login]);
    //         return false;
    //     }
    //     return true;
    // }

    // canActivateChild(route: ActivatedRoute, state: RouterStateSnapshot) : Observable<boolean> | Promise<boolean> | boolean {
    //                      return this.canActivate(route, state);
    //                  }
}