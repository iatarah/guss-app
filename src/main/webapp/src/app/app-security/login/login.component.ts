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
      // let loginRequest: LoginRequest = null;
      // loginRequest.email = this.loginForm.controls.email.value;
      // loginRequest.password = this.loginForm.controls.password.value;
      this.authService.authenticate(loginRequest).subscribe(
        (response: any) => {
          console.log("Response coming from authentication");
          console.log(response.token);
          this.authServiceImpl.saveToken(response.token);
        },
        (error : Error) => {
          console.log(error.message);
          console.log(error.name);
        }
      );
      this.router.navigate(['user-profile', loginRequest.email]);
    }else {
      this.invalidLogin = true;
      console.log("Invalid Login");
    }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

}
