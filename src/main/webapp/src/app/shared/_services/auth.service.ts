import { Injectable } from "@angular/core";
import { AuthenticationService } from "../../gen";
import { JwtHelperService } from '@auth0/angular-jwt';
import { HttpClient } from "@angular/common/http";

@Injectable()
export class AuthService extends AuthenticationService {
    
    constructor(public jwtHelper : JwtHelperService, httpClient: HttpClient) {
        super(null, null, null);
    }

    getToken(): String {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        var token = currentUser && currentUser.token;
        return token ? token : "";
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

    isAuthenticated() : boolean {
        const token = localStorage.getItem('token');
        return !this.jwtHelper.isTokenExpired(token);
    }
}