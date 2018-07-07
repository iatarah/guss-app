import { AppUser } from './../gen/dist/model/appUser.d';
import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../shared/user-profile/user-profile.service';
import {UserService} from '../gen/api/user.service';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService]
})
export class UserProfileComponent implements OnInit {
  memberProfile: AppUser;
  
  constructor(private userService: UserService) { }

  ngOnInit() {
    /*
    this.userProfileService.getAll().subscribe(data => {
      this.userProfile = data;
    })*/
    this.userService.getMember("johnDoe1@test.com").subscribe(data => {
      this.memberProfile = data.appUser;
    })
  }

}
