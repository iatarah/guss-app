import { Contribution } from './../../gen/dist/model/contribution.d';
import { ContributionRequest } from './../../gen/dist/model/contributionRequest.d';
import { MemberContributionService } from './../../gen/api/memberContribution.service';
import { BaseRequest } from './../../gen/model/baseRequest';
import { BaseResponse } from './../../gen/model/baseResponse';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Validators, FormGroupName, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-member-contribution-entry',
  templateUrl: './member-contribution-entry.component.html',
  styleUrls: ['./member-contribution-entry.component.css']
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
  constructor(private _formBuilder: FormBuilder, private contributionService: MemberContributionService) { }

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
    this.contributionService.createContribution(this.contributionRequest, this.contributionRequest.contribution.memberId).subscribe(data => {
      this.createdContribution = data.contribution;
      this.baseResponse = data.baseResponse;
    });
   
}
  private buildFormColtrols() {
    this.firstFormGroup= this._formBuilder.group({
      memberId: ['', Validators.required],
      fiscalMonth: ['', Validators.required],
      fiscalYear: ['', Validators.required],
      paymentDate: ['', Validators.required],
      contributionCategory: ['', Validators.required],
      documentId: ['', Validators.required],
      amount: ['', Validators.required]
    });
    this.secondFormGroup= this._formBuilder.group({
      comments: ['']
    });
  }

  public buildContributionRequest(form1: any, form2: any): ContributionRequest {
    let contributionRequest: ContributionRequest = {
      baseRequest: null,
      contribution: null
    };
    let baseRequest: BaseRequest = null;
    let contribution: Contribution = form1;

    contributionRequest.contribution = contribution;
    contributionRequest.baseRequest = baseRequest;
    return contributionRequest;
  }
}
