import { Injectable } from "@angular/core";
import { AuthenticationService, LoginRequest } from "../../gen";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import * as jwt_decode from "jwt-decode";
import * as moment from "moment";

@Injectable()
export class AuthService extends AuthenticationService {
    private currentUserKey : string = 'currentUser';
    
    constructor(httpClient: HttpClient) {
        super(null, null, null);
    }

    getToken(): String {
        console.log('I am here getToken');
        let savedToken : string = localStorage.getItem('currentUser');
        let currentUser;
        if(savedToken != null || savedToken != undefined) {
          console.log(savedToken);
          currentUser = savedToken;
        } else {
          currentUser = null;
          console.log('No User is logged');
        }
        // var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        // var currentUser = null;
        var token = currentUser && currentUser.token;
        return token ? token : "";
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        localStorage.removeItem(this.currentUserKey);
    }

    public saveToken(token: string) : void {
        localStorage.setItem(this.currentUserKey, token);
    }

    public isAuthenticated() : boolean {
        const token = localStorage.getItem(this.currentUserKey);
        // return !this.jwtHelper.isTokenExpired(token);
        if(token != null) {
            let tokenInfo = jwt_decode(token);
            let expireDate = tokenInfo.exp;

            console.log(expireDate);
            console.log(tokenInfo);
            console.log(!moment().isBefore(expireDate));
            return !moment().isBefore(expireDate);
            //return true;

            //return !this.helper.isTokenExpired(token);
        } else {
            return false;
        }
    }

    public getTokenInfo(token) : any {
        // let tokenInfo = jwt_decode(token);
        // return tokenInfo;
        let tokenInfo = jwt_decode(token);
        return tokenInfo;
    }

}