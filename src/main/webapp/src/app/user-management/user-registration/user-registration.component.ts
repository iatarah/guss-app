import { BaseResponse } from './../../gen/dist/model/baseResponse.d';
import { AppUser } from './../../gen/model/appUser';
import { BaseRequest } from './../../gen/model/baseRequest';
import { Member } from './../../gen/dist/model/member.d';
import { UserRegistrationRequest } from './../../gen/dist/model/userRegistrationRequest.d';
import { RegistrationService } from './../../gen/api/registration.service';
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
    {value: '0', viewValue: 'Active'},
    {value: '1', viewValue: 'Inactive'}
  ];
  memberCategory: any[] = [
    {value: 'YRA1999', viewValue: 'YRA1999'},
    {value: 'YRB2000', viewValue: 'YRA1999'}
  ];
  private userRegistrationRequest: UserRegistrationRequest;
  private appUser: AppUser;
  private gussMember: Member;
  baseResponse: BaseResponse;
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
          console.log("In method now >>>>>>>>>>");
          console.log(this.baseResponse);
        });
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
  public buildUserRegistrationRequest(form1: any, form2: any): UserRegistrationRequest {
    let userRegistrationRequest: UserRegistrationRequest = {
      baseRequest: null,
      appUser: null,
      member: null
    };
    let baseRequest: BaseRequest;
    let appUser: AppUser = form1;
    let member: Member = form2;

    userRegistrationRequest.appUser = appUser;
    userRegistrationRequest.member = member;
    userRegistrationRequest.baseRequest = null;
    return userRegistrationRequest;
  }
}


