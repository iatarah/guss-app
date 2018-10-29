import { Injectable } from "@angular/core";
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    private blackList = [
        'http://localhost:8080/guss-app/rest/ugguss/api/v1/token/auth'
    ]
    
    constructor(private authServiceImpl : AuthService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        console.log(request.urlWithParams);
        console.log("Interceptor blacklist");
        // If request is not in whitlist add header
        if(!this.blackList.includes(request.url)) {
            console.log("I was not here");
            console.log(request.url);
            let myToken : string = localStorage.getItem('currentUser');
            let result = this.authServiceImpl.isAuthenticated();
            if(result && myToken != null) {
                console.log(myToken);
                console.log("Am in interceptor");
                request = request.clone({
                    setHeaders: {
                        Authorization: `Bearer ${myToken}`
                    }
                });
            }
        }
        return next.handle(request);
    }
}