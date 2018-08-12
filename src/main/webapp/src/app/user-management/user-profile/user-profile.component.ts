import { Validators } from '@angular/forms';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AppUser } from './../../gen/model/appUser';
import { UserRole } from './../../gen/model/userRole';
import { CurrentUserService } from './../../shared/current-user.service';
import { Member } from './../../gen/model/member';
import { UserService } from './../../gen/api/user.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit, OnDestroy {
  
  private sub: any;
  appUser: AppUser;
  gussmember: Member;
  userName: string;
  currentMember: Member;
  MEMBER_ROLE: string;
  ADMIN_ROLE: string;
  STAFF_ROLE: string;
  clearMevalue = ''
  memberLookUpForm: FormGroup;
  constructor(private userService: UserService, private route: ActivatedRoute, 
    private currentUserService: CurrentUserService, private router: Router, private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.buildMemberFormControls();
    this.init();
    this.sub = this.route.params.subscribe(params => {
      this.userName = params['userName']; 
   });

    this.userService.getMember(this.userName).subscribe(data => {
      this.gussmember = data.gussMember;
      this.appUser = data.appUser;
     
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  updateMemberState(gusssMember: Member) {
    this.currentUserService.changeMemberState(gusssMember);
  }

  public userInitialized(): boolean {
    let flag: boolean =false;
    if(this.currentUserService.currentMemberState != null) {
      flag = true;
    }
    return flag;
  }

  private init() {
    this.ADMIN_ROLE = UserRole.ADMIN;
    this.STAFF_ROLE = UserRole.STAFF;
    this.MEMBER_ROLE = UserRole.MEMBER;
  }

  onSubmitMemberLookUp() {
    console.log(this.memberLookUpForm.controls.memberId.value);
    this.router.navigate(['member-profile', this.memberLookUpForm.controls.memberId.value]);
    
  }

  private buildMemberFormControls() {
    this.memberLookUpForm= this._formBuilder.group({
      memberId: ['', Validators.required]});
    }    
}
