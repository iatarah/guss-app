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
  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      this.userName = params['userName']; 
   });

    this.userService.getMember(this.userName).subscribe(data => {
      this.appUser = data.appUser;
      this.gussmember = data.gussMember;
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
