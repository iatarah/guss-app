import { CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthenticationService } from "src/app/gen/api/api";
//import { AuthenticationService } from ""

@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {
    constructor(private myRoute : Router,
                private auth: AuthenticationService) {}

    // canActivate(route: ActivatedRouteSnapshot,
    //             state: RouterStateSnapshot) Observable<boolean> | Promise<boolean> | boolean {
    //                 if (!this.auth.isA)
    //             }
}