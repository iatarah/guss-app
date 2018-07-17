import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  submitted: boolean = false;
  invalidRegistration: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  onSubmit() {
    this.submitted = true;
    if (this.registrationForm.invalid) {
      return;
    }
    console.log("submitted");
    // TODO: 1) Validate that the user making call has right role to register:
    // 2) call registration API and register user here
    /**
         if(this.registrationForm.controls.email.value && this.registrationForm.controls.password.value) {
        this.router.navigate(['user-profile', this.registrationForm.controls.email.value]);
    }else {
      this.invalidRegistration = true;
    }
     */
    
  }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      middleName: ['', Validators.required],
    });
  }
}
