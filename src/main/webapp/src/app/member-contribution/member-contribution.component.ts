import { FormControl } from '@angular/forms';
import { Contribution } from './../gen/model/contribution';
import { Member } from './../gen/model/member';
import { DatePipe } from '@angular/common';
import { CurrentUserService } from './../shared/current-user.service';
import { MemberContributionService } from './../gen/api/memberContribution.service';
import { Component, OnInit, Input } from '@angular/core';
import { MatTableDataSource, MatSort } from '@angular/material';
import {MatDatepicker} from '@angular/material/datepicker';
import * as _moment from 'moment';
import {Moment} from 'moment';

const moment = _moment;

@Component({
  selector: 'app-member-contribution',
  templateUrl: './member-contribution.component.html',
  styleUrls: ['./member-contribution.component.css']
})
export class MemberContributionComponent implements OnInit {
  @Input() memberId: string;
  private sub: any;
  contributionList: Contribution[];
  currentMember: Member;
  contributionColumnsToDisplay = ['documentId', 'paymentDate', 'fiscalMonth', 'fiscalYear', 'contributionCategory', 'amount','comments'];
  dataSource: any;
  

  constructor(private contributionService: MemberContributionService, private currentUserService: CurrentUserService, private datePipe: DatePipe) { }

  ngOnInit() {

if(this.memberId) {
  this.contributionService.getContribution(this.memberId, this.getToday(this.datePipe), this.getNextYear(this.datePipe)).subscribe(data => {
    this.contributionList = data.contributionHistory;
    this.dataSource = new MatTableDataSource(this.contributionList);
    });
}

  }
  
  public updateMemberState(gusssMember: Member) {
    this.currentUserService.changeMemberState(gusssMember);
  }

  public getToday(datePipe: DatePipe ): string {
    let date = new Date();
    date.setMonth(0);
    date.setDate(1);
    let dateToReturn =  datePipe.transform(date, 'dd-MM-yyyy');
    return dateToReturn;
  }

  public getNextYear(datePipe: DatePipe ): string {
    let date = new Date();
    let nextYear = date.getFullYear() + 1;
    date.setMonth(0);
    date.setDate(1);
    date.setFullYear(nextYear);
    let dateToReturn =  datePipe.transform(date, 'dd-MM-yyyy');
    return dateToReturn;
  }

  public getDateFromString(stringDate: string): Date {
    return new Date(stringDate);
  }


}
