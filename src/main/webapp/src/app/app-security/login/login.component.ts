import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService, LoginRequest } from '../../gen';


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
              private authService: AuthenticationService) { }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    console.log("Am here on submit");
    // TODO: call authentication service and authenticate user here
    if(this.loginForm.controls.email.value && this.loginForm.controls.password.value) {
      console.log("Am here inside");
      // let loginRequest: LoginRequest = null;
      //  loginRequest.password = this.loginForm.controls.password.value;
      // // loginRequest.email = this.loginForm.controls.email.value;
      // this.authService.authenticate(loginRequest).subscribe(
      //   (response: any) => {
      //     console.log("Response coming from authentication");
      //     console.log(response);
      //   }
      // )
        this.router.navigate(['user-profile', this.loginForm.controls.email.value]);
    }else {
      this.invalidLogin = true;
    }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

}
