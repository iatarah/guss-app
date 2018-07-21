import { FormGroup } from '@angular/forms';
import { Gender } from './../../gen/model/gender';
import { Validators, FormGroupName, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  userGender: any[] = [
    {value: 'M', viewValue: 'Male'},
    {value: 'F', viewValue: 'Female'}
  ];
  appUserRole: any[] = [
    {value: 'ADMIN', viewValue: 'Administrator'},
    {value: 'STAFF', viewValue: 'Staff'},
    {value: 'MEMBER', viewValue: 'Guss Member'}
  ];
  appUserStatus: any[] = [
    {value: 'active', viewValue: 'Active'},
    {value: 'inactive', viewValue: 'Inactive'}
  ];
  memberCategory: any[] = [
    {value: 'YRA1999', viewValue: 'YRA1999'},
    {value: 'YRB2000', viewValue: 'YRA1999'}
  ];
  constructor(private _formBuilder: FormBuilder) {}

  ngOnInit() {
    this.buildFormColtrols();
  }  
  form1(){
    console.log(this.firstFormGroup.value);
  }

  form2(){
    console.log(this.secondFormGroup.value);
  }

  private buildFormColtrols() {
    this.firstFormGroup= this._formBuilder.group({
      firstName: ['', Validators.required],
      middleName: ['', Validators.required],
      lastName: ['', Validators.required],
      userRole: ['', Validators.required],
      status: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      gender: ['', Validators.required]
    });
    this.secondFormGroup= this._formBuilder.group({
      memberId: ['', Validators.required],
      membershipCategory: ['', Validators.required],
      joinDate: ['', Validators.required],
      retirementDate: ['', Validators.required],
      basicSalary: ['', Validators.required],
      address: ['', Validators.required]
    });
  }
}


