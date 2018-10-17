import { CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthenticationService } from "src/app/gen/api/api";
import { AuthService } from "./shared/_services/auth.service";
import { AppConfig } from "./config/app.config";
import decode from 'jwt-decode';

//import { AuthenticationService } from ""

@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {
    constructor(public router: Router, 
                public geneAuthService: AuthenticationService,
                public auth : AuthService) {

    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if(!this.auth.isAuthenticated()) {
            console.log('Am Not Authenticated');
            this.router.navigate([AppConfig.routes.login]);
            return false;
        }
        console.log('Am not Authenticated');
        return true;
    }    
    
    canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        return this.canActivate(route, state);
    }         

}