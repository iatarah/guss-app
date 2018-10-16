import { Injectable } from "@angular/core";
import { AuthenticationService, LoginRequest } from "../../gen";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { JwtHelperService } from "@auth0/angular-jwt";

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

    public isAuthenticated() : boolean {
        const token = localStorage.getItem('token');
        return !this.jwtHelper.isTokenExpired(token);
    }

    public authenticateNew(loginRequest: LoginRequest) : Observable<any> {
        const headers = new HttpHeaders().set("Content-Type", "application/json")
        return this.httpClient.post('http://localhost:8080/guss-app/rest/ugguss/api/v1/token/auth',
        {
            "email": "john4@gmail.com",
            "password":"12345"
        }, { headers});
    }
}