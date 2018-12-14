import { BaseRequest } from './../../gen/model/baseRequest';
import { MemberProfileRequest } from './../../gen/model/memberProfileRequest';
import { UserRole } from './../../gen/model/userRole';
import { Member } from './../../gen/model/member';
import { AppUser } from './../../gen/model/appUser';
import { MemberProfileService } from './../../gen/api/memberProfile.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, OnDestroy } from '@angular/core';
import {Location} from '@angular/common';
import { CurrentUserService } from '../../shared/current-user.service';
@Component({
  selector: 'app-member-profile',
  templateUrl: './member-profile.component.html',
  styleUrls: ['./member-profile.component.css']
})
export class MemberProfileComponent implements OnInit, OnDestroy {

  private sub: any;
  appUser: AppUser;
  gussmember: Member;
  memberId: string;
  currentMember: Member;
  MEMBER_ROLE: string;
  ADMIN_ROLE: string;
  STAFF_ROLE: string;

  constructor(private route: ActivatedRoute, private memberProfileService: MemberProfileService, 
    private _location: Location, private currentUserService : CurrentUserService) { }

  ngOnInit() {
    this.init();
    this.sub = this.route.params.subscribe(params => {
      this.memberId = params['memberId']; 
   });

    this.memberProfileService.retrieveMemberWithMemberId(this.buildRequest(this.memberId)).subscribe(data => {
      this.gussmember = data.gussMember;
      this.appUser = data.appUser;
      this.updateMemberState(this.gussmember);
      this.updateAppState(this.appUser);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  private init() {
    this.ADMIN_ROLE = UserRole.ADMIN;
    this.STAFF_ROLE = UserRole.STAFF;
    this.MEMBER_ROLE = UserRole.MEMBER;
  }

  private buildRequest(memberId: string): MemberProfileRequest {
    let baseRequest: BaseRequest = null;
    let memberProfileRequest: MemberProfileRequest = null;
    memberProfileRequest = <MemberProfileRequest> {};
    memberProfileRequest.baseRequest = baseRequest;
    memberProfileRequest.memberId = memberId;
    return memberProfileRequest;
  }

  backClicked() {
    this._location.back();
  }

  updateMemberState(gusssMember: Member) {
    this.currentUserService.changeMemberState(gusssMember);
  }

  updateAppState(appUser : AppUser) {
    this.currentUserService.changeUserState(appUser);
  }
}
