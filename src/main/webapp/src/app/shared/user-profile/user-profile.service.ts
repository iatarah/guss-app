import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient) {
   }
   getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/rest/ugguss/api/v1/profiles/johnDoe4@test.com');
  }
}
