import { BaseResponse } from './../../gen/model/baseResponse';
import { Member } from './../../gen/model/member';
import { UserRegistrationRequest } from './../../gen/model/userRegistrationRequest';
import { AppUser } from './../../gen/model/appUser';
import { BaseRequest } from './../../gen/model/baseRequest';
import { RegistrationService } from './../../gen/api/registration.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Gender } from './../../gen/model/gender';
import { Validators, FormGroupName, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Component, OnInit } from '@angular/core';
import * as _moment from 'moment';
import {Moment} from 'moment';

const moment = _moment;
export const MY_FORMATS = {
  parse: {
    dateInput: 'DD/MM/YYYY',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};
@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css'],
  providers:[{provide: MAT_DATE_FORMATS, useValue: MY_FORMATS}]
})
export class UserRegistrationComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  dob = new FormControl(moment());
  schemeJoinDate = new FormControl(moment());
  retirementDate = new FormControl(moment());

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
    {value: '0', viewValue: 'Active'},
    {value: '1', viewValue: 'Inactive'}
  ];
  memberCategory: any[] = [
    {value: 'YRA1999', viewValue: 'YRA1999'},
    {value: 'YRB2000', viewValue: 'YRB2000'}
  ];
  private userRegistrationRequest: UserRegistrationRequest;
  private appUser: AppUser;
  private gussMember: Member;
  baseResponse: BaseResponse;
  minDate = new Date(1910, 0, 1);
  maxDate = new Date();
  minJoinDate = new Date(1910, 0, 1);
  maxJoinDate = new Date(2120, 0, 1);
  minRetireDate = new Date();
  maxRetireDate = new Date(2120, 0, 1);
  constructor(private _formBuilder: FormBuilder, private registrationService: RegistrationService) {}

  ngOnInit() {
    this.buildFormColtrols();


  } 
  onSubmit() {
        // calling service
        this.userRegistrationRequest = this.buildUserRegistrationRequest(this.firstFormGroup.value, this.secondFormGroup.value);
        this.registrationService.registerUser(this.userRegistrationRequest).subscribe(data => {
          this.appUser = data.appUser;
          this.gussMember = data.gussMember;
          this.baseResponse = data.baseResponse;
        });
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
    this.firstFormGroup.addControl("dateOfBirth", this.dob);

    this.secondFormGroup= this._formBuilder.group({
      memberId: ['', Validators.required],
      membershipCategory: ['', Validators.required],
      //joinDate: ['', Validators.required],
      //retirementDate: ['', Validators.required],
      basicSalary: ['', Validators.required],
      address: ['', Validators.required]
    });
    this.secondFormGroup.addControl("joinDate", this.schemeJoinDate);
    this.secondFormGroup.addControl("retirementDate", this.retirementDate);
  }
  public buildUserRegistrationRequest(form1: any, form2: any): UserRegistrationRequest {
    let userRegistrationRequest: UserRegistrationRequest = {
      baseRequest: null,
      appUser: null,
      member: null
    };

    let dob = form1["dateOfBirth"].format("DD-MM-YYYY");
    let joinDate = form2["joinDate"].format("DD-MM-YYYY");
    let retirementDate = form2["retirementDate"].format("DD-MM-YYYY");
    let baseRequest: BaseRequest = null;
    let appUser: AppUser = <AppUser>form1;
    let member: Member = <Member>form2;

    appUser.dateOfBirth = dob;
    member.joinDate = joinDate;
    member.retirementDate = retirementDate;

    userRegistrationRequest.appUser = appUser;
    userRegistrationRequest.member = member;
    userRegistrationRequest.baseRequest = baseRequest;
    return userRegistrationRequest;
  }
}


