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
                public route : ActivatedRouteSnapshot,
                public geneAuthService: AuthenticationService,
                public auth : AuthService) {

    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        console.log("Am here");
        const expectedRole = route.data.expectedRole;
        const token = localStorage.getItem('token');
        const tokenPayload = decode(token);
        if(!this.auth.isAuthenticated() || tokenPayload.role !== expectedRole) {
            this.router.navigate([AppConfig.routes.login]);
            return false;
        }
        return true;
    }    
    
    
    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        return this.canActivate(this.route, state);
    }

                 
                

}