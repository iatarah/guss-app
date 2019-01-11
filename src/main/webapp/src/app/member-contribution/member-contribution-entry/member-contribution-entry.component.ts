import { AppConstants } from './../../shared/constants';
import { AlertService } from './../../shared/_services/alert.service';
import { ContributionRequest } from './../../gen/model/contributionRequest';
import { Contribution } from './../../gen/model/contribution';
import { MemberContributionService } from './../../gen/api/memberContribution.service';
import { BaseRequest } from './../../gen/model/baseRequest';
import { BaseResponse } from './../../gen/model/baseResponse';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators, FormGroupName, FormBuilder } from '@angular/forms';
import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {MatDatepicker} from '@angular/material/datepicker';
import * as _moment from 'moment';
import {Moment} from 'moment';

const moment = _moment;
export const MY_FORMATS = {
  parse: {
    dateInput: 'MM/YYYY',
  },
  display: {
    dateInput: 'MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-member-contribution-entry',
  templateUrl: './member-contribution-entry.component.html',
  styleUrls: ['./member-contribution-entry.component.css'],
  providers:[{provide: MAT_DATE_FORMATS, useValue: MY_FORMATS}]
})
export class MemberContributionEntryComponent implements OnInit {
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  pensionContributionCategory: any[] = [
    {value: 'SELF', viewValue: 'Self'},
    {value: 'EMPLOYER', viewValue: 'Employer'}
  ];
  baseResponse: BaseResponse;
  createdContribution: Contribution;
  private contributionRequest: ContributionRequest;
  contributionSubmitAlert: boolean = false;
  contSubmitAlertstyle: any = null;

  constructor(private _formBuilder: FormBuilder, private contributionService: MemberContributionService, private alertService: AlertService) { }

  ngOnInit() {
    this.buildFormColtrols();
    
  }

  form1(){
    console.log(this.firstFormGroup.value);
  }
  form2(){
    console.log(this.secondFormGroup.value);
  }
  onSubmit() {
    // calling service
    this.contributionRequest = this.buildContributionRequest(this.firstFormGroup.value, this.secondFormGroup.value);
    console.log( this.firstFormGroup.get("fiscalDate").value.format("DD-MM-YYYY"));
    this.contributionService.createContribution(this.contributionRequest, this.contributionRequest.contribution.memberId).subscribe(data => {
      this.createdContribution = data.contribution;
      this.baseResponse = data.baseResponse;
    },
    undefined,
    () => {
      this.contributionSubmitAlert = true;
      if(this.baseResponse != null && this.baseResponse.returnCode == 0) {
        this.alertService.success(AppConstants.MSG_SUCCESS);
        this.contSubmitAlertstyle = this.getAlertStyles(AppConstants.CONST_SUCCESS);
        
      } else {
        this.alertService.error(AppConstants.MSG_SYSTEM_ERROR);
        this.contSubmitAlertstyle = this.getAlertStyles(AppConstants.CONST_ERROR);
        
      }
    });
   
}
date = new FormControl(moment());

  private buildFormColtrols() {
    this.firstFormGroup= this._formBuilder.group({
      memberId: ['', Validators.required],
      fiscalMonth: ['', Validators.required],
      fiscalYear: ['', Validators.required],
      contributionCategory: ['', Validators.required],
      documentId: ['', Validators.required],
      amount: ['', Validators.required],
    });
    this.firstFormGroup.addControl("fiscalDate", this.date);
    this.secondFormGroup= this._formBuilder.group({
      comments: ['']
    });
  }

  public buildContributionRequest(formGroup1: FormGroup, formGroup2: FormGroup): ContributionRequest {
    let contributionRequest: ContributionRequest = {
      baseRequest: null,
      contribution: null
    };
    let fMonth = formGroup1["fiscalDate"].format("DD-MM-YYYY");
    let fYear = formGroup1["fiscalDate"].format("DD-MM-YYYY");
    let comments = formGroup2["comments"];
    let baseRequest: BaseRequest = null;
    let contribution: Contribution = <Contribution>formGroup1;
    contribution.fiscalMonth = fMonth;
    contribution.fiscalYear = fYear;
    contribution.comments = comments;
    contributionRequest.contribution = contribution;
    contributionRequest.baseRequest = baseRequest;
    return contributionRequest;
  }

  chosenYearHandler(normalizedYear: Moment) {
    const ctrlValue = this.date.value;
    ctrlValue.year(normalizedYear.year());
    this.date.setValue(ctrlValue);
  }

  chosenMonthHandler(normlizedMonth: Moment, datepicker: MatDatepicker<Moment>) {
    const ctrlValue = this.date.value;
    
    ctrlValue.month(normlizedMonth.month());
    this.date.setValue(ctrlValue);
    datepicker.close();
  }
  showSuccess(message: string) { 
    this.alertService.success(message);
  }

  showError(message: string) { 
    this.alertService.error(message);
  }
  getAlertStyles(flag:string) {
    let cssClasses;
    if(flag == AppConstants.CONST_ERROR) {  
       cssClasses = {
         'alert_error': true,
         'alert_success': false 
       }	
    } else if(flag == AppConstants.CONST_SUCCESS){  
       cssClasses = {
        'alert_error': false,
        'alert_success': true 
       }	
    }
    return cssClasses;
  }
}
