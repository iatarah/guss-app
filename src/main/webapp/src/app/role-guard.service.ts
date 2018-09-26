import { Injectable } from "@angular/core";
import { CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";

import { AuthenticationService } from "./gen";
import { AuthService } from "./shared/_services/auth.service";
import { AppConfig } from "./config/app.config";
import decode from 'jwt-decode';

@Injectable()
export class RoleGuard implements CanActivate, CanActivateChild {


    constructor(public router: Router,
                public geneAuthService: AuthenticationService,
                public auth : AuthService) {

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        console.log("Am here");
        // const expectedRole = route.data.expectedRole;
        const expectedRole ='staff';
        const token = localStorage.getItem('token');
        const tokenPayload = decode(token);
        if(!this.auth.isAuthenticated() || tokenPayload.role !== expectedRole) {
            this.router.navigate([AppConfig.routes.login]);
            return false;
        }
        return true;
        
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