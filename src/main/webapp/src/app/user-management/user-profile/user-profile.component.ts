import { CurrentUserService } from './../../shared/current-user.service';
import { Member } from './../../gen/model/member';
import { UserService } from './../../gen/api/user.service';
import { AppUser } from './../../gen/dist/model/appUser.d';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit, OnDestroy {
  appUser: AppUser;
  gussmember: Member;
  userName: string;
  private sub: any;
  currentMember: Member;
  constructor(private userService: UserService, private route: ActivatedRoute, private currentUserService: CurrentUserService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.userName = params['userName']; 
   });

    this.userService.getMember(this.userName).subscribe(data => {
      this.appUser = data.appUser;
      this.gussmember = data.gussMember;
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
}
