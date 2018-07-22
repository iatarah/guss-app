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
  constructor(private _formBuilder: FormBuilder) { }

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
}
  private buildFormColtrols() {
    this.firstFormGroup= this._formBuilder.group({
      memberId: ['', Validators.required],
      fiscalMonth: ['', Validators.required],
      fiscalYear: ['', Validators.required],
      paymentDate: ['', Validators.required],
      contributionCategory: ['', Validators.required]
    });
    this.secondFormGroup= this._formBuilder.group({
      comments: ['']
    });
  }
}
