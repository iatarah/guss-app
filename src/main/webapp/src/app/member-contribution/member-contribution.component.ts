import { Member } from './../gen/dist/model/member.d';
import { CurrentUserService } from './../shared/current-user.service';
import { MemberContributionService } from './../gen/api/memberContribution.service';
import { Component, OnInit, Input } from '@angular/core';
import { Contribution } from '../gen/dist';

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
  constructor(private contributionService: MemberContributionService, private currentUserService: CurrentUserService) { }

  ngOnInit() {

if(this.memberId) {
  this.contributionService.getContribution(this.memberId, "", "").subscribe(data => {
    this.contributionList = data.contributionHistory;
    });
}

  }
  
  public updateMemberState(gusssMember: Member) {
    this.currentUserService.changeMemberState(gusssMember);
  }
}
