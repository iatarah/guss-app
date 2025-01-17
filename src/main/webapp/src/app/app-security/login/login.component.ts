import { AuthToken } from './../../gen/model/authToken';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService, LoginRequest } from '../../gen';
import { AuthService } from '../../shared/_services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted: boolean = false;
  invalidLogin: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router,
              private authService: AuthenticationService, private authServiceImpl : AuthService) { }


  onSubmit(user : any) {
    this.submitted = true;
    let loginRequest : LoginRequest = user;
    if (this.loginForm.invalid) {
      console.log(this.loginForm.invalid);
      return;
    }
    // TODO: call authentication service and authenticate user here
    if(loginRequest.email && loginRequest.password) {
      this.authService.authenticate(loginRequest).subscribe(
        (response: AuthToken) => {
          this.authServiceImpl.saveToken(response.token);
          sessionStorage.setItem("fName", response.appUser.firstName);
          sessionStorage.setItem("lName", response.appUser.lastName);
          sessionStorage.setItem("email", response.appUser.email);
        },
        (error : Error) => {
          console.log(error.message);
          console.log(error.name);
        },
        () => {
          this.router.navigate(['user-profile', loginRequest.email]);
        }
      );
    }else {
      this.invalidLogin = true;
      console.log("Invalid Login");
    }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  getErrorMessage() {
    return this.loginForm.get('email').hasError('required') ? 'Please enter a value' :
        this.loginForm.get('email').hasError('email') ? 'Not a valid email' : '';
  }

  getErrorMessagePassword() {
    return this.loginForm.get('password').hasError('required') ? 'Please enter a value' : '';
  }
}
