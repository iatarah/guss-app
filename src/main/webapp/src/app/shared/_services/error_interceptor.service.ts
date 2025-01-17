import { HttpInterceptor, HttpRequest, HttpEvent, HttpHandler } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AuthService } from "../_services/auth.service";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private authServiceImpl: AuthService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if(err.status === 401) {
                // auto logout if 401 response returned from api
                this.authServiceImpl.logout();
            }
            const error = err.error.message || err.statusText;
            return throwError(error);
        }));
    }
}